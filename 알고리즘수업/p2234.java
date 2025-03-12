import java.util.*;

public class p2234 {
    static int N, M; // N: 열(가로), M: 행(세로)
    static int[][] matrix; // 벽 정보
    static int[][] room; // 방 번호 저장
    static boolean[][] visited;
    static int[] roomSizes; // 방 크기 저장 배열
    static int roomCount = 0, maxRoomSize = 0, maxCombinedRoom = 0;
    
    static int[] dx = {0, -1, 0, 1}; // 서, 북, 동, 남
    static int[] dy = {-1, 0, 1, 0}; 
    static int[] bit = {1, 2, 4, 8}; // 벽을 나타내는 값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[M][N];
        visited = new boolean[M][N];
        room = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 1️⃣ 방 개수 및 가장 큰 방 크기 찾기
        List<Integer> roomSizeList = new ArrayList<>();
        int roomIndex = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int size = bfs(i, j, roomIndex);
                    roomSizeList.add(size);
                    maxRoomSize = Math.max(maxRoomSize, size);
                    roomIndex++;
                }
            }
        }
        roomCount = roomSizeList.size();
        roomSizes = roomSizeList.stream().mapToInt(i -> i).toArray();

        // 2️⃣ 하나의 벽을 제거하여 얻을 수 있는 가장 큰 방 찾기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                        if (room[i][j] != room[nx][ny]) { // 다른 방이면 합칠 수 있음
                            maxCombinedRoom = Math.max(maxCombinedRoom,
                                    roomSizes[room[i][j]] + roomSizes[room[nx][ny]]);
                        }
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(roomCount);
        System.out.println(maxRoomSize);
        System.out.println(maxCombinedRoom);
    }

    static int bfs(int x, int y, int roomIndex) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        room[x][y] = roomIndex;

        int size = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visited[nx][ny] && (matrix[cx][cy] & bit[d]) == 0) {
                        visited[nx][ny] = true;
                        room[nx][ny] = roomIndex;
                        q.add(new int[]{nx, ny});
                        size++;
                    }
                }
            }
        }

        return size;
    }
}

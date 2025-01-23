import java.util.*;
import java.io.*;

public class p16946 {
    static int N, M;
    static int[][] matrix;
    static int[][] result;
    static int[][] groupMap;
    static int[] groupSize;
    static int groupId = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new int[N][M];
        result = new int[N][M];
        groupMap = new int[N][M];
        visited = new boolean[N][M];
        groupSize = new int[N * M + 1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        // Step 1: 빈 칸 그룹화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    groupId++;
                    groupSize[groupId] = bfs(i, j);
                }
            }
        }

        // Step 2: 벽에 대한 결과 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    HashSet<Integer> adjacentGroups = new HashSet<>();
                    int totalSize = 1; // 벽 자체도 포함
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            int group = groupMap[nx][ny];
                            if (group > 0 && !adjacentGroups.contains(group)) {
                                adjacentGroups.add(group);
                                totalSize += groupSize[group];
                            }
                        }
                    }
                    result[i][j] = totalSize % 10; // 10으로 나눈 나머지
                }
            }
        }

        // Step 3: 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    // BFS를 사용한 그룹화
    public static int bfs(int x, int y) {
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[] {x, y});
        visited[x][y] = true;
        groupMap[x][y] = groupId;

        int size = 1; // 현재 그룹 크기
        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && matrix[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    groupMap[nx][ny] = groupId;
                    dq.add(new int[] {nx, ny});
                    size++;
                }
            }
        }
        return size;
    }
}

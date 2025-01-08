import java.util.*;
import java.io.*;

public class p16236 {
    static int matrix[][];
    static boolean visited[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N;
    static int babySize = 2;
    static int time = 0;
    static int eatenFishCount = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
                if (matrix[i][j] == 9) {
                    startX = i;
                    startY = j;
                    matrix[i][j] = 0; // 아기 상어 초기 위치를 빈칸으로 설정
                }
            }
        }

        // 시뮬레이션 반복
        while (true) {
            int result[] = bfs(startX, startY);
            if (result == null) break; // 더 이상 먹을 물고기가 없는 경우 종료

            int nextX = result[0];
            int nextY = result[1];
            int dist = result[2];

            // 이동 시간 추가
            time += dist;

            // 물고기 먹기
            eatenFishCount++;
            if (eatenFishCount == babySize) {
                babySize++;
                eatenFishCount = 0;
            }

            // 아기 상어 위치 업데이트
            startX = nextX;
            startY = nextY;
            matrix[nextX][nextY] = 0; // 물고기를 먹은 위치는 빈칸으로 설정
        }

        System.out.println(time);
    }

    static int[] bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> fishList = new ArrayList<>();
        visited = new boolean[N][N];

        queue.add(new int[] {startX, startY, 0}); // {x, y, 거리}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 먹을 수 있는 물고기
            if (matrix[x][y] > 0 && matrix[x][y] < babySize) {
                fishList.add(new int[] {x, y, dist});
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY]) {
                    if (matrix[nextX][nextY] <= babySize) { // 지나갈 수 있는 칸
                        visited[nextX][nextY] = true;
                        queue.add(new int[] {nextX, nextY, dist + 1});
                    }
                }
            }
        }

        if (fishList.isEmpty()) return null; // 먹을 물고기가 없으면 null 반환

        // 먹을 물고기 정렬 (거리 → 위쪽 → 왼쪽)
        fishList.sort((a, b) -> {
            if (a[2] == b[2]) { // 거리 같으면
                if (a[0] == b[0]) return a[1] - b[1]; // 행 같으면 열 비교
                return a[0] - b[0]; // 행 비교
            }
            return a[2] - b[2]; // 거리 비교
        });

        return fishList.get(0); // 가장 가까운 물고기 반환
    }
}

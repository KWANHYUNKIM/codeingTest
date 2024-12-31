import java.io.*;
import java.util.*;

public class p17086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄 입력: N, M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        // 다음 N줄 입력: 공간의 상태
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j}); // 아기 상어의 위치를 큐에 추가
                }
            }
        }

        // 8방향 이동 정의
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        int[][] distances = new int[N][M];
        for (int[] row : distances) Arrays.fill(row, Integer.MAX_VALUE);

        // 큐에 있는 아기 상어의 초기 위치를 거리 0으로 설정
        for (int[] shark : queue) {
            distances[shark[0]][shark[1]] = 0;
        }

        // BFS 실행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (grid[nx][ny] == 0 && distances[nx][ny] > distances[x][y] + 1) {
                        distances[nx][ny] = distances[x][y] + 1;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }

        // 최댓값 계산
        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    maxDistance = Math.max(maxDistance, distances[i][j]);
                }
            }
        }

        // 결과 출력
        System.out.println(maxDistance);
    }
}
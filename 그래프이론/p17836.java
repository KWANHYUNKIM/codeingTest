import java.util.*;
import java.io.*;

public class p17836 {
    static int N, M, T;
    static int matrix[][];
    static boolean visited[][][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        matrix = new int[N][M];
        visited = new boolean[N][M][2];  // visited[x][y][0]: 검 없음, visited[x][y][1]: 검 있음

        for (int i = 0; i < N; i++) {
            String input_[] = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(input_[j]);
            }
        }

        int result = bfs();

        if (result > T) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[] {0, 0, 0, 0});  // {x, y, 이동거리, sword}
        visited[0][0][0] = true;

        int minTime = Integer.MAX_VALUE;

        while (!dq.isEmpty()) {
            int current[] = dq.poll();

            int curX = current[0];
            int curY = current[1];
            int dist = current[2];
            int sword = current[3];

            // 도착 시 최단 거리 업데이트
            if (curX == N - 1 && curY == M - 1) {
                minTime = Math.min(minTime, dist);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    // 검 없이 진행
                    if (sword == 0) {
                        if (!visited[nextX][nextY][0]) {
                            if (matrix[nextX][nextY] == 0) { // 빈 공간 이동
                                visited[nextX][nextY][0] = true;
                                dq.add(new int[] {nextX, nextY, dist + 1, 0});
                            } else if (matrix[nextX][nextY] == 2) { // 검 획득
                                visited[nextX][nextY][1] = true;
                                dq.add(new int[] {nextX, nextY, dist + 1, 1});
                            }
                        }
                    }
                    // 검을 가진 경우, 벽도 통과 가능
                    if (sword == 1 && !visited[nextX][nextY][1]) {
                        visited[nextX][nextY][1] = true;
                        dq.add(new int[] {nextX, nextY, dist + 1, 1});
                    }
                }
            }
        }

        return minTime;
    }
}

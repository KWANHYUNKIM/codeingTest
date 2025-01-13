import java.util.*;
import java.io.*;

public class a2178 {
    static int dx[] = {1, -1, 0, 0}; // 아래, 위, 오른쪽, 왼쪽
    static int dy[] = {0, 0, 1, -1};
    static int N, M;
    static char matrix[][];
    static boolean visited[][];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input_ = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = input_.charAt(j);
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 1}); // {x, y, 거리}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 도착 지점에 도달하면 거리 반환
            if (x == N - 1 && y == M - 1) {
                return distance;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY] && matrix[nextX][nextY] == '1') {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, distance + 1}); // 다음 위치와 거리 저장
                }
            }
        }

        return -1; // 도달할 수 없는 경우 (문제 조건상 도달할 수 없을 가능성은 없음)
    }
}

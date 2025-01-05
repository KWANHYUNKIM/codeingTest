import java.util.*;
import java.io.*;

public class p13565 {
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int[][] matrix;
    static boolean[][] visited;
    static int M, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] value = br.readLine().split(" ");
        M = Integer.parseInt(value[0]);
        N = Integer.parseInt(value[1]);

        matrix = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            if (matrix[0][i] == 0 && !visited[0][i]) {
                if (bfs(0, i)) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

    static boolean bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == M - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visited[nx][ny] && matrix[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }
}
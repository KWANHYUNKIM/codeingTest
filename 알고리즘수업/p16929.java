import java.util.*;
import java.io.*;

public class p16929 {
    static int N, M;
    static char[][] matrix;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j, matrix[i][j])) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }

    static boolean bfs(int x, int y, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, -1, -1}); // x, y, parentX, parentY
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int parentX = current[2];
            int parentY = current[3];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && matrix[nextX][nextY] == color) {
                    // 사이클이 형성되었는지 확인
                    if (visited[nextX][nextY]) {
                        if (!(nextX == parentX && nextY == parentY)) {
                            return true;
                        }
                    } else {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, curX, curY});
                    }
                }
            }
        }

        return false;
    }
}
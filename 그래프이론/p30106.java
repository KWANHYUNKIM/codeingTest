import java.util.*;
import java.io.*;

public class p30106 {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] input_1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(input_1[j]);
            }
        }

        int count = 0; // 로봇 청소기를 작동한 횟수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 아직 방문하지 않은 영역에서 BFS 실행
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++; // 새로운 컴포넌트를 찾았으므로 작동 횟수 증가
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                // 범위 체크 및 방문 여부 확인
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]) {
                    // 높이 차이가 K 이하인 경우만 이동 가능
                    if (Math.abs(matrix[currentX][currentY] - matrix[nextX][nextY]) <= K) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}

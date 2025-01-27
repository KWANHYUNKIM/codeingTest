import java.util.*;
import java.io.*;

public class p7576 {
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N, M;
    static int matrix[][];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new int[M][N];

        Queue<int[]> queue = new LinkedList<>();

        // 입력받기
        for (int i = 0; i < M; i++) {
            String input_[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(input_[j]);
                // 익은 토마토(1) 큐에 추가
                if (matrix[i][j] == 1) {
                    queue.add(new int[]{i, j, 0}); // 초기 거리 0
                }
            }
        }

        // BFS 실행
        result = bfs(queue);

        // 결과 확인
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 토마토가 익지 못한 경우가 있으면 -1 출력
                if (matrix[i][j] == 0) {
                    result = -1;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static int bfs(Queue<int[]> queue) {
        int dist = 0;

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            dist = distance;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                    if (matrix[nextX][nextY] == 0) {
                        matrix[nextX][nextY] = 1;
                        queue.add(new int[]{nextX, nextY, distance + 1});
                    }
                }
            }
        }

        return dist;
    }
}

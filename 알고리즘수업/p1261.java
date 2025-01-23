import java.util.*;
import java.io.*;

public class p1261 {
    static int N, M;
    static boolean visited[][];
    static int matrix[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        visited = new boolean[N][M];
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = row.charAt(j) - '0'; // 문자 -> 숫자 변환
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        // deque를 사용하여 0-1 BFS 구현
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{0, 0, 0}); // x, y, 부순 벽의 개수
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];

            // 목표 지점 도달
            if (x == N - 1 && y == M - 1) {
                return cost;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 확인 및 방문 체크
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (matrix[nx][ny] == 0) {
                        // 빈 방: 비용 증가 없이 deque 앞에 추가
                        deque.addFirst(new int[]{nx, ny, cost});
                    } else {
                        // 벽: 비용 1 증가, deque 뒤에 추가
                        deque.addLast(new int[]{nx, ny, cost + 1});
                    }
                }
            }
        }

        return 0; 
    }
}

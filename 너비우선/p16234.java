import java.util.*;

public class p16234 {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우 이동
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break; // 더 이상 이동이 없다면 종료
            days++;
        }

        System.out.println(days);
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        queue.add(new int[] {x, y});
        union.add(new int[] {x, y});
        visited[x][y] = true;

        int totalPopulation = A[x][y];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(A[cx][cy] - A[nx][ny]);
                    if (diff >= L && diff <= R) {
                        queue.add(new int[] {nx, ny});
                        union.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        totalPopulation += A[nx][ny];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int newPopulation = totalPopulation / union.size();
            for (int[] pos : union) {
                A[pos[0]][pos[1]] = newPopulation;
            }
            return true; // 이동 발생
        }

        return false; // 이동 없음
    }
}

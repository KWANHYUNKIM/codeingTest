import java.util.*;
import java.io.*;

public class p17141 {
    static int N, M;
    static int[][] matrix;
    static List<int[]> virusList = new ArrayList<>();
    static int emptyCount = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
                if (matrix[i][j] == 2) {
                    virusList.add(new int[] {i, j}); // 바이러스 놓을 수 있는 위치
                } else if (matrix[i][j] == 0) {
                    emptyCount++; // 빈 칸 개수 세기
                }
            }
        }

        if (emptyCount == 0) {
            System.out.println(0); // 빈 칸이 없으면 바로 0 출력
            return;
        }

        // 바이러스 조합 생성 및 BFS 실행
        combination(new int[M], 0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    // 조합 생성
    public static void combination(int[] selected, int depth, int start) {
        if (depth == M) {
            bfs(selected); // 선택된 바이러스 조합으로 BFS 실행
            return;
        }
        for (int i = start; i < virusList.size(); i++) {
            selected[depth] = i;
            combination(selected, depth + 1, i + 1);
        }
    }

    // BFS로 바이러스 확산
    public static void bfs(int[] selected) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] time = new int[N][N];

        for (int idx : selected) {
            int[] virus = virusList.get(idx);
            queue.add(virus);
            visited[virus[0]][virus[1]] = true;
        }

        int spreadCount = 0;
        int maxTime = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && matrix[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                    time[nx][ny] = time[x][y] + 1;
                    if (matrix[nx][ny] == 0) {
                        spreadCount++;
                        maxTime = Math.max(maxTime, time[nx][ny]);
                    }
                }
            }
        }

        // 모든 빈 칸에 바이러스가 퍼졌는지 확인
        if (spreadCount == emptyCount) {
            result = Math.min(result, maxTime);
        }
    }
}

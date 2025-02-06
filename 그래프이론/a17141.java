import java.util.*;
import java.io.*;

public class a17141 {
    static int N, M, minTime = Integer.MAX_VALUE;
    static int[][] matrix;
    static List<int[]> virusList = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];

        // 연구소 정보 입력 및 바이러스 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
            }
        }

        // 바이러스를 놓을 수 있는 모든 조합 탐색
        combination(0, 0, new int[M]);

        // 결과 출력
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    // 바이러스를 놓을 M개의 위치를 선택하는 조합 생성
    static void combination(int index, int depth, int[] selected) {
        if (depth == M) {
            // 선택된 M개의 바이러스 위치로 BFS 실행
            bfs(selected);
            return;
        }
        for (int i = index; i < virusList.size(); i++) {
            selected[depth] = i;
            combination(i + 1, depth + 1, selected);
        }
    }

    // BFS 실행하여 바이러스 전파 시뮬레이션
    static void bfs(int[] selected) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N][N]; // 감염 시간 저장
        for (int[] row : dist) Arrays.fill(row, -1);

        // 선택된 바이러스 위치에서 BFS 시작
        for (int idx : selected) {
            int x = virusList.get(idx)[0];
            int y = virusList.get(idx)[1];
            queue.add(new int[]{x, y});
            dist[x][y] = 0;
        }

        int maxTime = 0; // 바이러스가 퍼지는 최대 시간

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && dist[nx][ny] == -1 && matrix[nx][ny] != 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                    maxTime = Math.max(maxTime, dist[nx][ny]);
                }
            }
        }

        // 모든 빈 칸이 감염되었는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0 && dist[i][j] == -1) {
                    return; // 모든 빈 칸이 감염되지 못하면 종료
                }
            }
        }

        // 최소 시간 갱신
        minTime = Math.min(minTime, maxTime);
    }
}

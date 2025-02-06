import java.util.*;
import java.io.*;

public class p1245 {
    static int N, M;
    static int matrix[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0, -1, -1, 1, 1}; // 8방향 (상, 하, 좌, 우, 대각선)
    static int dy[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean isPeak; // 현재 DFS 탐색하는 영역이 산봉우리인지 판단하는 변수

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input_[] = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(input_[j]);
            }
        }

        int peakCount = 0; // 산봉우리 개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) { // 방문하지 않은 좌표이면 DFS 수행
                    isPeak = true; // 산봉우리인지 확인할 플래그
                    dfs(i, j, matrix[i][j]);

                    if (isPeak) {
                        peakCount++; // 산봉우리 개수 증가
                    }
                }
            }
        }

        System.out.println(peakCount);
    }

    static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어나면 스킵
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            // 현재 높이보다 높은 값이 있으면 산봉우리가 아님
            if (matrix[nx][ny] > height) {
                isPeak = false;
            }

            // 같은 높이이면서 아직 방문하지 않은 경우 DFS 탐색
            if (matrix[nx][ny] == height && !visited[nx][ny]) {
                dfs(nx, ny, height);
            }
        }
    }
}

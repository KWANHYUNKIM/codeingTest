import java.util.*;
import java.io.*;

public class a17070 {
    static int N;
    static int[][] matrix;
    static int[][][] dp; // 3차원 DP 배열 (0: 가로, 1: 세로, 2: 대각선)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3]; // 0: 가로, 1: 세로, 2: 대각선

        // 입력 받기
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        // 초기 상태 설정 (1,2) 위치에 가로 파이프가 위치
        dp[1][2][0] = 1;

        // DP 테이블 채우기
        for (int x = 1; x <= N; x++) {
            for (int y = 2; y <= N; y++) {
                if (matrix[x][y] == 1) continue; // 벽이면 이동 불가

                // 가로 이동 가능
                if (y > 1 && matrix[x][y] == 0) {
                    dp[x][y][0] += dp[x][y - 1][0] + dp[x][y - 1][2]; // 가로 또는 대각선에서 오는 경우
                }

                // 세로 이동 가능 (x > 1일 때만 계산)
                if (x > 1 && matrix[x][y] == 0) {
                    dp[x][y][1] += dp[x - 1][y][1] + dp[x - 1][y][2]; // 세로 또는 대각선에서 오는 경우
                }

                // 대각선 이동 가능 (x > 1, y > 1일 때만 계산)
                if (x > 1 && y > 1 && matrix[x][y] == 0 &&
                    matrix[x - 1][y] == 0 && matrix[x][y - 1] == 0) {
                    dp[x][y][2] += dp[x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2];
                }
            }
        }

        // 최종 도착지 (N, N)의 총 경로 수 출력
        int result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(result);
    }
}

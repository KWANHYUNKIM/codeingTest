import java.io.*;
import java.util.*;

public class p11057 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 10007;

        // DP 배열 초기화
        int[][] dp = new int[N + 1][10];

        // 초기값 설정 (길이가 1일 때)
        for (int k = 0; k <= 9; k++) {
            dp[1][k] = 1;
        }

        // DP 점화식 계산
        for (int n = 2; n <= N; n++) {
            for (int k = 0; k <= 9; k++) {
                dp[n][k] = (k > 0 ? dp[n][k - 1] : 0) + dp[n - 1][k];
                dp[n][k] %= MOD; // 모듈러 연산 적용
            }
        }

        // 결과 계산
        int result = 0;
        for (int k = 0; k <= 9; k++) {
            result = (result + dp[N][k]) % MOD;
        }

        // 결과 출력
        System.out.println(result);
    }
}

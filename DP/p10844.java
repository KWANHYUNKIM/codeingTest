import java.util.*;

public class p10844 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[][] dp = new int[N + 1][10];

        // 초기값 설정
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;  
        }

        // DP 점화식 적용
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j + 1 <= 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= MOD;
            }
        }

        // 결과 합산
        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }

        System.out.println(sum);
    }
}

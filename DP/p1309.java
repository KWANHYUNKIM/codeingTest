import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class p1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 9901;
        
        // dp[i][0]: i번째 열에 사자가 없는 경우
        // dp[i][1]: i번째 열에 위쪽 칸에만 사자가 있는 경우
        // dp[i][2]: i번째 열에 아래쪽 칸에만 사자가 있는 경우
        int[][] dp = new int[N+1][3];
        
        // 첫 번째 열에 대한 초기값 (열 1)
        dp[1][0] = 1; // 사자 없음
        dp[1][1] = 1; // 위쪽에 사자
        dp[1][2] = 1; // 아래쪽에 사자
        
        // 두 번째 열부터 N번째 열까지 dp 점화식 적용
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }
        
        int result = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        System.out.println(result);
    }
}
import java.io.*;

public class p10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 길이 입력
        final int MOD = 1_000_000_000;

        // DP 테이블 정의
        long[][] dp = new long[N + 1][10];

        // 초기 조건
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1; // 길이 1에서 마지막 숫자가 1~9인 계단 수는 각각 1개
        }
        

        // DP 점화식
        for (int i = 2; i <= N; i++) { // 길이 2부터 N까지 계산
            for (int j = 0; j <= 9; j++) { // 마지막 숫자가 0~9일 때
                if (j > 0) dp[i][j] += dp[i - 1][j - 1]; // j-1에서 오는 경우
                if (j < 9) dp[i][j] += dp[i - 1][j + 1]; // j+1에서 오는 경우
                dp[i][j] %= MOD; // MOD로 나눈 나머지 저장
            }
        }

        // 결과 계산
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result += dp[N][j];
            result %= MOD;
        }

        // 결과 출력
        System.out.println(result);
    }
}

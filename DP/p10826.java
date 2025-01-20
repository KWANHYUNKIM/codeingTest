import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class p10826 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // BigInteger 배열 생성
        BigInteger[] dp = new BigInteger[N + 1];

        dp[0] = BigInteger.ZERO; // dp[0] = 0
        if (N > 0) {
            dp[1] = BigInteger.ONE; // dp[1] = 1
        }

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]); // dp[i] = dp[i-1] + dp[i-2]
        }

        System.out.println(dp[N]);
    }
}

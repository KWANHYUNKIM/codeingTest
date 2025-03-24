import java.util.*;
import java.io.*;

public class p2225{
    static final int MOD = 1_000_000_000;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int dp [][] = new int[ K + 1][N + 1];

        for(int n = 0; n <=N; n++){
            dp[1][n] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                dp[k][n] = (dp[k-1][n] + (n > 0 ? dp[k][n-1] : 0)) % MOD;
            }
        }
        // 정답 출력
        System.out.println(dp[K][N]);
    }
}
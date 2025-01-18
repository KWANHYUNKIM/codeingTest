import java.util.*;
import java.io.*;

public class p2749 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int P = 15 * (N / 10);
        int M = 1000000 ;
        long dp [] = new long [N + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <=N; i++){
            dp[i] = (dp[i -1] + dp[i -2]) % M;
        }
        System.out.println(dp[N % P]);

    }
}
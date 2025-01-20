import java.util.*;
import java.io.*;

public class p1309 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N + 1];

        dp[0] = 1;

        for(int i = 1 ; i <=N; i++){
            dp[i] += dp[i -1] + N * 2;
        }

        System.out.println(dp[N]);
    }
}
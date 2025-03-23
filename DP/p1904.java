import java.util.*;
import java.io.*;

public class p1904 {
    static int mod = 15746;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    

        int dp[] = new int[N +2];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=N; i++){
            dp[i] =  ( dp[i -1] + dp[i -2] ) % mod;
        }

        System.out.println(dp[N]);
    }
}
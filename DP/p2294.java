import java.util.*;
import java.io.*;

public class p2294{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
        int coins [] = new int [n];
        int dp[] = new int[k + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i = 0 ; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int coin : coins){
            for(int i = coin; i<=k; i++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}

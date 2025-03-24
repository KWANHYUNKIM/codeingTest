import java.util.*;
import java.io.*;

public class p1003{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int dp [][] = new int[N + 1][2];
            if(N == 0){
                System.out.println("1 0");
            }
            else if(N ==1){
                System.out.println("0 1");
            }
            else{
                dp[0][0] = 1;
                dp[0][1] = 0;
    
                dp[1][0] = 0;
                dp[1][1] = 1;
    
                dp[2][0] = 1;
                dp[2][1] = 1;
    
                for(int j= 2 ; j <=N; j++){
                    dp[j][0] = dp[j-2][0] + dp[j-1][0];
                    dp[j][1] = dp[j-2][1] + dp[j-1][1];
                }
                System.out.println(dp[N][0] + " " + dp[N][1]);
            }
        }
    }
}
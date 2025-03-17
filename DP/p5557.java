import java.util.*;
import java.io.*;

public class p5557{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int nums[] = new int [N];
        
        String input[] = br.readLine().split(" ");
        
        for(int i = 0 ; i < N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        long dp [][] = new long[N -1][21];

        dp[0][nums[0]] = 1;

        for(int i =1; i < N - 1; i++){
            for(int j = 0 ; j <= 20; j++){
                if (dp[i -1][j] > 0){
                    int plus = j + nums[i];
                    int minus = j - nums[i];

                    if(plus <= 20){
                        dp[i][plus] += dp[i -1][j];
                    }
                    if (minus >= 0){
                        dp[i][minus] += dp[i -1][j];
                    }
                }
            }
        }
        System.out.println(dp[N -2][nums[N -1]]);
    }
}
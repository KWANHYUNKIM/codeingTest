import java.util.*;
import java.io.*;

public class p1149 {
    static int matrix[][] ;
    static int dp[][];
    static int N ;
    static int MAX = Integer.MAX_VALUE;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        matrix = new int[N][3];
        dp = new int[N][3];
        
        for(int i = 0 ; i < N; i++){
            String input[] = br.readLine().split(" ");
            for(int j = 0 ; j < 3; j++){
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];

        for(int i = 1 ; i < N; i++){
            dp[i][0] = matrix[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = matrix[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = matrix[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int result = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));

        System.out.println(result);

    }
}
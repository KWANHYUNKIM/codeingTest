// LCS

import java.util.*;
import java.io.*;

public class p9251{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int N = A.length();
        int M = B.length();

        int dp [][] = new int[N +1][M + 1];

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                if(A.charAt(i -1) == B.charAt(j -1)){
                    dp[i][j] = dp[i -1][j -1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j -1]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
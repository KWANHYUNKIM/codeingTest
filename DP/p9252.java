import java.util.*;
import java.io.*;

public class p9252{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int n = A.length();
        int m = B.length();

        int dp[][] = new int[n + 1][m + 1];

        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=m; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    dp[i][j] = dp[i -1][j -1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i -1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
        if(dp[n][m] == 0) return;
        StringBuilder lcs = new StringBuilder();
        int i = n;
        int j = m;

        while(i > 0 && j > 0){
            if(A.charAt(i -1) == B.charAt(j -1)){
                lcs.append(A.charAt(i -1));
                i--;
                j--;
            }else{
                if(dp[ i - 1][j] >= dp[i][j -1]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        System.out.println(lcs.reverse().toString());
    }
}
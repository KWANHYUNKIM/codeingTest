import java.util.*;
import java.io.*;

public class p11053 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n];
        int A[] = new int[n];
        String input[] = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 각 원소는 자기 자신만으로 LIS가 될 수 있음
            A[i] = Integer.parseInt(input[i]);
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j= 0; j < i; j++){
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        // 결과 출력
        System.out.println(maxLength);
    }
}
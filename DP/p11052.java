import java.io.*;
import java.util.*;

public class p11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for(int i =1; i <= N; i++){
            dp[i] = 10001;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + P[j]);
            }
        }

        // 결과 출력
        System.out.println(dp[N]);
    }
}

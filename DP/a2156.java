import java.io.*;

public class a2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 포도주 잔의 개수
        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 설정
        if (n == 1) {
            System.out.println(wine[1]);
            return;
        }

        dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];
        if (n >= 3) dp[3] = Math.max(wine[1] + wine[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                     Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.println(dp[n]);
    }
}

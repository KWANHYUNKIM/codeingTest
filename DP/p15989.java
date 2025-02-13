import java.io.*;

public class p15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        int[] testCases = new int[T];
        int maxN = 0;

        // 입력받기
        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, testCases[i]);
        }

        // DP 배열 초기화
        int[] dp = new int[maxN + 1];

        // 초기값 설정
        dp[1] = 1; // 1: 1
        if (maxN >= 2) dp[2] = 2; // 2: 1+1, 2
        if (maxN >= 3) dp[3] = 4; // 3: 1+1+1, 1+2, 2+1, 3

        // 점화식 계산
        for (int i = 4; i <= maxN; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 결과 출력
        for (int n : testCases) {
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
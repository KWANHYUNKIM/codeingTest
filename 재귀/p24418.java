import java.util.*;
import java.io.*;

public class p24418 {
    static int countRec = 0; // 재귀 호출 횟수
    static int countDP = 0;  // DP 호출 횟수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 코드1: 재귀 호출 방식
        int resultRec = matrix_path_rec(matrix, N, N);

        // 코드2: DP 방식
        int resultDP = matrix_path_dp(matrix, N);

        // 출력
        System.out.println(countRec + 1 + " " + countDP);
    }

    // 재귀 호출 방식
    static int matrix_path_rec(int[][] m, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        } else {
            countRec++; // 코드1 호출 카운트
            return m[i - 1][j - 1] + Math.max(matrix_path_rec(m, i - 1, j), matrix_path_rec(m, i, j - 1));
        }
    }

    // 동적 프로그래밍 방식
    static int matrix_path_dp(int[][] m, int N) {
        int[][] dp = new int[N + 1][N + 1];

        // 초기화
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        // DP 배열 채우기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                countDP++; // 코드2 호출 카운트
                dp[i][j] = m[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[N][N];
    }
}

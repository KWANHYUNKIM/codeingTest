import java.util.*;
import java.io.*;

public class p1010 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            long result = combination(M, N);
            System.out.println(result);
        }
    }

    // 조합 계산 함수
    public static long combination(int n, int r) {
        r = Math.min(r, n - r); // 대칭성 활용 (nCr == nC(n-r))
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}

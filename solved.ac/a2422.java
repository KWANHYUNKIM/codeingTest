import java.io.*;
import java.util.*;

public class a2422 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        boolean[][] incompatible = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] input_ = br.readLine().split(" ");
            int C1 = Integer.parseInt(input_[0]);
            int C2 = Integer.parseInt(input_[1]);
            incompatible[C1][C2] = true;
            incompatible[C2][C1] = true; 
        }

        // 가능한 조합의 개수 계산
        int count = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (incompatible[i][j]) continue;
                for (int k = j + 1; k <= N; k++) {
                    if (!incompatible[i][k] && !incompatible[j][k]) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

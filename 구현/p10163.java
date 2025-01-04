import java.util.*;
import java.io.*;

public class p10163 {
    static int size = 1001;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = new int[size][size];
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int dx_1 = Integer.parseInt(input[0]); // 왼쪽 아래 x 좌표
            int dy_1 = Integer.parseInt(input[1]); // 왼쪽 아래 y 좌표
            int dx_2 = Integer.parseInt(input[2]); // 너비
            int dy_2 = Integer.parseInt(input[3]); // 높이

            for (int i = dx_1; i < dx_1 + dx_2; i++) {
                for (int j = dy_1; j < dy_1 + dy_2; j++) {
                    matrix[i][j] = count;
                }
            }
            count++;
        }

        int[] result = new int[count];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != 0) {
                    result[matrix[i][j]]++;
                }
            }
        }

        for (int i = 1; i < count; i++) {
            System.out.println(result[i]);
        }
    }
}

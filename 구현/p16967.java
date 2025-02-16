import java.util.*;
import java.io.*;

public class p16967{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]);
        int Y = Integer.parseInt(input[3]);

        int A [][] = new int[H][W];
        int B [][] = new int[H + X][W + Y];

        for(int i = 0 ; i < H + X; i++){
            String input_[] = br.readLine().split(" ");
            for(int j = 0 ; j < W + Y; j++){
                B[i][j] = Integer.parseInt(input_[j]);
            }
        }

        // A 배열 복원
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 겹치지 않는 부분은 B 그대로 복사
                if (i < X || j < Y) {
                    A[i][j] = B[i][j];
                } else {
                    // 겹치는 부분은 B에서 이미 저장된 A[i-X][j-Y]를 빼준다.
                    A[i][j] = B[i][j] - A[i - X][j - Y];
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
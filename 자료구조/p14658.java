import java.util.*;
import java.io.*;

public class p14658 {
    static int N, M, L, K;
    static int[][] stars;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 가로
        M = Integer.parseInt(input[1]); // 세로
        L = Integer.parseInt(input[2]); // 트램펄린 한변 길이
        K = Integer.parseInt(input[3]); // 별똥별 개수

        stars = new int[K][2];
        for (int i = 0; i < K; i++) {
            String[] starInfo = br.readLine().split(" ");
            stars[i][0] = Integer.parseInt(starInfo[0]); // x
            stars[i][1] = Integer.parseInt(starInfo[1]); // y
        }
        for(int i = 0 ; i < 2; i++){
        for(int j = 0 ; j < K; j++){
            System.out.print(stars[j][i] + " ");
        }
        System.out.println();
        }
        int max = 0;

        // 모든 별똥별 좌표를 시작점으로 LxL 사각형을 만들어보기
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int x1 = stars[i][0];
                int y1 = stars[j][1];
                int count = 0;

                // 이 (x1, y1)를 왼쪽 아래 모서리로 하는 트램펄린 범위에서 카운팅
                for (int k = 0; k < K; k++) {
                    int x = stars[k][0];
                    int y = stars[k][1];

                    if (x1 <= x && x <= x1 + L && y1 <= y && y <= y1 + L) {
                        count++;
                    }
                }

                max = Math.max(max, count);
            }
        }

        // 총 별똥별 - 트램펄린으로 튕겨낸 최대 개수 = 지구에 떨어지는 별
        System.out.println(K - max);
    }
}

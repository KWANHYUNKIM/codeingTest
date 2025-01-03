import java.util.*;
import java.io.*;

public class p2446 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int totalLines = 2 * N - 1;
        
        // 상단 삼각형
        for (int i = 0; i < N; i++) {
            // 왼쪽 공백
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 별
            for (int j = 0; j < (2 * (N - i) - 1); j++) {
                System.out.print("*");
            }
            System.out.println(); // 줄 바꿈
        }
        
        // 하단 삼각형
        for (int i = 1; i < N; i++) {
            // 왼쪽 공백
            for (int j = 0; j < (N - i - 1); j++) {
                System.out.print(" ");
            }
            // 별
            for (int j = 0; j < (2 * i + 1); j++) {
                System.out.print("*");
            }
            System.out.println(); // 줄 바꿈
        }
    }
}

import java.util.*;
import java.io.*;

public class p2567 {
    static int size = 100;
    static int matrix[][] = new int [size][size] ;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0 ; i < N; i++){
            String input[] = br.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);

            draw(startX,startY);
        }

        for(int i = 0 ; i < size; i++){
            for(int j = 0 ; j < size; j++){
                if(matrix[i][j] == 1){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
    static void draw(int startX, int startY) {
        // 10x10 사각형 그리기
        for (int i = startX; i < startX + 10; i++) {
            for (int j = startY; j < startY + 10; j++) {
                if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
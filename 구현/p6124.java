import java.util.*;
import java.io.*;

public class p6124{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input [] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int matrix[][] = new int [N][M];

        for(int i = 0 ; i < N; i++){
            String input_[] = br.readLine().split(" ");
            for(int j = 0 ; j < M; j++){
                matrix[i][j] = Integer.parseInt(input_[j]);
            }
        }
        int MAX = 0;
        int result = 0;
        int x = 0;
        int y = 0;

        for(int i = 0 ; i < N - 2; i++){
            for(int j = 0 ; j < M - 2; j++){
               result = Math.max(result , matrix[i][j] + matrix[i][j + 1] + matrix[i][j +2]
                + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2]);
                if(MAX < result){
                    MAX = result;
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        System.out.println(result);
        System.out.println(x + " " + y);
    }
}
import java.util.*;
import java.io.*;

public class p2522 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int end = 2 * N - 1;

        char matrix[][] = new char[end][N];

        for(int i = 0 ; i < end; i++){
            for(int j = 0 ; j < N; j++){
                matrix[i][j] = ' ';
            }
        }


       // for(int i = N - 1 ; i >= 0; i--){
        //   for(int j = i  ; j < end - i; j++){
        //       matrix[j][i] = '*';
       //    }
       // }

        // 별 배치
        for (int i = 0; i < N; i++) { // 윗부분
            for (int j = 0; j <  i + 1; j++) {
                matrix[i][j] = '*';
            }
        }
        for (int i = N; i < end; i++) { // 아랫부분
            for (int j = 0; j < end -i; j++) {
                matrix[i][j] = '*';
            }
        }

        for(int i = 0 ; i < end; i++){
            for(int j = 0 ; j < N; j++){
               System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        
    }
}
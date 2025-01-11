import java.util.*;
import java.io.*;

public class p10709 {
    static char matrix[][];
    static boolean visited[][];
    static int result[][];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        matrix = new char[H][W];
        visited = new boolean[H][W];
        result = new int[H][W];

        for(int i = 0 ;i < H; i++){
            String input_ = br.readLine();
            for(int j = 0 ; j < W; j++){
                matrix[i][j] = input_.charAt(j);
            }
        }

        for(int i = 0 ; i < H; i++){
            boolean check = false;
            int count = 0;
            for(int j = 0 ; j < W; j++){
                if(matrix[i][j] == '.' && check == false){
                    result[i][j] =  -1;
                }
                else if(matrix[i][j] == '.' && check == true){
                    result[i][j] = count;
                    count++;
                }
                else if(matrix[i][j] == 'c' && check == false){
                    result[i][j] = count;
                    count++;
                    check = true;
                }
                else if(matrix[i][j] == 'c' && check == true){
                    count = 0;
                    result[i][j] = count;
                    count++;
                    check = true;
                }
            }
        }

        for(int i = 0; i< H; i++){
            for(int j = 0; j < W; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
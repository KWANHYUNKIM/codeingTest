import java.util.*;
import java.io.*;

public class p6593{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input[] = br.readLine().split(" ");

            int Level = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int M = Integer.parseInt(input[2]);
            
            if(Level == 0 && N == 0 && M == 0){
                break;
            }

            char matrix[][] = new char [N][M];

            for(int z = 0; z < Level; z++){
                for(int i = 0 ; i < N; i++){
                    String input_ = br.readLine();
                    for(int j = 0 ; j < M; j++){
                        matrix[i][j] = input_.charAt(j);
                    }
                }
            }
        }
    }
}
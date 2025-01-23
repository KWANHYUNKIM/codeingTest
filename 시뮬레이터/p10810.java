import java.util.*;
import java.io.*;

public class p10810 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int bucket [] = new int[N + 1];

        // init

        for(int i = 1 ; i <=N; i++){
            bucket[i] = 0;
        }

        for(int z= 0 ; z < M; z++){
            String input_[] = br.readLine().split(" ");

            int i = Integer.parseInt(input_[0]);
            int j = Integer.parseInt(input_[1]);
            int k = Integer.parseInt(input_[2]);

            for(int s = i; s<= j; s++){
                bucket[s] = k;
            }
        }

        for(int i = 1; i <=N; i++){
            System.out.print(bucket[i] + " ");
        }
    }
}
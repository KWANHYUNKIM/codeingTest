import java.util.*;
import java.io.*;

public class p9358 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int C = 1;

        while(T-- != 0){
            int N = Integer.parseInt(br.readLine());
            int num [] = new int [N];
            String input[] = br.readLine().split(" ");

            for(int i = 0 ; i < N; i++){
                num[i] = Integer.parseInt(input[i]);
            }

            if(N == 2){
                if(num[0] > num[1]){
                    System.out.println("Case #"": Alice");
                }
                else{
                    System.out.println("Case #1: Bob");
                }
            }
            while(N != 2){
                StringBuilder sb = new StringBuilder();
                int left = 0;
                int right = N; 

                for(int i = 0 ; i < N; i++){
                    
                }

            } 
        }
    }
}
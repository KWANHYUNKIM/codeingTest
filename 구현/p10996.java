import java.util.*;
import java.io.*;

public class p10996 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int height = 2 * N - 1;
        int weight = N - 1;

        if(N == 1){
            System.out.print("*");
        }

        else{
            for(int i = 0 ; i <= height; i++){
                for(int j = 0 ; j <= weight; j++){
                    if(i % 2 == 0){
                        if(j % 2 == 0){
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
    
                    else{
                        if (j % 2 == 0){
                            System.out.print(" ");
                        }
                        else{
                            System.out.print("*");
                        }
                        
                    }
                    
                }
                System.out.println();
            }
        }
    }
}
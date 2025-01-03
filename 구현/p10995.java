import java.util.*;
import java.io.*;

public class p10995 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                if(i % 2 ==0){
                    System.out.print("*");
                    System.out.print(" ");
                }
                else{
                    System.out.print(" ");
                    System.out.print("*");
                }
                
            }
            System.out.println();
        }
    }
}
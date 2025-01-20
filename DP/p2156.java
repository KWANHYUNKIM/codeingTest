import java.util.*;
import java.io.*;

public class p2156 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int array[] = new int[N];

        for(int i = 0 ; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
        }
        int result = 0;;
        for(int i = 0 ; i < N; i++){
            
            if(N == 1){
                result = array[0];
            }
            else if(N == 2){
                result = array[0] + array[1];
            }
            else if(N == 3){
                result = Math.max(result, array[0] + array[1]);
                result = Math.max(result, array[1] + array[2]);
            }
            else{
                for(int j = 0 ; j < N - 2; j++){
                    result = Math.max(result, array[j] + array[j + 1]);
                }
            }
            
        }
        System.out.println(result);
    }
}
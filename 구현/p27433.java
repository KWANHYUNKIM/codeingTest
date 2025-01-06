import java.util.*;
import java.io.*;

public class p27433 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long result = factorial(N);

        System.out.println(result);

    }
    public static long factorial(int N){

        if(N == 0){
            return 1;
        }
        return N * factorial(N - 1);

    }
}
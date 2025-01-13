import java.util.*;
import java.io.*;

public class p1748 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(length(N));
        
    }
    public static long length(int N){
        long length = 0;
        int current = 1;
        int digit = 1;

        while( current * 10 - 1 <= N){
            length += (long) (current * 10 - current) * digit;
            current *= 10;
            digit++;
        }

        length += (long) (N - current + 1) * digit;

        return length;
    }
}
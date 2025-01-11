import java.util.*;
import java.io.*;

public class p1699 {
    static int count = 0;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while(N != 0){
            double value = Math.sqrt(N);
            int intValue = (int) value;
            System.out.println(intValue);
            N -= intValue * intValue;
            count++;
        }
        System.out.println(count);
    }
}
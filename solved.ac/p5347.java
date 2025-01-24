import java.util.*;
import java.io.*;

public class p5347 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- != 0){
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int LCD = LCD(a,b);
            System.out.println(LCD);
          //  System.out.println(a * b / gcd);
        }
    }
    public static int GCD(int num1 , int num2){
        if (num1 % num2 == 0){
            return num2;
        }
        return GCD(num2, num1 % num2);
    }
    public static int LCD(int num1, int num2){

        return num1 * num2 / GCD(num1, num2);
        
    }
}
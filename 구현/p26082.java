import java.util.*;
import java.io.*;

public class p26082 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]); // 경쟁사 제품의 가격 , 10
        int B = Integer.parseInt(input[1]); // 경쟁사 제품의 성능  , 100
        int C = Integer.parseInt(input[2]); // WARBOY 의 가격 C  , 7

        System.out.println( ( (B / A) * 3 ) * C);

    }
    

}

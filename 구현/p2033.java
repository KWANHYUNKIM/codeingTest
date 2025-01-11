import java.util.*;
import java.io.*;

public class p2033 {
    static int result = 0;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 15 , 446
        int count = String.valueOf(N).length(); // 2자릿수, 3자릿수

        int result = N;
        int place = 10;

        for(int i = 1 ; i < count; i++){
            result = (int) Math.round((double) result / place) * place;
            place *= 10;
        }
        System.out.println(result);
    }
}
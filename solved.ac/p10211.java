import java.util.*;
import java.io.*;

public class p10211 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N -- != 0){
            int T = Integer.parseInt(br.readLine());
            String input[] = br.readLine().split(" ");

            int result = 0;
            int left = 0;
            int right = input.length ;

            while(left != right - 1){
                int sum = 0;
                for(int i = left; i < right; i++){
                    sum += Integer.parseInt(input[i]);
                }
                result = Math.max(result, sum);
                left++;
            }
            System.out.println(result);
        }
    }
}
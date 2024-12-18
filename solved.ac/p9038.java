import java.util.*;
import java.io.*;

public class p9038 {
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new  BufferedReader (new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T -- != 0){
            int divided = Integer.parseInt(br.readLine());
            String input = br.readLine();

            int length = input.length();
            System.out.println("length 값은?" + length);
            int result = 0;

            if(length / divided == 0){
                result = length / divided;
            }else{
                result = (length / divided ) + 1;
            }

           System.out.println(result);
        }
    }
}
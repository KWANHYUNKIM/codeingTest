import java.util.*;
import java.io.*;

public class p16032 {
    static boolean check = true;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        
        while(check){
            int Input = Integer.parseInt(br.readLine());
            int count = 0;
            int sum = 0;
            if(Input == 0){
               break;
            }
            
            String array[] = br.readLine().split(" ");

            for(int i = 0 ; i < array.length; i++){
                sum += Integer.parseInt(array[i]);
            }

            int avg = sum / array.length;

            for(int i = 0 ; i < array.length; i++){
                if(avg >= Integer.parseInt(array[i])){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
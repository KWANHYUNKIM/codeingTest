import java.util.*;
import java.io.*;

public class p2033 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = String.valueOf(N).length();
        String value = "";
        for(int i = 1 ; i < count ; i++){

            if(i == 1){
                value += "1";
            }
            else{
                value += "0";
            }
        }
        
        int result = Integer.parseInt(value);

        System.out.println(customRound(N,result));
    }
    public static int customRound(int number, int place){

        return Math.round((float) number / place) * place;
    }
}
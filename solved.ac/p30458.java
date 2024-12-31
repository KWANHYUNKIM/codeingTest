import java.util.*;
import java.io.*;

public class p30458 {
    static int count = 0;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        N = N / 2;

        String compareA = "";
        String compareB = "";
        
        if(N % 2 == 0){ // 짝수
            compareA = input.substring(0,N);
            compareB = input.substring(N+1, input.length());
        }
        else{ // 홀수
            compareA = input.substring(0,N);
            compareB = input.substring(N+1, input.length());
        }

        HashMap hashMap = new HashMap<Character,String>();

        for(int i = 0 ; i < compareA.length(); i++){
            hashMap.put(compareA.charAt(i), "true");
        }

        for(int i = 0 ; i < compareB.length(); i++){

            if(hashMap.containsKey(compareB.charAt(i)) == true ){
                count++;
            }
            else{
                break;
            }
        }

        if(count == compareA.length()){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
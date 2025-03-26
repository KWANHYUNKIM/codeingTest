import java.util.*;
import java.io.*;

public class p8949{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input [] = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];

        int aLength = A.length();
        int bLength = B.length();
        if(aLength > bLength){
            for(int i = 0 ; i < aLength - bLength; i++ ){
                int value = A.charAt(i);
                sb.append(value -'0');
            }
            for(int i = 0; i < bLength; i++){
                int add = (A.charAt(aLength - bLength + i) -'0') + (B.charAt(i) - '0');
                sb.append(add);
            }
        }
        else if(aLength < bLength){

            for(int i = 0; i < bLength - aLength; i++ ){
                int value = B.charAt(i);
                sb.append(value -'0');
            }
            for(int i = 0; i < aLength; i++){
                int add = (A.charAt(i) -'0') + (B.charAt(bLength - aLength + i) - '0');
                sb.append(add);
            }
        }
        else{
            for(int i = 0 ; i < aLength; i++){
                int add = (A.charAt(i) -'0') + (B.charAt(i) - '0');
                sb.append(add);
            }
        }
        System.out.println(sb.toString());
    }
}
import java.util.*;
import java.io.*;

public class p14563 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hash = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        String input[] = br.readLine().split(" ");

        for(int i = 0 ; i < input.length; i++){
            hash.clear();
            int sum = 0;
            int number = Integer.parseInt(input[i]);

            for(int j = 1; j <=number; j++){
                
                if(number % j == 0){
                    hash.add(j);
                }
            }
            for(int check : hash){
                
                if(check != number){
                    sum += check;
                }
            }
            if(sum == number){
                System.out.println("Perfect");
            }
            else if(sum < number){
                System.out.println("Deficient");
            }
            else{
                System.out.println("Abundant");
            }
        }

    }
}
import java.util.*;
import java.io.*;

public class p17931 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input[] = br.readLine().split(" ");

        int array[] = new int[input.length];

        
        for(int i = 0 ; i < input.length; i++){
            array[i] = Integer.parseInt(input[i]);
        }
        LinkedList <Integer> result = new LinkedList<>();

        result.add(array[0]);
        int left = 0;
        int right = 1;

        
        for(int i = 0 ; i < input.length - 1; i++){ // 0 부터 6번 돈다. 
            
            if(array[left] < array[right]){
                result.add(array[right]);
            }
            left++;
            right++;
        }

        for(int i = 0 ; i < result.size(); i++){
            System.out.print(result.get(i));

            if(i != result.size() -1){
                System.out.print(" ");
            }
        }
    }
}
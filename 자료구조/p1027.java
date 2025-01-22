import java.util.*;
import java.io.*;

public class p1027 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input[] = br.readLine().split(" ");

        int arr [] = new int[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        int sum = 0 ;
        
        for(int i = 0 ;i < N; i++){
            int leftToRightCount  = 0;
            int rightToleftCount = 0;
            int total = 0;
            int value = arr[i];

            for(int j = i; j < N; j++){
                if(value >= arr[j]){
                    leftToRightCount++;
                }
                else{
                    break;
                }
            }

            for(int j = i; j > 0; j--){
                if(value >= arr[j]){
                    rightToleftCount++;
                }
                else{
                    break;
                }
            }
            System.out.println("i " + value + " " + "leftToRight " +leftToRightCount + " " + "rightToleft " + rightToleftCount);
            total = leftToRightCount + rightToleftCount;
            sum = Math.max(sum,total);
        }

        System.out.println(sum);
    }
}
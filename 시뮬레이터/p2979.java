import java.util.*;
import java.io.*;

public class p2979{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int time[] = new int[101];

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        for(int i = 0 ; i < 3; i++){
            String input_[] = br.readLine().split(" ");

            int start = Integer.parseInt(input_[0]);
            int end = Integer.parseInt(input_[1]);

            for(int j = start + 1; j<=end; j++){
                time[j] ++;
            }
        }
        int result = 0;

        for(int i =1; i <= 100 ; i++){
            if(time[i] == 3){
                result += C * 3;
            }
            else if(time[i] == 2){
                result += B * 2;
            }
            else if (time[i] == 1){
                result += A * 1;
            }
        }
        System.out.println(result);
    }
}
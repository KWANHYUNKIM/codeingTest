import java.util.*;
import java.io.*;

public class p6159 {
    static int result = 0;
    public static void main(String args[]) throws Exception{ 
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]); // 의상 길이 S 

        int cows[] = new int[N];

        for(int i = 0 ; i < N; i++){
            cows[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cows);

        // two points
        int left = 0;
        int right = N - 1;

        while(left < right){
            int sum = cows[left] + cows[right];

            if(S >= sum){
                result += (right - left);
                left++;
            }
            else{
                right--;
            }
        }
        System.out.print(result);
    }
}
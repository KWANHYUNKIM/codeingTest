import java.util.*;
import java.io.*;

public class p6986 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 7
        int K = Integer.parseInt(input[1]); // 2

        double arr[] = new double [N + 1];

        for(int i =1; i <= N ; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);

        double result_1 = average(N , K, arr);
        double result_2 = average_2(N, K, arr);
        System.out.printf("%.2f\n", result_1);
        System.out.printf("%.2f\n", result_2);
    }
    static double average(int N, int K, double arr[]){
        double result = 0;
        int count = 0;
        for(int i =  K + 1; i <= N - K; i++){
            result += arr[i];
            count++;
        }
        result = result / count ;
        return result;
    }
    static double average_2(int N, int K, double arr[]){
        double result = 0;
        int first = K + 1;
        int end = N - K;

        for(int i = 1; i < K + 1; i++){
            result += arr[first];
        }

        for(int i = K + 1; i<= N - K; i++){
            result += arr[i];
        }

        for(int i = N - K + 1 ; i <= N; i++ ){
            result += arr[end];
        }
        
        result = result / N;

        return result;
    }
}

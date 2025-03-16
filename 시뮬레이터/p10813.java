import java.util.*;
import java.io.*;

public class p10813{
    static int arr[];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String input []  = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        arr = new int [N + 1];

        for(int i = 1; i <=N ; i++){
            arr[i] = i;
        }

        for(int i = 0 ; i < M; i++){
            String input_[] = br.readLine().split(" ");
            int indexA = Integer.parseInt(input_[0]);
            int indexB = Integer.parseInt(input_[1]);

            swap (indexA, indexB);
        }

        for(int i =1; i <=N; i++){
            System.out.print(arr[i] + " ");
        }
    }
    static void swap(int a, int b){
        int valueA = arr[a];
        int valueB = arr[b];
        int swap  = valueA;

        arr[a] = valueB;
        arr[b] = swap;
    }
}
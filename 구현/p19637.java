import java.util.*;
import java.io.*;

public class p19637 {
    static class range{
        String name;
        int power;

        range(String name, int power){
            this.name = name;
            this.power = power;
        }
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        range matrix [] = new range [N];
        int result [] = new int [M];


        for(int i = 0 ; i < N; i++){
            String input_[] = br.readLine().split(" ");
            range value = new range(input_[0], Integer.parseInt(input_[1]));
            matrix[i] = value;
        }

        StringBuilder sb = new StringBuilder();


        for(int i = 0 ; i < M; i++){
            int query = Integer.parseInt(br.readLine());

            int idx = binarySearch(matrix ,query);
            sb.append(matrix[idx].name).append("\n");
        }
        System.out.print(sb.toString());
    }
    static int binarySearch(range matrix[], int query){
        int first = 0;
        int last = matrix.length -1;

        while(first < last){
            int mid = first + (last - first) / 2;

            if(matrix[mid].power >= query){
                last = mid;
            } else{
                first = mid + 1;
            }
        }

        return first;
    }
}

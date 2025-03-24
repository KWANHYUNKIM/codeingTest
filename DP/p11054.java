import java.util.*;
import java.io.*;

public class p11054{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");

        int arr [] = new int [N];
        for(int i = 0 ; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        
        int lis[] = new int[N];
        int lds[] = new int[N];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for(int i = 0; i < N; i++){
            for(int j = 0 ; j <i; j++){
                if(arr[j] < arr[i] && lis[i] < lis[j] + 1 ){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        
        for(int i = N -1; i >= 0; i--){
            for(int j = i + 1; j < N; j++){
                if( arr[i] > arr[j] && lds[i] < lds[j] + 1){
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for(int i = 0 ; i < N; i++){
            int bitonicLength = lis[i] + lds[i] - 1;
            if(bitonicLength > maxLength) {
                maxLength = bitonicLength;
            }
        }
        System.out.println(maxLength);
    }
}
import java.util.*;
import java.io.*;

public class p20551 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input [] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int A[] = new int [N];

        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        HashMap <Integer,Integer> hash = new HashMap<>();

        for(int i = 0 ; i < N; i++){
            if(!hash.containsKey(A[i])){
                hash.put(A[i],i);
            }
        }

        for(int i = 0 ; i < M; i++){
            int check = Integer.parseInt(br.readLine());

            if(hash.containsKey(check)){
                System.out.println(hash.get(check));
            }
            else{
                System.out.println("-1");
            }
        }

    }
}

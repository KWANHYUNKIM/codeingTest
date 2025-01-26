import java.util.*;
import java.io.*;

public class p4158{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap <String, Integer> hash = new HashMap<>();
        String input[] = br.readLine().split(" ");

        int size = 0;
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String arrN[] = new String [N];
        String arrM[] = new String [M];

        for(int i = 0 ; i < N; i++){
            arrN[i] = br.readLine();
            hash.put(arrN[i],hash.getOrDefault(arrN[i],0) + 1);
        }

        for(int i = 0 ; i < M; i++){
            arrM[i] = br.readLine();
            hash.put(arrM[i],hash.getOrDefault(arrM[i],0) + 1);
        }

        for(String value : hash.keySet()){
            if(hash.get(value) == 2){
                size++;
            }
        }

        String input_[] = br.readLine().split(" ");

        System.out.println(size);
    }
}
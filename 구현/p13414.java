import java.util.*;
import java.io.*;

public class p13414 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String,Integer> hashmap = new HashMap<>();
        
        for(int i = 0 ; i < M; i++){
            String input_ = br.readLine();
            hashmap.put(input_,i);
        }

        for (int i = 0; i < M; i++) {
            if (hashmap.containsValue(i)) {
                for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
                    if (entry.getValue().equals(i)) {
                        System.out.println(entry.getKey());
                        N--;
                    }
                    if(N == 0){
                        break;
                    }
                }
            }
        }
    }
}
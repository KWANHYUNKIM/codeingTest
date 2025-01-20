import java.util.*;
import java.io.*;

public class p10546 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 참가자 수 N

        HashMap<String,Integer> hashmap = new HashMap<>();

        for(int i = 0 ; i < N; i++){
            String str = br.readLine();
            hashmap.put(str,hashmap.getOrDefault(str,0) + 1);
        }

        for(int i = 0 ; i < N-1; i++){
            String str = br.readLine();
            
            hashmap.put(str,hashmap.getOrDefault(str,0) -1);
        }
        String result = "";

        for(String key : hashmap.keySet()){
            if(hashmap.get(key).equals(1)){
                result = key;
            }
        }
        System.out.println(result);
    }
}
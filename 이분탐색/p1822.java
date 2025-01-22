import java.util.*;
import java.io.*;

public class p1822 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        HashMap<String, Integer> graph = new HashMap<>();

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        String inputA[] = br.readLine().split(" ");
        String inputB[] = br.readLine().split(" ");

        for(int i = 0 ; i < inputA.length; i++){
            graph.put(inputA[i], graph.getOrDefault(inputA[i], 0) + 1);
        }
        for(int i = 0 ; i < inputB.length; i++){
            graph.put(inputB[i],graph.getOrDefault(inputB[i], 0) - 1);
        }
       ArrayList<Integer> result = new ArrayList<>();
      
       for(String key : graph.keySet()){
            
            if(graph.get(key) == 1){
                result.add(Integer.parseInt(key));
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i : result){
            System.out.print(i +" "); 
        }
    }
}
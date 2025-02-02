import java.util.*;
import java.io.*;

public class p2660{
    static LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i <=N; i++){
            graph.add(new LinkedList<>());
        }

        while(true){
            String input[] = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            if(a == -1 && b == -1){
                break;
            }
            else{
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
        }


    }
}
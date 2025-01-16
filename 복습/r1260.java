import java.util.*;
import java.io.*;

public class r1260 {
    static LinkedList<LinkedList<Integer>> graph ;
    static boolean visited[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int S = Integer.parseInt(input[2]);

        graph = new LinkedList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        for(int i = 0 ; i < M ; i++){
            String input_[] = br.readLine().split(" ");
            int v = Integer.parseInt(input_[0]);
            int e = Integer.parseInt(input_[1]);
            graph.get(v).add(e);
            graph.get(e).add(v);
        }

        for(int i = 1 ; i < M + 1; i++){
            Collections.sort(graph.get(i));
        }

        //System.out.println(graph);
        System.out.print(S + " ");
        dfs(S);
        Arrays.fill(visited,false);
        System.out.println();
        bfs(S);
        
    }
    static void bfs(int start){
        Queue <Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        System.out.print(start + " ");
        while(!queue.isEmpty()){
            
            int currentValue = queue.poll();

            for(int value : graph.get(currentValue) ){
                if(!visited[value]){
                    visited[value] = true;
                    System.out.print(value + " ");
                    queue.add(value);
                }
            }
        }
    }
    static void dfs(int start){
        visited[start] = true;
        for(int value : graph.get(start)){
            
            if(!visited[value]){
                visited[value] = true;
                int currentS = value;
                System.out.print(currentS + " ");
                dfs(currentS);
            }
        }
    }
}
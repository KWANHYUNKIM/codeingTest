import java.util.*;
import java.io.*;

public class p10451 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N -- != 0){


            int size = Integer.parseInt(br.readLine());
            String input[] = br.readLine().split(" ");

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i = 0 ; i <= size; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 1; i <=size; i++){
                int target = Integer.parseInt(input[i - 1]);
                graph.get(i).add(target);
            }

            boolean[] visited = new boolean[size + 1];
            int cycleCount = 0;

            for(int i = 1; i <=size; i++){
                if(!visited[i]){
                    dfs(graph,visited,i);
                    cycleCount++;
                }
            }

            System.out.println(cycleCount);
        }
    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node){
        visited[node] = true;
        for(int next : graph.get(node)) {
            if(!visited[next]){
                dfs(graph, visited, next);
            }
        }
    }
}
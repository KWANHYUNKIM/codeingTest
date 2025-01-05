import java.util.*;
import java.io.*;

public class p9372 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));


        int T = Integer.parseInt(br.readLine());

        while(T-- != 0){
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            String input[] = br.readLine().split(" ");

            int theNumberOfAirport = Integer.parseInt(input[0]);
            int size = Integer.parseInt(input[1]);

            // init : graph
            for(int i = 0 ; i < theNumberOfAirport + 1; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0 ; i < size; i++){
                String input_1[] = br.readLine().split((" "));
                graph.get(Integer.parseInt(input_1[0])).add(Integer.parseInt(input_1[1]));
                graph.get(Integer.parseInt(input_1[1])).add(Integer.parseInt(input_1[0]));
            }

            int result = bfs(graph, theNumberOfAirport);
            System.out.println(result);
        }
    }
    private static int bfs(ArrayList<ArrayList<Integer>> graph, int theNumberOfAirport){
        boolean[] visited = new boolean[theNumberOfAirport + 1];
        Queue<Integer> queue = new LinkedList<>();

        int visitedCount = 0;
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            visitedCount++;

            for(int neighhbor : graph.get(current)){
                if(!visited[neighhbor]){
                    visited[neighhbor] = true;
                    queue.add(neighhbor);
                }
            }
        }
        return theNumberOfAirport -1 ;
    }
}
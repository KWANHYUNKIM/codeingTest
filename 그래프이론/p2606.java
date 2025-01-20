import java.util.*;
import java.io.*;

public class p2606 {
    static LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
    static boolean visited[];
    static int N,M;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M = Integer.parseInt(br.readLine()); // 컴퓨터의 연결
        visited = new boolean [N + 1];

        for(int i = 0 ; i < N + 1; i++){
            graph.add(new LinkedList<>());
        }

        for(int i = 0 ; i < M; i++){
            String input[] = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            graph.get(a).add(e);
            graph.get(e).add(a);
        }

        System.out.println(graph.toString());

        dfs(1);
        int count = 0;
        for(int i = 0 ; i < visited.length; i++){
            if(visited[i] == true){
                count++;
            }
        }
        System.out.println(count - 1);

        Arrays.fill(visited,false);
        count = 0;
        bfs(1);

        for(int i = 0; i < visited.length; i++){
            if(visited[i] == true){
                count++;
            }
        }
        System.out.println(count -1);
        
    }
    static void dfs(int start){
        visited[start] = true;
        
        for(int s : graph.get(start)){
            
            if(!visited[s]){
                System.out.print(s + "->");
                dfs(s);
            }
        }
    }
    static void bfs(int start){
        visited[start] = true;
        Queue <int []> queue = new LinkedList<>();
        queue.add(new int[] {start});

        while(!queue.isEmpty()){
            int current [] = queue.poll();
            int s = current[0];

            for(int currentValue : graph.get(s)){
                if(!visited[currentValue]){
                    System.out.print(currentValue + "->");
                    visited[currentValue] = true;
                    queue.add(new int [] {currentValue});
                }
            }
        }
    }
}
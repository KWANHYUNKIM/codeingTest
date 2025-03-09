import java.util.*;
import java.io.*;

public class p18223{
    static class Node implements Comparable<Node>{
        int index, cost;

        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node other){
            return Integer.compare(this.cost, other.cost);
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static int V,E,P;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
       
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        P = Integer.parseInt(input[2]);

        graph = new ArrayList<>();

        for(int i = 0 ; i <=V ; i++ ){
            graph.add(new ArrayList<>());
        }

        for(int i= 0; i< E; i++){
            String input_[] = br.readLine().split(" ");
            int a = Integer.parseInt(input_[0]);
            int b = Integer.parseInt(input_[1]);
            int c = Integer.parseInt(input_[2]);

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        
        int result = bfs(1, V);
        int result2 = bfs(1, P) + bfs(P, V);

        if(result >= result2){
            System.out.println("SAVE HIM");
        }else{
            System.out.println("GOOD BYE");
        }
    }
    static int bfs(int start, int end){
        PriorityQueue <Node> pq = new PriorityQueue<>();
        int dist[] = new int [V + 1];
        boolean visited [] = new boolean [V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.offer(new Node(start ,0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int now = current.index;
            int cost = current.cost;
            if(visited[now]) continue;
            visited[now] = true;

            for(Node next : graph.get(now)){
                int nextIndex = next.index;
                int nextCost = next.cost;

                int newCost = dist[now] + nextCost;
                if (newCost < dist[nextIndex]) {
                    dist[nextIndex] = newCost;
                    pq.offer(new Node(nextIndex, newCost));
                }
            }
        }
        return dist[end];
    }
}
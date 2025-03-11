import java.util.*;
import java.io.*;

public class p14284{
    static class Node implements Comparable<Node>{
        int index, cost;
        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }

    }
    static int N,M;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i = 0 ; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M; i++){
            String input_[] = br.readLine().split(" ");
            int a = Integer.parseInt(input_[0]);
            int b = Integer.parseInt(input_[1]);
            int c = Integer.parseInt(input_[2]);

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        String input__[] = br.readLine().split(" ");
        int start = Integer.parseInt(input__[0]);
        int end = Integer.parseInt(input__[1]);

        int result = bfs(start,end);

        System.out.println(result);
    }
    static int bfs(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int dist[] = new int[N +1];
        pq.offer(new Node(start,0));
        Arrays.fill(dist, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            Node c = pq.poll();

            int c_index = c.index;
            int c_cost = c.cost;

            if (c_index == end) return c_cost;

            for(Node next : graph.get(c_index)){
                int next_index = next.index;
                int next_cost = next.cost;

                if(dist[next_index] > c_cost + next_cost){
                    dist[next_index] = c_cost + next_cost;
                    pq.offer(new Node(next_index, dist[next_index]));
                }
            }
        }
        return -1;
    }
}
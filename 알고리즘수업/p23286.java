import java.util.*;
import java.io.*;

public class p23286{
    static class Node implements Comparable<Node>{
        int v,h;
        Node(int v, int h){
            this.v = v;
            this.h = h;
        }
        @Override
        public int compareTo(Node other){
            return this.h - other.h;
        }
    }
    static int N,M;
    static int T;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        for(int i = 0 ; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M; i++){
            String input_[] = br.readLine().split(" ");
            int u = Integer.parseInt(input_[0]);
            int v = Integer.parseInt(input_[1]);
            int h = Integer.parseInt(input_[2]);

            graph.get(u).add(new Node(v,h));
        }

        for(int i = 0 ; i < T; i++){
            String input__[] = br.readLine().split(" ");

            int start = Integer.parseInt(input__[0]);
            int end = Integer.parseInt(input__[1]);
            
            int result = bfs(start,end);

            System.out.println(result);
        }
    }
    static int bfs(int start, int end){
        
        int [] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue <Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int curNode = current.v;
            int curMax = current.h;

            if(curNode == end) return curMax;

            if(curMax > dist[curNode]) continue;

            for(Node next : graph.get(curNode)){

                int nextCost = Math.max(curMax, next.h);

                if(nextCost < dist[next.v]){
                    dist[next.v] = nextCost;
                    pq.offer(new Node(next.v,nextCost));
                }
            }
        }
        return -1;
    }
}
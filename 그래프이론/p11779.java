import java.util.*;
import java.io.*;

public class p11779{
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
    static int N,M;
    static int[] prev;  // 최단 경로를 저장할 배열
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i <M; i++){
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph.get(a).add(new Node(b,c));
        }

        String input_[] = br.readLine().split(" ");

        int start = Integer.parseInt(input_[0]);
        int end = Integer.parseInt(input_[1]);

        int result = bfs(start, end);

        System.out.println(result);

        List<Integer> path = new ArrayList<>();
        int cur = end;
        while (cur != -1) {
            path.add(cur);
            cur = prev[cur];
        }

        System.out.println(path.size());
        Collections.reverse(path);

        for(int city : path){
            System.out.print(city + " ");
        }
    }
    static int bfs(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int dist[] = new int [N + 1];
        prev = new int [N + 1];

        pq.offer(new Node(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        dist[start] = 0;
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int current_index = current.index;
            int current_cost = current.cost;

            if(current_index == end){
                return current_cost;
            }

            for(Node next : graph.get(current_index)){
                int next_index = next.index;
                int next_cost = next.cost;
                
                if(dist[next_index] > current_cost + next_cost){
                    dist[next_index] = current_cost + next_cost;
                    prev[next_index] = current_index;
                    pq.offer(new Node(next_index, dist[next_index]));
                }
            }
        }
        return -1;
    }
}
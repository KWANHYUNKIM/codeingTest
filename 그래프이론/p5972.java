import java.util.*;
import java.io.*;

class Node_ implements Comparable<Node_>{
    int node, weight;
    Node_(int node, int weight){
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node_ o) {
        return Integer.compare(this.weight, o.weight);
    }

    @Override
    public String toString(){
        return "Node_(" + "node=" + node + ", weight=" + weight + ")";
    }
}

public class p5972 {
    static int N,M;
    static ArrayList<ArrayList<Node_>> graph = new ArrayList<>();
    static boolean visited[];
    static int[] dist;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new ArrayList<>();
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0 ; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            String input_[] = br.readLine().split(" ");
            int n = Integer.parseInt(input_[0]);
            int e = Integer.parseInt(input_[1]);
            int w = Integer.parseInt(input_[2]);

            graph.get(n).add(new Node_(e,w));
            graph.get(e).add(new Node_(n,w));
        }

        int result = bfs(1);

        System.out.println(result);
    }
    static int bfs(int s){
        //PriorityQueue<Node_> queue = new PriorityQueue<>();
        Queue<Node_> queue = new LinkedList<>();
        queue.add(new Node_(s, 0));
        dist[s] = 0;

        while(!queue.isEmpty()){
            Node_ current = queue.poll();
            int currentNode = current.node;
            int currentWeight = current.weight;
            
            if (dist[currentNode] < currentWeight) continue;

            for (Node_ neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.node;
                int nextWeight = neighbor.weight;

                // 현재 노드를 통해 가는 경로가 더 짧으면 업데이트
                if (dist[nextNode] > dist[currentNode] + nextWeight) {
                    dist[nextNode] = dist[currentNode] + nextWeight;
                    queue.add(new Node_(nextNode, dist[nextNode]));
                }
            }
        }

        return dist[N];
    }
}
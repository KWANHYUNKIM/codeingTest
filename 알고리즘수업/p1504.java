import java.util.*;
import java.io.*;

public class p1504 {
    static int N,M;
    static LinkedList<LinkedList<Node>> graph = new LinkedList<>();
    static class Node implements Comparable<Node> {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i = 0; i < M; i++){
            graph.add(new LinkedList<> ());
        }

        for(int i = 0 ; i < M; i++){
            String input_[] = br.readLine().split(" ");
            int to = Integer.parseInt(input_[0]);
            int from = Integer.parseInt(input_[1]);
            int dist = Integer.parseInt(input_[2]);

            graph.get(to).add(new Node(from, dist));
            graph.get(from).add(new Node(to, dist));
        }
        String input__[] = br.readLine().split(" ");
        int v1 = Integer.parseInt(input__[0]);
        int v2 = Integer.parseInt(input__[1]);
        
        
        long route1 = 0;
        route1 += dijkstra(1,v1);
        route1 += dijkstra(v1,v2);
        route1 += dijkstra(v2,N);

        long route2 = 0;
        route2 += dijkstra(1,v2);
        route2 += dijkstra(v2,v1);
        route2 += dijkstra(v1,N);

        long result = Math.min(route1, route2);

        // 경로가 없는 경우 처리
        if (route1 >= Integer.MAX_VALUE && route2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.to;
            int curDist = current.dist;

            if (curDist > dist[curNode]) continue;

            for (Node neighbor : graph.get(curNode)) {
                int nextNode = neighbor.to;
                int nextDist = curDist + neighbor.dist;

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.offer(new Node(nextNode, nextDist));
                }
            }
        }

        return dist[end];
    }
}
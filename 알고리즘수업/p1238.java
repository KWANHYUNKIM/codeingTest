import java.util.*;
import java.io.*;

public class p1238 {
    static class Node implements Comparable<Node> {
        int to, time;

        Node(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    static int N, M, X;
    static List<List<Node>> graph, reverseGraph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] road = br.readLine().split(" ");
            int from = Integer.parseInt(road[0]);
            int to = Integer.parseInt(road[1]);
            int time = Integer.parseInt(road[2]);

            graph.get(from).add(new Node(to, time));
            reverseGraph.get(to).add(new Node(from, time)); // 역방향 그래프
        }

        // 1. 다익스트라로 각 마을 -> X 최단 거리 계산
        int[] toX = dijkstra(graph, X);

        // 2. 다익스트라로 X -> 각 마을 최단 거리 계산
        int[] fromX = dijkstra(reverseGraph, X);

        // 3. 왕복 시간 계산
        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, toX[i] + fromX[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(List<List<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.to;
            int curTime = current.time;

            if (curTime > dist[curNode]) continue;

            for (Node neighbor : graph.get(curNode)) {
                int nextNode = neighbor.to;
                int nextTime = curTime + neighbor.time;

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.offer(new Node(nextNode, nextTime));
                }
            }
        }

        return dist;
    }
}

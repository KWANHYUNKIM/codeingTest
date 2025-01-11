import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int to, weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight; // 가중치 기준 오름차순 정렬
    }
    @Override
    public String toString() {
        return "{to: " + to + ", weight: " + weight + "}";
    }
}

public class p1753 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        int start = Integer.parseInt(br.readLine()); // 시작 정점

        // 그래프 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node " + i + ": " + graph.get(i));
        }        
        // 다익스트라 실행
        int[] dist = dijkstra(V, start, graph);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int[] dijkstra(int V, int start, List<List<Edge>> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        // 시작 노드 처리
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.to;
            int currentWeight = current.weight;

            // 현재 노드의 거리가 더 크면 무시
            if (currentWeight > dist[currentNode]) continue;

            // 인접 노드 탐색
            for (Edge edge : graph.get(currentNode)) {
                int nextNode = edge.to;
                int weight = edge.weight;
                int newDist = dist[currentNode] + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new Edge(nextNode, newDist));
                }
            }
        }

        return dist;
    }
}

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
        return this.weight - other.weight;
    }
}

public class p1916 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sizeOfCity = Integer.parseInt(br.readLine()); // 도시 개수
        int sizeOfBus = Integer.parseInt(br.readLine()); // 버스 개수

        // 도시 개수만큼 그래프 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= sizeOfCity; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 입력
        for (int i = 0; i < sizeOfBus; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]); // 출발 도시
            int v = Integer.parseInt(input[1]); // 도착 도시
            int w = Integer.parseInt(input[2]); // 버스 비용

            graph.get(u).add(new Edge(v, w));
        }

        // 출발점과 도착점 입력
        String[] input_ = br.readLine().split(" ");
        int start = Integer.parseInt(input_[0]);
        int end = Integer.parseInt(input_[1]);

        // 다익스트라 실행
        int result = dijkstra(start, end, sizeOfCity, graph);

        // 결과 출력
        System.out.println(result);
    }

    static int dijkstra(int start, int end, int sizeOfCity, List<List<Edge>> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[sizeOfCity + 1]; // 최소 비용 배열
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.offer(new Edge(start, 0)); // 시작 노드 추가

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.to;
            int currentWeight = current.weight;

            // 이미 처리된 경우 무시
            if (currentWeight > dist[currentNode]) continue;

            // 현재 노드와 연결된 모든 노드 탐색
            for (Edge edge : graph.get(currentNode)) {
                int nextNode = edge.to;
                int nextWeight = currentWeight + edge.weight;

                // 더 적은 비용으로 도달 가능하면 업데이트
                if (nextWeight < dist[nextNode]) {
                    dist[nextNode] = nextWeight;
                    pq.offer(new Edge(nextNode, nextWeight));
                }
            }
        }

        return dist[end];
    }
}
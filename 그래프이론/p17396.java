import java.util.*;
import java.io.*;

public class p17396 {
    static class Node implements Comparable<Node> {
        int index, cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost); // 최소 비용 우선
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<ArrayList<Node>> graph;
    static int[] siya;
    static int[] dist;
    static boolean[] visited; // 방문 여부 체크 추가

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        siya = new int[N];
        dist = new int[N];
        visited = new boolean[N]; // 방문 여부 배열 추가
        Arrays.fill(dist, INF);
        graph = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            siya[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, l));
            graph.get(b).add(new Node(a, l));
        }

        int result = dijkstra(0, N - 1);

        System.out.println(result);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // ✅ 처음부터 방문할 수 없는 곳은 큐에 넣지 않음
        if (siya[start] == 1) return -1;

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.index;
            int cost = current.cost;

            // ✅ 이미 방문한 정점이라면 무시
            if (visited[now]) continue;
            visited[now] = true;

            for (Node next : graph.get(now)) {
                int nextIndex = next.index;
                int nextCost = next.cost;

                // ✅ 상대 시야에 걸리는 곳은 이동 불가 (단, N-1(넥서스)는 예외적으로 가능)
                if (nextIndex != end && siya[nextIndex] == 1) continue;

                int newCost = dist[now] + nextCost;
                if (newCost < dist[nextIndex]) {
                    dist[nextIndex] = newCost;
                    pq.offer(new Node(nextIndex, newCost));
                }
            }
        }

        return (dist[end] == INF) ? -1 : dist[end];
    }
}

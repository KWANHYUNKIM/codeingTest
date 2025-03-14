import java.util.*;
import java.io.*;

public class p12834 {
    static class Node implements Comparable<Node> {
        int e, l;

        Node(int e, int l) {
            this.e = e;
            this.l = l;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.l, other.l);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, V, E, A, B;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] homes; // 팀원들의 집 위치

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // KIST 위치
        B = Integer.parseInt(st.nextToken()); // 씨알푸드 위치

        homes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(st.nextToken()); // 팀원의 집 위치 저장
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c)); // 무방향 그래프
        }

        // KIST(A)와 씨알푸드(B)까지 각각의 최단 거리 구하기
        int[] distFromA = dijkstra(A);
        int[] distFromB = dijkstra(B);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int home = homes[i];
            int distA = distFromA[home];
            int distB = distFromB[home];

            if (distA == INF && distB == INF) {
                sum += -2; // 둘 다 못 가면 -2
            } else if (distA == INF) {
                sum += distB - 1; // KIST만 못 가면 (B까지 거리 - 1)
            } else if (distB == INF) {
                sum += distA - 1; // 씨알푸드만 못 가면 (A까지 거리 - 1)
            } else {
                sum += distA + distB; // 정상적으로 갈 수 있으면 두 거리 합산
            }
        }

        System.out.println(sum);
    }

    // 다익스트라 알고리즘
    static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.e;
            int nowDist = current.l;

            if (dist[now] < nowDist) continue;

            for (Node next : graph.get(now)) {
                int cost = dist[now] + next.l;
                if (cost < dist[next.e]) {
                    dist[next.e] = cost;
                    pq.offer(new Node(next.e, cost));
                }
            }
        }
        return dist;
    }
}

import java.util.*;
import java.io.*;

public class p1240 {
    static class Node {
        int e, d;
        Node(int e, int d) {
            this.e = e;
            this.d = d;
        }
    }
    
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            int d = Integer.parseInt(edge[2]);

            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");
            int s = Integer.parseInt(query[0]);
            int e = Integer.parseInt(query[1]);
            int result = bfs(s, e, N);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
    
    static int bfs(int start, int end, int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(start, 0));
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.e == end) {
                return cur.d;
            }

            for (Node next : graph.get(cur.e)) {
                if (!visited[next.e]) {
                    visited[next.e] = true;
                    queue.offer(new Node(next.e, cur.d + next.d));
                }
            }
        }

        return -1;
    }
}

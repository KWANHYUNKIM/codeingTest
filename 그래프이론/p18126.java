import java.util.*;
import java.io.*;

public class p18126 {
    static class Node {
        int e;
        long d;
        Node(int e, long d) {
            this.e = e;
            this.d = d;
        }
    }
    
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long c = Long.parseLong(input[2]);
            
            // 양방향 연결
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        long result = bfs(1);
        System.out.println(result);
    }
    
    static long bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        visited[start] = true;
        long maxDist = 0;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            maxDist = Math.max(maxDist, cur.d);
            
            for (Node next : graph.get(cur.e)) {
                if (!visited[next.e]) {
                    visited[next.e] = true;
                    queue.offer(new Node(next.e, cur.d + next.d));
                }
            }
        }
        return maxDist;
    }
}

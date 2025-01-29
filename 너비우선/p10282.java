import java.util.*;
import java.io.*;

public class p10282{
    static class Node10282 implements Comparable<Node10282> {
        int e,s;
        Node10282(int e, int s){
            this.e = e;
            this.s = s;
        }
        @Override
        public int compareTo(Node10282 other) {
            return Integer.compare(this.s, other.s);
        }
    }
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T -- != 0){
            String input[] = br.readLine().split(" ");
            
            int N = Integer.parseInt(input[0]); // 컴퓨터 개수 N
            int D = Integer.parseInt(input[1]); // 의존성 개수 D
            int C = Integer.parseInt(input[2]); // 해킹당한 컴퓨터의 번호 C

            LinkedList<LinkedList<Node10282>> graph = new LinkedList<>();

            for(int i = 0 ; i <= N; i++){
                graph.add(new LinkedList<>());
            }

            for(int i = 0 ; i < D; i++){
                // A가 컴퓨터 B를 의존하며, 컴퓨터 B가 감염되면 S초 후 컴퓨터 A도 감염
                String input__[] = br.readLine().split(" ");
                int A = Integer.parseInt(input__[0]);
                int B = Integer.parseInt(input__[1]);
                int S = Integer.parseInt(input__[2]);

                //graph.get(A).add(new Node10282(B,S));
                graph.get(B).add(new Node10282(A,S));
            }
            int [] result = bfs(graph, N, C);

            System.out.println(result[0] + " " +result[1]);
        }
    }
    static int[] bfs(LinkedList<LinkedList<Node10282>> graph, int N , int start){
        PriorityQueue<Node10282> pq = new PriorityQueue<>();
        int [] dist = new int[ N + 1];
        Arrays.fill(dist, INF);
        
        pq.add(new Node10282(start, 0));
        dist[start] = 0;

        int count = 0 ;
        int lastTime = 0;

        while(!pq.isEmpty()){
            Node10282 current = pq.poll();
            int now = current.e;
            int time = current.s;

            if(dist[now] < time) continue;

            count++;

            lastTime = Math.max(lastTime, time);

            for(Node10282 next : graph.get(now)){
                int nextTime = time + next.s;
                if(nextTime < dist[next.e]){
                    dist[next.e] = nextTime;
                    pq.add(new Node10282(next.e, nextTime));
                }
            }
        }

        return new int[] {count, lastTime};
    }
}
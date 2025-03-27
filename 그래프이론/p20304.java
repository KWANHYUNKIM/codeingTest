import java.util.*;
import java.io.*;

public class p20304{
    static int N,M;
    static int [] dist;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        Arrays.fill(dist, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++){
            int pwd = Integer.parseInt(st.nextToken());
            dist[pwd] = 0;
            q.add(pwd);
        }

        System.out.println(bfs());
    }
    static int bfs(){
        int maxDistance = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int bit = 1; bit <=N; bit <<= 1){
                int next = cur ^ bit;

                if(next <= N && dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    maxDistance = Math.max(maxDistance, dist[next]);
                    q.add(next);
                }
            }
        }
        return maxDistance;
    }
}
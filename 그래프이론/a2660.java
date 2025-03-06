import java.io.*;
import java.util.*;

public class a2660{
    static final int INF = 51;
    static int dist[][];
    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];

        for(int i =1; i <= N; i++){
            Arrays.fill(dist[i],INF);
            dist[i][i] = 0;
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;

            dist[a][b] = 1; // 친구 관계는 양방향
            dist[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) { // 경유 노드
            for (int i = 1; i <= N; i++) { // 출발 노드
                for (int j = 1; j <= N; j++) { // 도착 노드
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i= 1; i <=N; i++){
            for(int j = 1; j <=N; j++){
                System.out.print(dist[i][j] +" ");
            }
            System.out.println();
        }

    }
}
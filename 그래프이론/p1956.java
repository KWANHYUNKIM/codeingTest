import java.util.*;
import java.io.*;

public class p1956{
    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        // INF는 충분히 큰 값으로 설정 (문제에서 간선 비용은 최대 10,000, 정점 수는 최대 400)
        final int INF = 1_000_000_000;
        
        // 1번부터 V번까지 사용하므로 크기를 V+1로 함
        int[][] dist = new int[V + 1][V + 1];
        
        // 초기화: 자기 자신으로의 거리는 0, 나머지는 INF로 초기화
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        
        // 간선 정보 입력: a번 마을에서 b번 마을로 가는 거리가 c
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            // a -> b 비용 갱신
            dist[a][b] = c;
        }
        
        // 플로이드 와샬 알고리즘 수행:
        // 모든 중간 정점 k를 거쳐가는 경우를 고려하여
        // 모든 정점 i에서 j로의 최단 거리를 갱신한다.
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // 최소 사이클 찾기
        // 사이클은 두 정점 i와 j (i != j) 사이에 i -> j, j -> i의 경로가 있을 때 형성됨.
        int answer = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue; // 같은 정점은 건너뜁니다.
                if (dist[i][j] < INF && dist[j][i] < INF) {
                    answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
            }
        }
        
        // 만약 최소 사이클이 존재하지 않으면 answer는 INF이므로 -1 출력
        System.out.println(answer == INF ? -1 : answer);
    }
}

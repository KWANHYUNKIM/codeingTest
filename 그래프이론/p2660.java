import java.util.*;
import java.io.*;

public class p2660 {
    static final int INF = 51; // 최대 회원 수는 50명이므로 충분히 큰 값 설정
    static int[][] dist;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 거리 배열 초기화 (자기 자신은 0, 나머지는 INF)
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신과의 거리는 0
        }

        // 친구 관계 입력받기
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        // 플로이드-워셜 알고리즘 수행
        for (int k = 1; k <= N; k++) { // 경유 노드
            for (int i = 1; i <= N; i++) { // 출발 노드
                for (int j = 1; j <= N; j++) { // 도착 노드
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 각 회원의 점수 계산 (가장 먼 사람까지의 최단 거리)
        int[] scores = new int[N + 1];
        int minScore = INF;

        for (int i = 1; i <= N; i++) {
            int maxDist = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) maxDist = Math.max(maxDist, dist[i][j]);
            }
            scores[i] = maxDist;
            minScore = Math.min(minScore, maxDist); // 최소 점수 갱신
        }

        // 회장 후보 찾기
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        // 출력
        System.out.println(minScore + " " + candidates.size());
        for (int candidate : candidates) {
            System.out.print(candidate + " ");
        }
        System.out.println();
    }
}

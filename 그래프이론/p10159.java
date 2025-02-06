import java.io.*;
import java.util.*;

public class p10159 {
    static final int INF = 0; // 비교가 불가능한 경우 (초기 상태)
    static int N, M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 물건 개수
        M = Integer.parseInt(br.readLine()); // 비교 결과 개수
        graph = new int[N + 1][N + 1]; // 1-based index 사용

        // 비교 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;  // a > b (a가 b보다 무겁다)
            graph[b][a] = -1; // b < a (b가 a보다 가볍다)
        }

        // 플로이드-워셜 알고리즘 실행
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1; // i > k > j 이므로 i > j
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1; // i < k < j 이므로 i < j
                    }
                }
            }
        }

        // 각 물건별 비교 불가능한 개수 출력
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j && graph[i][j] == INF) { // 자기 자신 제외하고 비교 불가능한 경우 카운트
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

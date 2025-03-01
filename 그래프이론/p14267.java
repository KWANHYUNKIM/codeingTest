import java.util.*;
import java.io.*;

public class p14267 {
    static List<Integer>[] graph;
    static int[] praise;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 직원 수
        int M = Integer.parseInt(st.nextToken()); // 칭찬 횟수

        graph = new ArrayList[N + 1];
        praise = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss != -1) {
                graph[boss].add(i); // 상사가 부하를 가리키도록 트리 구성
            }
        }

        // 칭찬 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            praise[employee] += amount;
        }

        // DFS로 칭찬 전파
        dfs(1);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(praise[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int employee) {
        for (int subordinate : graph[employee]) {
            praise[subordinate] += praise[employee]; // 부모의 칭찬을 자식에게 전파
            dfs(subordinate);
        }
    }
}

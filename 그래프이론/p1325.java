import java.util.*;
import java.io.*;

public class p1325 {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dp; // 메모이제이션 배열

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 신뢰 관계 입력 (단방향 그래프)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a); // b를 해킹하면 a도 해킹 가능
        }

        dp = new int[N + 1]; // DP 배열 초기화 (0이면 아직 계산되지 않음)

        int maxValue = 0; // 최대 해킹 개수 저장
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1]; // 방문 배열 초기화
            dp[i] = dfs(i); // DFS 실행하여 방문 가능한 개수 저장
            maxValue = Math.max(maxValue, dp[i]); // 최댓값 갱신
        }

        // 최댓값을 가지는 노드 찾기
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dp[i] == maxValue) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim()); // 정답 출력
    }

    // DFS 탐색 (메모이제이션 적용)
    static int dfs(int node) {
        if (dp[node] != 0) return dp[node]; // 이미 계산된 값이 있으면 반환

        visited[node] = true;
        int count = 1; // 자기 자신 포함

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count += dfs(next); // 방문 가능한 노드 개수 추가
            }
        }

        return dp[node] = count; // 메모이제이션 저장 후 반환
    }
}

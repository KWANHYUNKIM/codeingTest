import java.util.*;
import java.io.*;

public class p3182 {
    static boolean[] visited;
    static int[] graph;
    static int maxCount = 0;
    static int bestSenior = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 선배 수 입력
        int N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new int[N + 1];

        // 그래프 입력
        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        // 모든 선배를 시작점으로 탐색
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int count = dfs(i);

            // 최대 방문 수 갱신
            if (count > maxCount || (count == maxCount && i < bestSenior)) {
                maxCount = count;
                bestSenior = i;
            }
        }

        // 결과 출력
        System.out.println(bestSenior);
    }

    // DFS 구현
    static int dfs(int current) {
        visited[current] = true;
        int count = 1; // 현재 선배도 방문한 것으로 카운트

        int next = graph[current];
        if (!visited[next]) {
            count += dfs(next); // 다음 선배로 이동
        }

        return count;
    }
}

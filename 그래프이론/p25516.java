import java.util.*;
import java.io.*;

public class p25516 {
    static int N, K;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. N (노드 개수), K (최대 거리)
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        // 2. 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 3. 트리 간선 입력 받기 (트리는 N-1개의 간선 존재)
        for (int i = 0; i < N - 1; i++) {
            String[] input_ = br.readLine().split(" ");
            int P = Integer.parseInt(input_[0]);
            int C = Integer.parseInt(input_[1]);

            graph.get(P).add(C);
            graph.get(C).add(P); // 양방향 그래프 (부모-자식 관계 유지)
        }

        // 4. BFS 탐색 시작 (루트 노드에서 거리 K 이하 노드 찾기)
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N]; // 방문 여부 확인

        queue.add(0); // 루트(0번)에서 시작
        visited[0] = true;
        int depth = 0;
        int result = 0;

        String[] apples = br.readLine().split(" "); // 각 노드의 사과 개수

        while (!queue.isEmpty() && depth <= K) {
            int size = queue.size(); // 현재 깊이에서 탐색할 노드 개수

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                result += Integer.parseInt(apples[node]); // 사과 개수 더하기

                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            depth++; // 깊이 증가
        }

        System.out.println(result);
    }
}

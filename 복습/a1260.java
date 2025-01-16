import java.util.*;
import java.io.*;

public class a1260 {
    static LinkedList<LinkedList<Integer>> graph;
    static boolean visited[];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 노드 개수
        int M = Integer.parseInt(input[1]); // 엣지 개수
        int S = Integer.parseInt(input[2]); // 시작 노드

        graph = new LinkedList<>();
        visited = new boolean[N + 1]; // 1-based index를 위해 N+1 크기로 설정

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        // 엣지 정보 입력
        for (int i = 0; i < M; i++) {
            String input_[] = br.readLine().split(" ");
            int v = Integer.parseInt(input_[0]);
            int e = Integer.parseInt(input_[1]);
            graph.get(v).add(e);
            graph.get(e).add(v);
        }

        // 각 노드의 연결 리스트 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 실행
        System.out.print(S + " ");
        dfs(S);

        // 방문 배열 초기화 후 BFS 실행
        Arrays.fill(visited, false);
        System.out.println();
        bfs(S);
    }

    // BFS 구현
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        System.out.print(start + " ");
        while (!queue.isEmpty()) {
            int currentValue = queue.poll();
            for (int value : graph.get(currentValue)) {
                if (!visited[value]) {
                    visited[value] = true;
                    System.out.print(value + " ");
                    queue.add(value);
                }
            }
        }
    }

    // DFS 구현
    static void dfs(int start) {
        visited[start] = true;
        for (int value : graph.get(start)) {
            if (!visited[value]) {
                visited[value] = true;
                System.out.print(value + " ");
                dfs(value);
            }
        }
    }
}
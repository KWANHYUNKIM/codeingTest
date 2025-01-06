import java.util.*;
import java.io.*;

public class p5107 {
    static int testCase = 0;
    static Map<String, Integer> nameToIndex;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] lowLink;
    static int[] ids;
    static boolean[] onStack;
    static Stack<Integer> stack;
    static int id, sccCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break; // 입력 종료

            testCase++;
            nameToIndex = new HashMap<>();
            graph = new ArrayList<>();
            id = 0;
            sccCount = 0;

            // 그래프 초기화
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            // 입력 처리
            int index = 0;
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                String from = input[0];
                String to = input[1];

                // 이름 -> 인덱스 매핑
                nameToIndex.putIfAbsent(from, index);
                if (index >= graph.size()) {
                    graph.add(new ArrayList<>()); // 새로운 리스트 추가
                }
                index++;

                nameToIndex.putIfAbsent(to, index);
                if (index >= graph.size()) {
                    graph.add(new ArrayList<>()); // 새로운 리스트 추가
                }
                index++;

                // 그래프에 간선 추가
                int u = nameToIndex.get(from);
                int v = nameToIndex.get(to);
                graph.get(u).add(v);
            }

            // SCC 탐색 준비
            visited = new boolean[graph.size()];
            lowLink = new int[graph.size()];
            ids = new int[graph.size()];
            onStack = new boolean[graph.size()];
            stack = new Stack<>();

            Arrays.fill(ids, -1); // 초기값 -1

            // SCC 찾기
            for (int i = 0; i < graph.size(); i++) {
                if (ids[i] == -1) {
                    dfs(i);
                }
            }

            // 결과 저장
            result.append(testCase).append(" ").append(sccCount).append("\n");
        }

        // 결과 출력
        System.out.print(result.toString());
    }

    static void dfs(int at) {
        stack.push(at);
        onStack[at] = true;
        ids[at] = lowLink[at] = id++;

        for (int to : graph.get(at)) {
            if (ids[to] == -1) { // 방문하지 않은 노드
                dfs(to);
                lowLink[at] = Math.min(lowLink[at], lowLink[to]);
            } else if (onStack[to]) { // 스택에 있는 노드
                lowLink[at] = Math.min(lowLink[at], ids[to]);
            }
        }

        // SCC 발견
        if (ids[at] == lowLink[at]) {
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                lowLink[node] = ids[at];
                if (node == at) break;
            }
            sccCount++;
        }
    }
}

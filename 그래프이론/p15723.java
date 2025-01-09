import java.util.*;
import java.io.*;

public class p15723 {
    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        int N = Integer.parseInt(br.readLine());
        
        // 그래프 초기화
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String from = input[0]; // a
            String to = input[2];   // b
            
            // 그래프에 관계 저장
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }

        // 디버깅: 그래프 상태 출력
        System.out.println("Graph: " + graph);

        // 결론 입력 처리
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");
            String start = query[0];
            String end = query[2];

            // 방문 여부 초기화
            visited.clear();

            // DFS 탐색으로 참/거짓 판별
            boolean result = dfs(start, end);

            // 디버깅: 결과 확인
            //System.out.println("DFS from " + start + " to " + end + ": " + result);
            //System.out.println("Visited: " + visited);

            if (result) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
    }

    // DFS 함수
    static boolean dfs(String start, String end) {
        if (start.equals(end)) {
            return true;
        }
        
        visited.add(start);

        if (graph.containsKey(start)) {
            for (String neighbor : graph.get(start)) {
                if (!visited.contains(neighbor)) {
                    if (dfs(neighbor, end)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

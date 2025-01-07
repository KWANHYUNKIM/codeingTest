import java.util.*;
import java.io.*;

public class p14496 {
    // 내부 클래스에 static 추가
    static class State {
        int s, count;

        State(int s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        String[] input_1 = br.readLine().split(" ");
        int N = Integer.parseInt(input_1[0]); // 전체 문자의 수 N
        int M = Integer.parseInt(input_1[1]); // 치환 가능한 문자쌍의 수 M

        visited = new boolean[N + 1]; // 1부터 N까지 사용

        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input_3 = br.readLine().split(" ");
            int e = Integer.parseInt(input_3[0]);
            int s = Integer.parseInt(input_3[1]);

            graph.get(e).add(s);
            graph.get(s).add(e);
        }

        int result = bfs(graph, start, end);
        System.out.println(result);
    }

    static int bfs(LinkedList<LinkedList<Integer>> graph, int start, int end) {
        Queue<State> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new State(start, 0)); // State 객체 생성

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.s == end) {
                return current.count;
            }

            for (int next : graph.get(current.s)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new State(next, current.count + 1));
                }
            }
        }

        return -1; // 연결되지 않은 경우
    }
}
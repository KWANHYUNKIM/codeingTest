import java.util.*;
import java.io.*;

public class p1976 {
    static int N, M;
    static LinkedList<LinkedList<Integer>> graph;
    static boolean visited[];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 도시의 수
        M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수 

        graph = new LinkedList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (input[j].equals("1")) {
                    graph.get(i + 1).add(j + 1);
                }
            }
        }

        bfs(1); // 1번 도시부터 BFS 시작

        String tripSchedule[] = br.readLine().split(" ");
        boolean isConnected = true;
        for (String city : tripSchedule) {
            if (!visited[Integer.parseInt(city)]) {
                isConnected = false;
                break;
            }
        }

        System.out.print(isConnected ? "YES" : "NO");
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int value : graph.get(current)) {
                if (!visited[value]) {
                    visited[value] = true;
                    queue.add(value);
                }
            }
        }
    }
}

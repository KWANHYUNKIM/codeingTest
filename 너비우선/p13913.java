import java.util.*;
import java.io.*;

public class p13913 {
    static boolean[] visited; // 방문 여부
    static int[] path; // 경로 추적용 배열
    static int start, end;
    static final int MAX = 100001; // 최대 범위 (0부터 100,000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        // 초기화
        visited = new boolean[MAX];
        path = new int[MAX];

        // BFS 수행
        bfs(start);

        // 경로 출력
        printPath();
    }

    static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        path[s] = -1; // 시작점의 이전 노드 없음

        while (!queue.isEmpty()) {
            int x = queue.poll();

            // 종료 조건: 목표 위치 도달
            if (x == end) {
                return;
            }

            // 이동 가능한 위치 탐색
            for (int next : new int[]{x - 1, x + 1, x * 2}) {
                if (next >= 0 && next < MAX && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    path[next] = x; // 이전 노드 저장
                }
            }
        }
    }

    static void printPath() {
        // 최단 거리 계산
        List<Integer> resultPath = new ArrayList<>();
        for (int i = end; i != -1; i = path[i]) {
            resultPath.add(i);
        }

        // 역순으로 출력
        Collections.reverse(resultPath);
        System.out.println(resultPath.size() - 1); // 이동 횟수 출력
        for (int node : resultPath) {
            System.out.print(node + " ");
        }
    }
}
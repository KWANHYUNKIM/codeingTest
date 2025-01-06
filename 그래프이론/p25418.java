import java.util.*;
import java.io.*;

public class p25418 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // BFS 호출
        int result = bfs(A, K);

        // 결과 출력
        System.out.println(result);
    }

    static int bfs(int A, int K) {
        // 큐 초기화: {현재 값, 연산 횟수}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { A, 0 });

        // 방문 배열
        boolean[] visited = new boolean[K + 1];
        visited[A] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];

            // 목표값 도달 시 연산 횟수 반환
            if (value == K) {
                return count;
            }

            // 연산 1: +1
            if (value + 1 <= K && !visited[value + 1]) {
                queue.add(new int[] { value + 1, count + 1 });
                visited[value + 1] = true;
            }

            // 연산 2: *2
            if (value * 2 <= K && !visited[value * 2]) {
                queue.add(new int[] { value * 2, count + 1 });
                visited[value * 2] = true;
            }
        }

        return -1; // 도달할 수 없는 경우 (문제 조건상 발생하지 않음)
    }
}

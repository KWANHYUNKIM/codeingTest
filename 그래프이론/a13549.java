import java.util.*;
import java.io.*;

public class a13549 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 수빈 위치
        int K = Integer.parseInt(input[1]); // 동생 위치

        int result = bfs(N, K);
        System.out.println(result);
    }

    static int bfs(int N, int K) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {N, 0}); // {현재 위치, 소요 시간}

        boolean[] visited = new boolean[100001]; // 0 ~ 100,000만 관리
        visited[N] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int value = current[0];
            int count = current[1];

            if (value == K) {
                return count; // 동생 위치에 도달했을 때 소요 시간 반환
            }

            // 순간이동 (0초, 우선 탐색)
            if (value * 2 <= 100000 && !visited[value * 2]) {
                deque.addFirst(new int[] {value * 2, count});
                visited[value * 2] = true;
            }

            // 걷기 (1초 후)
            if (value + 1 <= 100000 && !visited[value + 1]) {
                deque.addLast(new int[] {value + 1, count + 1});
                visited[value + 1] = true;
            }
            if (value - 1 >= 0 && !visited[value - 1]) {
                deque.addLast(new int[] {value - 1, count + 1});
                visited[value - 1] = true;
            }
        }
        return -1; // 도달할 수 없는 경우 (문제 조건 상 불가능)
    }
}

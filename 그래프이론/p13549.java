import java.util.*;
import java.io.*;

public class p13549 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        if (N == K) return 0; // 시작 위치와 목표 위치가 같을 경우

        // 방문 배열 (0 ~ 100,000)
        boolean[] visited = new boolean[100001];
        Deque<int[]> deque = new LinkedList<>();

        // 초기 상태 설정
        deque.add(new int[]{N, 0});
        visited[N] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int value = current[0];
            int time = current[1];

            // 순간이동 (0초)
            if (value * 2 <= 100000 && !visited[value * 2]) {
                deque.addFirst(new int[]{value * 2, time}); // 가중치 0이므로 앞쪽에 추가
                visited[value * 2] = true;
            }

            // 걷기 (+1, 1초)
            if (value + 1 <= 100000 && !visited[value + 1]) {
                deque.addLast(new int[]{value + 1, time + 1}); // 가중치 1이므로 뒤쪽에 추가
                visited[value + 1] = true;
            }

            // 걷기 (-1, 1초)
            if (value - 1 >= 0 && !visited[value - 1]) {
                deque.addLast(new int[]{value - 1, time + 1}); // 가중치 1이므로 뒤쪽에 추가
                visited[value - 1] = true;
            }

            // 목표 위치에 도달하면 반환
            if (value == K) {
                return time;
            }
        }

        return -1; // 도달 불가능한 경우 (문제 조건상 발생하지 않음)
    }
}

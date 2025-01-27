import java.util.*;
import java.io.*;

public class p13549 {
    static int MAX = 100000; // 최대 범위
    static boolean[] visited = new boolean[MAX + 1]; // 방문 여부 체크

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int result = bfs(N, K);
        System.out.println(result);
    }

    static int bfs(int start, int end) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{start, 0}); // 시작점과 시간(0초)

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int position = current[0];
            int time = current[1];

            // 동생을 찾은 경우
            if (position == end) {
                return time;
            }

            // 이미 방문한 위치는 건너뛰기
            if (visited[position]) continue;
            visited[position] = true;

            if (position * 2 <= MAX && !visited[position * 2]) {
                deque.addFirst(new int[]{position * 2, time});
            }

            if (position + 1 <= MAX && !visited[position + 1]) {
                deque.addLast(new int[]{position + 1, time + 1});
            }
            if (position - 1 >= 0 && !visited[position - 1]) {
                deque.addLast(new int[]{position - 1, time + 1});
            }
        }

        return -1;
    }
}

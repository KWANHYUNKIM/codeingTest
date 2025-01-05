import java.util.*;
import java.io.*;

public class p14562 {
    static class State {
        int s, t, count;

        State(int s, int t, int count) {
            this.s = s; // 현재 점수
            this.t = t; // 상대 점수
            this.count = count; // 연속 발차기 횟수
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder result = new StringBuilder();

        while (C-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            result.append(bfs(S, T)).append("\n");
        }

        System.out.print(result.toString());
    }

    static int bfs(int startS, int targetT) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(startS, targetT, 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int s = current.s;
            int t = current.t;
            int count = current.count;

            // 조건 만족 시 종료
            if (s == t) {
                return count;
            }

            // A 발차기: 현재 점수 2배, 상대 점수 +3
            if (s * 2 <= t + 3) { // S가 너무 커지는 경우를 방지
                queue.add(new State(s * 2, t + 3, count + 1));
            }

            // B 발차기: 현재 점수 +1
            if (s + 1 <= t) { // S가 T를 초과하는 경우를 방지
                queue.add(new State(s + 1, t, count + 1));
            }
        }

        return -1; // 도달 불가능한 경우 (문제 조건상 불가능하지 않음)
    }
}

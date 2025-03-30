import java.util.*;
import java.io.*;

public class p18115 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        int[] skills = new int[N];
        for (int i = 0; i < N; i++) {
            skills[i] = Integer.parseInt(tokens[i]);
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = N - 1; i >= 0; i--) {
            int card = N - i;
            int skill = skills[i];

            if (skill == 1) {
                deque.addFirst(card);  // 제일 위에
            } else if (skill == 2) {
                int first = deque.pollFirst();
                deque.addFirst(card);
                deque.addFirst(first); // 두 번째에 삽입
            } else {
                deque.addLast(card); // 제일 아래
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : deque) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}

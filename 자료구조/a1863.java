import java.util.*;
import java.io.*;

class direction {
    int x;
    int y;
    direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class a1863 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        direction[] array = new direction[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            array[i] = new direction(x, y);
        }

        // x 좌표 기준으로 정렬
        Arrays.sort(array, (a, b) -> Integer.compare(a.x, b.x));

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int currentHeight = array[i].y;

            if (stack.isEmpty()) {
                stack.push(currentHeight);
                if (currentHeight != 0) count++;
            }
            else if (stack.peek() != currentHeight) {
                while (!stack.isEmpty() && stack.peek() > currentHeight) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < currentHeight) {
                    stack.push(currentHeight);
                    if (currentHeight != 0) count++;
                }
            }
        }

        System.out.println(count);
    }
}

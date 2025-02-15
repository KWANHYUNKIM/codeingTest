import java.util.*;
import java.io.*;

public class p14395 {
    static class Node {
        long value;
        String path;

        Node(long value, String path) {
            this.value = value;
            this.path = path;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long s = Long.parseLong(input[0]);
        long t = Long.parseLong(input[1]);

        // s == t이면 바로 0을 출력
        if (s == t) {
            System.out.println(0);
            return;
        }

        // BFS 실행
        String result = bfs(s, t);
        System.out.println(result);
    }

    static String bfs(long s, long t) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Long> visited = new HashSet<>();

        queue.add(new Node(s, ""));
        visited.add(s);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            long value = current.value;
            String path = current.path;

            // '*' 연산 (먼저 수행)
            if (value * value <= t && !visited.contains(value * value)) {
                if (value * value == t) return path + "*";
                queue.add(new Node(value * value, path + "*"));
                visited.add(value * value);
            }

            // '+' 연산
            if (value + value <= t && !visited.contains(value + value)) {
                if (value + value == t) return path + "+";
                queue.add(new Node(value + value, path + "+"));
                visited.add(value + value);
            }

            // '/' 연산 (s != 0일 때만 가능)
            if (value != 0 && !visited.contains(1L)) {
                if (1 == t) return path + "/";
                queue.add(new Node(1L, path + "/"));
                visited.add(1L);
            }
        }

        return "-1"; // 변환 불가능한 경우
    }
}

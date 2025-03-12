import java.util.*;
import java.io.*;

public class p18405 {

    static class Node implements Comparable<Node> {
        int x, y, virus, time;

        Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return this.virus - other.virus;  // 바이러스 번호 작은 순으로 우선순위 부여
        }
    }

    static int N, K, S, X, Y;
    static int[][] matrix;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        matrix = new int[N][N];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String[] input_ = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(input_[j]);
                if (matrix[i][j] > 0) {
                    pq.add(new Node(i, j, matrix[i][j], 0)); // 초기 바이러스 위치 추가
                }
            }
        }

        String[] input__ = br.readLine().split(" ");
        S = Integer.parseInt(input__[0]);
        X = Integer.parseInt(input__[1]) - 1;
        Y = Integer.parseInt(input__[2]) - 1;

        int result = bfs(pq);
        System.out.println(result);
    }

    static int bfs(PriorityQueue<Node> pq) {
        Queue<Node> queue = new LinkedList<>();
        while (!pq.isEmpty()) queue.add(pq.poll()); // 우선순위 큐를 일반 큐로 변환

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.time == S) break; // S초가 되면 종료

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if (matrix[nextX][nextY] == 0) { // 빈 공간일 때만 전파
                        matrix[nextX][nextY] = current.virus;
                        queue.add(new Node(nextX, nextY, current.virus, current.time + 1));
                    }
                }
            }
        }

        return matrix[X][Y]; // S초 후 (X, Y)의 바이러스 번호 반환
    }
}
import java.util.*;
import java.io.*;

public class p6087 {
    static int N, M;
    static char[][] matrix;
    static int[][][] dist;
    static int[] dx = {1, -1, 0, 0}; // 아래, 위, 오른쪽, 왼쪽
    static int[] dy = {0, 0, 1, -1};
    static final int INF = 10001;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        matrix = new char[N][M];
        dist = new int[N][M][4]; // (x, y, 방향)에 따른 최소 거울 개수

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i][0], INF);
            Arrays.fill(dist[i][1], INF);
            Arrays.fill(dist[i][2], INF);
            Arrays.fill(dist[i][3], INF);
        }

        int sx = -1, sy = -1, ex = -1, ey = -1;
        for (int i = 0; i < N; i++) {
            String input_ = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = input_.charAt(j);
                if (matrix[i][j] == 'C') {
                    if (sx == -1) { // 첫 번째 C
                        sx = i;
                        sy = j;
                    } else { // 두 번째 C
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        int result = bfs(sx, sy, ex, ey);
        System.out.println(result);
    }

    static int bfs(int sx, int sy, int ex, int ey) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 0; i < 4; i++) {
            pq.add(new Node(sx, sy, i, 0));
            dist[sx][sy][i] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int mirrors = cur.mirrors;

            // 목표 지점 도착
            if (x == ex && y == ey) return mirrors;

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                int newMirrors = mirrors;

                // 현재 방향과 다르면 거울을 설치해야 한다.
                if (dir != i) newMirrors++;

                // 같은 방향으로 벽을 만날 때까지 계속 이동
                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || matrix[nx][ny] == '*') break;

                    if (dist[nx][ny][i] > newMirrors) {
                        dist[nx][ny][i] = newMirrors;
                        pq.add(new Node(nx, ny, i, newMirrors));
                    }
                }
            }
        }
        return -1;
    }

    static class Node implements Comparable<Node> {
        int x, y, dir, mirrors;
        public Node(int x, int y, int dir, int mirrors) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrors = mirrors;
        }
        public int compareTo(Node o) {
            return this.mirrors - o.mirrors; // 거울 개수 기준 오름차순 정렬
        }
    }
}

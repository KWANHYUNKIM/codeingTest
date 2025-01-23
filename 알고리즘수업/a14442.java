import java.io.*;
import java.util.*;

public class a14442 {
    static class Node {
        int x, y, dist, wallBreaks;

        Node(int x, int y, int dist, int wallBreaks) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wallBreaks = wallBreaks;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(N, M, K, map);
        System.out.println(result);
    }

    private static int bfs(int N, int M, int K, int[][] map) {
        boolean[][][] visited = new boolean[N][M][K + 1];
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][current.wallBreaks]) {
                        visited[nx][ny][current.wallBreaks] = true;
                        queue.add(new Node(nx, ny, current.dist + 1, current.wallBreaks));
                    } else if (map[nx][ny] == 1 && current.wallBreaks < K && !visited[nx][ny][current.wallBreaks + 1]) {
                        visited[nx][ny][current.wallBreaks + 1] = true;
                        queue.add(new Node(nx, ny, current.dist + 1, current.wallBreaks + 1));
                    }
                }
            }
        }

        return -1;
    }
}
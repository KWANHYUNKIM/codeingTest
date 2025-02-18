import java.util.*;
import java.io.*;

public class p15653 {
    static class Node {
        int rx, ry, bx, by, distance;

        Node(int rx, int ry, int bx, int by, int distance) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.distance = distance;
        }
    }

    static int N, M;
    static char[][] matrix;
    static int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우 이동
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][][] visited;  // 방문 여부 (rx, ry, bx, by)

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = row.charAt(j);

                if (matrix[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    matrix[i][j] = '.';
                } else if (matrix[i][j] == 'B') {
                    bx = i;
                    by = j;
                    matrix[i][j] = '.';
                }
            }
        }

        int result = bfs(rx, ry, bx, by);
        System.out.println(result);
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int i = 0; i < 4; i++) {
                int[] redResult = move(current.rx, current.ry, dx[i], dy[i]);
                int[] blueResult = move(current.bx, current.by, dx[i], dy[i]);

                int nrx = redResult[0], nry = redResult[1], rMoves = redResult[2];
                int nbx = blueResult[0], nby = blueResult[1], bMoves = blueResult[2];

                // 파란 구슬이 구멍에 빠지면 실패
                if (matrix[nbx][nby] == 'O') continue;

                // 빨간 구슬이 구멍에 빠지면 성공
                if (matrix[nrx][nry] == 'O') return current.distance + 1;

                // 두 공이 같은 위치에 있다면 위치 조정
                if (nrx == nbx && nry == nby) {
                    if (rMoves > bMoves) {  // R이 더 움직였다면 한 칸 뒤로
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {  // B가 더 움직였다면 한 칸 뒤로
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                // 방문한 적이 없다면 큐에 추가
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new Node(nrx, nry, nbx, nby, current.distance + 1));
                }
            }
        }
        return -1;
    }

    // 공을 기울였을 때 도달하는 위치와 이동 횟수를 반환하는 함수
    static int[] move(int x, int y, int dx, int dy) {
        int moves = 0;
        while (matrix[x + dx][y + dy] != '#' && matrix[x][y] != 'O') {
            x += dx;
            y += dy;
            moves++;
        }
        return new int[]{x, y, moves};
    }
}

import java.io.*;
import java.util.*;

public class p13460 {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class State {
        int rx, ry, bx, by, cnt;
        public State(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    redX = i;
                    redY = j;
                    board[i][j] = '.'; // 빨간 구슬의 초기 위치는 빈 칸으로 처리
                } else if (board[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                    board[i][j] = '.'; // 파란 구슬도 마찬가지
                }
            }
        }
        
        int result = bfs(redX, redY, blueX, blueY);
        System.out.println(result);
    }
    
    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        visited = new boolean[N][M][N][M];
        queue.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;
        
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            
            if (cur.cnt >= 10) continue;
            
            for (int i = 0; i < 4; i++) {
                int nrx = cur.rx;
                int nry = cur.ry;
                int nbx = cur.bx;
                int nby = cur.by;
                int rMoves = 0, bMoves = 0;
                
                while (true) {
                    if (board[nrx + dx[i]][nry + dy[i]] == '#') break;
                    nrx += dx[i];
                    nry += dy[i];
                    rMoves++;
                    if (board[nrx][nry] == 'O') break;
                }
                
                // 파란 구슬 이동
                while (true) {
                    if (board[nbx + dx[i]][nby + dy[i]] == '#') break;
                    nbx += dx[i];
                    nby += dy[i];
                    bMoves++;
                    if (board[nbx][nby] == 'O') break;
                }
                
                // 파란 구슬이 구멍에 들어간 경우: 실패이므로 해당 방향은 건너뜀
                if (board[nbx][nby] == 'O') continue;
                // 빨간 구슬만 구멍에 들어간 경우: 성공!
                if (board[nrx][nry] == 'O') return cur.cnt + 1;
                
                // 두 구슬이 같은 위치에 있을 경우 처리: 더 많이 이동한 구슬을 한 칸 뒤로 이동
                if (nrx == nbx && nry == nby) {
                    if (rMoves > bMoves) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }
                
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.offer(new State(nrx, nry, nbx, nby, cur.cnt + 1));
                }
            }
        }
        return -1;
    }
}

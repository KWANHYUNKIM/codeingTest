import java.util.*;
import java.io.*;

public class p16954 {
    static final int SIZE = 8;
    static char[][] matrix = new char[SIZE][SIZE]; // 체스판
    static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1}; // 8방향 + 제자리
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < SIZE; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs() ? 1 : 0);
    }

    static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{7, 0, 0}); // (x, y, 시간)
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean[][] visited = new boolean[SIZE][SIZE]; // 매 초마다 방문 배열 초기화
            
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1], time = cur[2];

                // 도착점에 도달하면 성공
                if (x == 0 && y == 7) return true;

                // 현재 위치에 벽이 있으면 탈락
                if (matrix[x][y] == '#') continue;

                // 8방향 + 제자리 (9개)
                for (int d = 0; d < 9; d++) {
                    int nx = x + dx[d], ny = y + dy[d];

                    // 범위 체크 및 빈 칸 확인
                    if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE) {
                        if (!visited[nx][ny] && matrix[nx][ny] != '#') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny, time + 1});
                        }
                    }
                }
            }

            // 벽을 아래로 이동
            moveWalls();
        }
        return false; // 이동 불가
    }

    static void moveWalls() {
        for (int i = SIZE - 1; i > 0; i--) {
            matrix[i] = Arrays.copyOf(matrix[i - 1], SIZE);
        }
        Arrays.fill(matrix[0], '.'); // 맨 위 행 초기화
    }
}
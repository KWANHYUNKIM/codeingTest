import java.util.*;
import java.io.*;

public class p16173 {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {1, 0}; // 오른쪽, 아래
    static int[] dy = {0, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        matrix = new int[N][N];
        visited = new boolean[N][N];

        // 게임판 입력
        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        // BFS 실행
        if (bfs(0, 0, N)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    static boolean bfs(int startX, int startY, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 목표 지점 도달 확인
            if (matrix[x][y] == -1) {
                return true;
            }

            // 현재 위치의 이동 가능한 칸 수
            int jump = matrix[x][y];

            // 두 방향으로 이동
            for (int i = 0; i < 2; i++) {
                int nextX = x + dx[i] * jump;
                int nextY = y + dy[i] * jump;

                // 범위 체크 및 방문 여부 확인
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        // 목표 지점에 도달하지 못한 경우
        return false;
    }
}
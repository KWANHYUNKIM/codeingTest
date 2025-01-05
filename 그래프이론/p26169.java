import java.util.*;
import java.io.*;

public class p26169 {
    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 정보 입력
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 학생의 시작 위치 입력
        String[] startInput = br.readLine().split(" ");
        int startX = Integer.parseInt(startInput[0]);
        int startY = Integer.parseInt(startInput[1]);

        // BFS 탐색 및 결과 출력
        System.out.println(bfs(startX, startY));
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0, 0}); // x, y, 이동 횟수, 먹은 사과 개수
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];
            int apples = current[3];

            // 사과를 2개 이상 먹었으면 종료
            if (apples >= 2) {
                return 1;
            }

            // 이동 횟수가 3을 초과하면 종료
            if (moves >= 3) {
                continue;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 보드 범위를 벗어나거나 장애물이면 무시
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || board[nx][ny] == -1) {
                    continue;
                }

                // 이미 방문한 곳은 무시
                if (visited[nx][ny]) {
                    continue;
                }

                // 방문 처리 및 큐에 추가
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, moves + 1, apples + (board[nx][ny] == 1 ? 1 : 0)});
            }
        }

        // 사과를 2개 이상 먹지 못한 경우
        return 0;
    }
}
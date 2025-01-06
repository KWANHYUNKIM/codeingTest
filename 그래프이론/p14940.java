import java.util.*;
import java.io.*;

public class p14940 {
    static int[][] matrix; // 입력 맵
    static int[][] result; // 결과 맵
    static boolean[][] visited; // 방문 여부
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 세로 크기
        int M = Integer.parseInt(input[1]); // 가로 크기

        matrix = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        // 입력 읽기
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
                if (matrix[i][j] == 0) {
                    result[i][j] = 0; // 갈 수 없는 땅은 0으로 초기화
                } else {
                    result[i][j] = -1; // 초기값을 -1로 설정
                }
            }
        }

        // 목표 지점(2)의 위치 찾기
        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 2) {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        // BFS 실행
        bfs(startX, startY, N, M);

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int startX, int startY, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        result[startX][startY] = 0; // 목표 지점의 거리는 0
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                // 범위 내에 있고, 방문하지 않았으며, 갈 수 있는 땅인 경우
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && matrix[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    result[nx][ny] = result[currentX][currentY] + 1; // 현재 거리 + 1
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}
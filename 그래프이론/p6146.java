import java.util.*;
import java.io.*;

public class p6146 {
    static class Current {
        int x, y, dist;

        Current(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int size = 1001; // 매트릭스 크기 (좌표 범위: -500 ~ 500)
    static int offset = 500; // 음수 좌표 변환을 위한 오프셋
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static String[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] input = br.readLine().split(" ");
        int arriveX = Integer.parseInt(input[0]) + offset;
        int arriveY = Integer.parseInt(input[1]) + offset;
        int N = Integer.parseInt(input[2]); // 웅덩이 개수

        // 매트릭스와 방문 배열 초기화
        matrix = new String[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], ".");
        }

        // 목적지 표시
        matrix[arriveX][arriveY] = "#";

        // 웅덩이 입력
        for (int i = 0; i < N; i++) {
            String[] puddle = br.readLine().split(" ");
            int X = Integer.parseInt(puddle[0]) + offset;
            int Y = Integer.parseInt(puddle[1]) + offset;
            matrix[X][Y] = "B"; // 웅덩이 표시
        }

        // BFS 실행
        int result = bfs(0 + offset, 0 + offset, arriveX, arriveY);
        System.out.println(result);
    }

    static int bfs(int startX, int startY, int arriveX, int arriveY) {
        Queue<Current> queue = new LinkedList<>();
        queue.add(new Current(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Current current = queue.poll();
            int x = current.x;
            int y = current.y;
            int dist = current.dist;

            // 목적지 도달 시 거리 반환
            if (x == arriveX && y == arriveY) {
                return dist;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 좌표인지 확인
                if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                    if (!visited[nx][ny] && !matrix[nx][ny].equals("B")) {
                        visited[nx][ny] = true;
                        queue.add(new Current(nx, ny, dist + 1));
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우 (문제 조건상 발생하지 않음)
    }
}

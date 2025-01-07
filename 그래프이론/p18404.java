import java.util.*;
import java.io.*;

public class p18404 {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2}; // 나이트 이동 방향
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] result;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] knightPosition = br.readLine().split(" ");
        int startX = Integer.parseInt(knightPosition[0]) - 1; // 0-based 인덱스로 변환
        int startY = Integer.parseInt(knightPosition[1]) - 1;

        int[][] targets = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] targetPosition = br.readLine().split(" ");
            int targetX = Integer.parseInt(targetPosition[0]) - 1;
            int targetY = Integer.parseInt(targetPosition[1]) - 1;
            targets[i] = new int[]{targetX, targetY};
        }

        result = new int[M];

        // BFS 실행
        bfs(startX, startY, N, targets);

        // 결과 출력
        for (int i = 0; i < M; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static void bfs(int startX, int startY, int N, int[][] targets) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] distance = new int[N][N]; // 거리 저장 배열

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 8가지 방향으로 이동
            for (int i = 0; i < 8; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 범위 체크 및 방문 여부 확인
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    distance[nextX][nextY] = distance[x][y] + 1; // 거리 갱신
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        // 상대편 말의 위치에 따른 결과 저장
        for (int i = 0; i < targets.length; i++) {
            int targetX = targets[i][0];
            int targetY = targets[i][1];
            result[i] = distance[targetX][targetY]; // 저장된 거리값 활용
        }
    }
}

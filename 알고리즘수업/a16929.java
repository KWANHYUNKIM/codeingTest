import java.util.*;
import java.io.*;

public class a16929 {
    static int N, M;
    static char[][] matrix;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, matrix[i][j], -1, -1)) { // 시작 지점의 부모를 (-1, -1)로 설정
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }

    public static boolean dfs(int x, int y, char color, int parentX, int parentY) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) { // 상하좌우 탐색
            int currentX = x + dx[i];
            int currentY = y + dy[i];

            if (currentX >= 0 && currentY >= 0 && currentX < N && currentY < M) { // 범위 체크
                if (matrix[currentX][currentY] == color) { // 같은 색인지 확인
                    if (visited[currentX][currentY]) {
                        // 부모 노드가 아니면 사이클 존재
                        if (!(currentX == parentX && currentY == parentY)) {
                            return true;
                        }
                    } else {
                        // 방문하지 않았으면 DFS 재귀 호출
                        if (dfs(currentX, currentY, color, x, y)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false; // 사이클을 찾지 못한 경우
    }
}
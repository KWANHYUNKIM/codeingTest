import java.util.*;
import java.io.*;

public class p1952 {
    static int[] dx = {0, 1, 0, -1}; // 오른쪽 → 아래 → 왼쪽 → 위
    static int[] dy = {1, 0, -1, 0}; 
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]); // 행 개수
        int N = Integer.parseInt(input[1]); // 열 개수
        boolean[][] visited = new boolean[M][N]; // 방문 여부 체크

        int x = 0, y = 0, dir = 0;  // 시작 좌표 및 방향
        int turnCount = 0;          // 방향 전환 횟수
        int totalCells = M * N;     // 전체 칸 개수
        int visitedCount = 1;       // 방문한 칸 개수 (시작점 포함)

        visited[x][y] = true;       // 시작점 방문 처리

        while (visitedCount < totalCells) {
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N && !visited[nextX][nextY]) {
                x = nextX;
                y = nextY;
                visited[x][y] = true;
                visitedCount++;
            } else { 
                dir = (dir + 1) % 4;
                turnCount++; 
            }
        }

        System.out.println(turnCount);
    }
}

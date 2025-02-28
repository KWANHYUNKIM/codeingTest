import java.util.*;
import java.io.*;

public class p16973 {
    static int N, M;
    static int[][] matrix;
    static int[][] ps; // 누적합 배열
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int h, w;
    static int s_x, s_y, e_x, e_y;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        matrix = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        ps = new int[N+1][M+1];
        
        for (int i = 1; i <= N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(row[j-1]);
            }
        }
        
        // 누적합 배열 계산 (1-indexed)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                ps[i][j] = matrix[i][j] 
                         + ps[i-1][j] 
                         + ps[i][j-1] 
                         - ps[i-1][j-1];
            }
        }
        
        String[] lastLine = br.readLine().split(" ");
        h = Integer.parseInt(lastLine[0]);
        w = Integer.parseInt(lastLine[1]);
        s_x = Integer.parseInt(lastLine[2]);
        s_y = Integer.parseInt(lastLine[3]);
        e_x = Integer.parseInt(lastLine[4]);
        e_y = Integer.parseInt(lastLine[5]);
        
        int result = bfs();
        System.out.println(result);
    }
    
    // (r, c)를 왼쪽 상단으로 하는 h×w 직사각형 내부에 벽이 없는지 확인하는 함수
    static boolean canMove(int r, int c) {
        // 범위 검사: 직사각형의 오른쪽 아래가 격자 내부에 있어야 함
        if(r < 1 || c < 1 || r + h - 1 > N || c + w - 1 > M) return false;
        // 누적합을 사용하여 해당 영역의 합 계산
        int r2 = r + h - 1;
        int c2 = c + w - 1;
        int sum = ps[r2][c2] - ps[r-1][c2] - ps[r2][c-1] + ps[r-1][c-1];
        return sum == 0;
    }
    
    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s_x, s_y, 0});
        visited[s_x][s_y] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int curX = current[0];
            int curY = current[1];
            int curD = current[2];
            
            if(curX == e_x && curY == e_y){
                return curD;
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 1 && nextY >= 1 && nextX <= N && nextY <= M){
                    if(!visited[nextX][nextY] && canMove(nextX, nextY)){
                        visited[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY, curD + 1});
                    }
                }
            }
        }
        return -1;
    }
}

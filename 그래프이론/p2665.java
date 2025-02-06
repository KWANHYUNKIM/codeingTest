import java.util.*;
import java.io.*;

public class p2665{
    static int N ;
    static int matrix[][];
    static boolean visited[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N; i++){
            String input = br.readLine();

            for(int j = 0 ; j < N; j ++){
                matrix[i][j] = input.charAt(j) -'0';
            }
        }

        int result = bfs(0,0);
        System.out.println(result);
    }
    static int bfs(int x,int y){
        Deque<int []> dq = new LinkedList<>();
        dq.add(new int[] {x, y, 0});
        visited[x][y] = true;

        while(!dq.isEmpty()){
            int cur[] = dq.poll();
            int curX = cur[0];
            int curY = cur[1];
            int black = cur[2];

            if(curX == N - 1 && curY == N - 1){
                return black;
            }

            for(int i = 0 ; i < 4; i ++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX <= N - 1 && nextY <= N - 1 && !visited[nextX][nextY]){
                    if(matrix[nextX][nextY] == 1){
                        visited[nextX][nextY] = true;
                        dq.addFirst(new int[] {nextX,nextY, black});
                    }

                    else if (matrix[nextX][nextY] == 0){
                        visited[nextX][nextY] = true;
                        dq.addLast(new int[] {nextX,nextY, black + 1});
                    }
                }
            }
        }

        return -1;
    }
}
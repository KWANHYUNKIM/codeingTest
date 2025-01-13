import java.util.*;
import java.io.*;

public class p2178 {
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N, M;
    static char matrix[][];
    static boolean visited[][];
    static int dist = 1;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        matrix = new char [N][M];
        visited = new boolean [N][M];

        for(int i = 0 ; i < N; i++){
            String input_ = br.readLine();
            for(int j = 0; j < M; j++){
                matrix[i][j] = input_.charAt(j);
            }
        }
        bfs(0,0);

        System.out.println(dist);
    }
    static void bfs(int startX, int startY){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, dist});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int current [] = queue.poll();
            int x = current[0];
            int y = current[1];

            if(x == N -1 && y == M -1){
                break;
            }

            for(int i = 0 ; i < 4; i++){
                int currentX = x + dx[i];
                int currentY = y + dy[i];
                if(currentX >= 0 && currentY >= 0 && currentX < N && currentY < M && !visited[currentX][currentY] && matrix[currentX][currentY] == '1'){
                    //System.out.println("currentX : " + currentX + " currentY : " + currentY + " distance : " + dist);
                    visited[currentX][currentY] = true;
                    queue.add(new int[] { currentX, currentY, dist++});
                }
                else if( x == N -1 && y == M -1){
                    break;
                }
            }
        }
    }
}
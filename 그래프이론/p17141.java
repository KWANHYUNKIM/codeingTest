import java.util.*;
import java.io.*;

public class p17141{
    static int N, M;
    static int matrix[][];
    static boolean visited[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int distance[][] ;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new int [N][N];
        visited = new boolean [N][N];
        distance = new int [N][N];

        Queue<int []> q = new LinkedList<>();

        for(int i = 0 ; i < N; i++){
            String input_[] = br.readLine().split(" ");
            for(int j = 0 ; j < N; j++){
                matrix[i][j] = Integer.parseInt(input_[j]);
                distance[i][j] = -1;
                if(matrix[i][j] == 2 && M > 0){
                    q.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                    M --;
                }
            }
        }
        bfs(q);
        
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(distance[i][j] +" ");
            }
            System.out.println();
        }
        int result = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                result = Math.max(result, distance[i][j]);
            }
        }

        System.out.println(result);
    
    }
    static void bfs(Queue <int []> queue){

        while(!queue.isEmpty()){
            int current[] = queue.poll();

            int x = current[0];
            int y = current[1];
            int dist = current[2];
            visited[x][y] = true;
            distance[x][y] = dist;
            for(int i = 0 ; i < 4;  i++){
                
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY]){
                    
                    if(matrix[nextX][nextY] == 0){
                        visited[nextX][nextY] = true;
                        matrix[nextX][nextY] = 2;
                        queue.add(new int[] {nextX, nextY, dist + 1});
                        distance[nextX][nextY] = dist;
                    }
                    if (matrix[nextX][nextY] == 2){
                        visited[nextX][nextY] = true;
                        matrix[nextX][nextY] = 2;
                        queue.add(new int[] {nextX, nextY, dist + 1});
                        distance[nextX][nextY] = dist;                    }
                }
            }
        }
    }
}
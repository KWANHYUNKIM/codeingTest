import java.util.*;
import java.io.*;

public class p14497{
    static int N,M;
    static int sx,sy,ex,ey;
    static char matrix[][];
    static boolean visited[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0 , 0 , 1, -1};
    static Queue <int []> availableDirection ;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        matrix = new char[N][M];

        String input_[] = br.readLine().split(" ");

        sx = Integer.parseInt(input_[0]) -1;
        sy = Integer.parseInt(input_[1]) -1;
        ex = Integer.parseInt(input_[2]) -1;
        ey = Integer.parseInt(input_[3]) -1;

        for(int i = 0 ; i < N; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M; j++){
                matrix[i][j] = str.charAt(j);
            }
        }
        int dist = 0;
        boolean check = true;
        while(check){
            availableDirection = new LinkedList<>();
            visited = new boolean[N][M];
            
            if(direction()){
                dist++;
                for(int i = 0 ; i < visited.length; i++){
                    Arrays.fill(visited[i],false);
                }
                removeBarrier();
            }
            else{
                check = false;
            }
        }
        System.out.println(dist + 1);
    }
    static void removeBarrier(){

        while(!availableDirection.isEmpty()){
            int current [] = availableDirection.poll();
            int x = current[0];
            int y = current[1];
            visited[x][y] = true;
            for(int i = 0 ; i < 4; i ++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if(!visited[nextX][nextY] && matrix[nextX][nextY] == '1'){
                        visited[nextX][nextY] = true;
                        matrix[nextX][nextY] = '0';
                    }
                }
            }
        }
    }
    static boolean direction(){
        availableDirection.add(new int []{sx,sy});
        Queue <int []> q = new LinkedList<>();
        q.add(new int [] {sx, sy});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int current[] = q.poll();
            int cx = current[0];
            int cy = current[1];

            visited[cx][cy] = true;
                    
            for(int i = 0 ; i < 4; i++){
                int nextX = cx + dx[i];
                int nextY = cy + dy[i];

                
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                    if(!visited[nextX][nextY] && matrix[nextX][nextY] == '0'){
                        visited[nextX][nextY] = true;
                        availableDirection.add(new int [] {nextX,nextY});
                        q.add(new int[] {nextX, nextY});
                    }
                    if(!visited[nextX][nextY] && matrix[nextX][nextY] == '#'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
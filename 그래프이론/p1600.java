import java.util.*;
import java.io.*;

public class p1600{
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int board[][];
    static boolean visited[][][];
    static int W,H,K;

    static int horseX[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int horseY[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        W = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[0]);

        board = new int[W][H];
        visited = new boolean [W][H][K+ 1];
        for(int i = 0 ; i < W; i++){
            String input_[] = br.readLine().split(" ");
            for(int j = 0 ; j < H; j++){
                board[i][j] = Integer.parseInt(input_[j]);
            }
        }

        int result = bfs();
        if(result == 40001){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
    static int bfs(){
        int distance = 40001;

        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {0, 0, 0, K});
        visited[0][0][K] = true;

        while(!q.isEmpty()){
            int current [] = q.poll();
            int curX = current[0];
            int curY = current[1];
            int curD = current[2];
            int curH = current[3];

            if(curX == W -1 && curY == H - 1){
                distance = Math.min(distance,curD);
            }

            for(int i = 0 ; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX >= 0 && nextX < W && nextY >= 0 && nextY < H){
                    if(board[nextX][nextY] == 0 && !visited[nextX][nextY][curH]){
                        visited[nextX][nextY][curH] = true;
                        q.add(new int [] {nextX, nextY, curD + 1, curH});
                    }
                    
                }
            }
            if(curH > 0){
                for(int i = 0; i < 8 ; i++){
                    int nextX = curX + horseX[i];
                    int nextY = curY + horseY[i];

                    if(nextX >= 0 && nextX < W && nextY >= 0 && nextY < H){
                        if(board[nextX][nextY] == 0 && !visited[nextX][nextY][curH -1]){
                            visited[nextX][nextY][curH -1] = true;
                            q.add(new int [] { nextX,nextY,curD + 1 , curH -1});
                        }
                    }
                }
            }
        }
        return distance;
    }
}

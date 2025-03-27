import java.util.*;
import java.io.*;

public class p6593{
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int dz[] = {1, -1 };
    static int startF, startX, startY ;
    static int endF, endX, endY ;
    static int L,R,C;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
        String input[] = br.readLine().split(" ");
        
        L = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);

        if(L == 0 && R == 0 && C == 0){
            break;
        }

        char matrix[][][] = new char [L][R][C];
        boolean visited[][][] = new boolean [L][R][C];

        for(int i = 0 ; i < L; i++){
            for(int j = 0 ; j < R; j++){
                Arrays.fill(visited[i][j],false);
            }
        }

        for(int i = 0; i < L ; i++){
            for(int j = 0 ; j < R; j++){
                String input_ = br.readLine();
                for(int z = 0; z < C; z++){
                    matrix[i][j][z] = input_.charAt(z);

                    if(input_.charAt(z) == 'S'){
                        startF = i;
                        startX = j;
                        startY = z;
                    }
                    else if(input_.charAt(z) == 'E'){
                        endF = i;
                        endX = j;
                        endY = z;
                    }
                }
            }
            String input__ = br.readLine();
        }

        int result = bfs(matrix, visited);
        if(result == -1){
            System.out.println("Trapped!");
        }
        else{
            System.out.println("Escaped in " + result + " minute(s).");    

        }
        }
    }
    static int bfs(char matrix[][][], boolean visited[][][]){
        Queue <int []> q = new LinkedList<>();
        q.add(new int[] {startF, startX,startY, 0});
        visited[startF][startX][startY] = true;
        while(!q.isEmpty()){
            int current[] = q.poll();
            int curF = current[0];
            int curX = current[1];
            int curY = current[2];
            int curD = current[3];

            if(curF == endF && curX == endX && curY == endY){
                return curD;
            }

            for(int j = 0 ; j < 4; j++){
                int nextX = curX + dx[j];
                int nextY = curY + dy[j];
                if(nextX >= 0 && nextX <R && nextY >=0 && nextY < C ){
                    if(!visited[curF][nextX][nextY] && (matrix[curF][nextX][nextY] == '.' || matrix[curF][nextX][nextY] == 'E')){
                        visited[curF][nextX][nextY] = true;
                        q.add(new int [] {curF, nextX, nextY, curD + 1}); 
                       }
                    }
            }
            for(int i = 0 ; i < 2; i++){
                int nextF = curF + dz[i];

                if(nextF >= 0 && nextF < L){
                    if(!visited[nextF][curX][curY] && (matrix[nextF][curX][curY] == '.' || matrix[nextF][curX][curY] == 'E')){
                        visited[nextF][curX][curY] = true;
                        q.add(new int []{nextF, curX, curY, curD + 1});
                    }
                }
            }
        }

        return -1;
    }
}
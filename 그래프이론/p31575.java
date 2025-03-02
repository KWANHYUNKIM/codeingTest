import java.util.*;
import java.io.*;

// 진우는 북서쪽 끝에 있고 거래소는 남동쪽 끝에 있다.
// 도시의 일부 구역은 공터 또는 도로라서 진우가 지나갈 수 있지만,
// 어떤 구역은 건물이 있어서 진우기 갈 수 없다.
// 최대한 빨리 거래소에 가야 하므로, 동쪽(오른쪽) 또는 남쪽(아래쪽)으로만 이동

// 진우는 (0,0) 시작해서 -> (N,M ) 까지 가야한다.

public class p31575{
    static int N,M;
    static boolean visited [][];
    static int matrix[][];
    static int dx[] = {1, 0}; // 오른쪽 , 아래
    static int dy[] = {0, 1};
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input[] = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        
        visited = new boolean[N][M];
        matrix = new int[N][M];

        for(int i = 0 ; i < N; i++){
            String input_[] = br.readLine().split(" ");
            for(int j = 0 ; j < M; j++){
                matrix[i][j] = Integer.parseInt(input_[j]);
            }
        }
        
        if(dfs(0,0)){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }
    static boolean dfs(int x, int y){
        int curX = x;
        int curY = y;
        
        if(curX == (N - 1)  && curY == (M - 1) ){
            return true;
        }

        for(int i = 0 ; i < 2; i++){
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if(nextX >=0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY]){
                visited[nextX][nextY] = true;

                if(matrix[nextX][nextY] == 1){
                    if(dfs(nextX,nextY)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
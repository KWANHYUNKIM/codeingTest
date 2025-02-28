import java.util.*;
import java.io.*;

public class p1405{
    static int N;
    static boolean visited[][];
    static double probability [] = new double[4]; // 동, 서, 남, 북 이동 확률
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        
        for(int i = 1; i <=4; i++){
            probability[i -1] = Integer.parseInt(input[i]) / 100.0;
        }

        visited = new boolean[30][30];

        System.out.printf("%.9f%n", dfs(15, 15, 0));
    }
    static double dfs(int x, int y, int depth){

        if(depth == N) return 1.0;

        visited[x][y] = true;
        double result = 0.0;

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(visited[nx][ny]) continue;

            result += probability[i] * dfs(nx,ny,depth +1);
        }
        visited[x][y] = false;
        return result;
    }
}
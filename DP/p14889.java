import java.util.*;
import java.io.*;

public class p14889{
    static int N; 
    static int matrix[][];
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int [N][N];
        visited = new boolean[N];

        for(int i = 0 ; i < N; i++){
            String input[] = br.readLine().split(" ");
            for(int j = 0 ; j < N; j++){
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }
    public static void dfs(int depth, int idx){
        if (depth == N / 2){
            calculate();
            return;
        }

        for(int i = idx; i< N; i++){
            if( !visited[i]){
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculate(){
        int start = 0;
        int link = 0;

        for(int i = 0 ; i < N -1; i++){
            for (int j = i + 1; j < N; j++){
                if(visited[i] && visited[j]){
                    start += matrix[i][j] + matrix[j][i];
                }else if( !visited[i] && !visited[j]){
                    link += matrix[i][j] + matrix[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        if (diff == 0){
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, diff);
    }
}
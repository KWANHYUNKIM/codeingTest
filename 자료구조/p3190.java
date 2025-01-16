import java.util.*;
import java.io.*;


public class p3190 {
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

        int K = Integer.parseInt(br.readLine()); // 사과 갯수

        // 사과 위치
        for(int i = 0 ; i < K ; i++){
            String input[] = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            matrix[x][y] = 1;
        }
        
        int L = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < L; i++){
            String input[] = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            String direction = input[1];
            
        }
    }
}
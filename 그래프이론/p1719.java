import java.util.*;
import java.io.*;

public class p1719{
    static final int INF = 1000000000;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int dist[][] = new int [N + 1][N + 1];
        int next[][] = new int [N + 1][N + 1];

        for(int i =1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j ) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }


        for(int i = 0; i < M; i++){
            String input_[] = br.readLine().split(" ");

            int a = Integer.parseInt(input_[0]);
            int b = Integer.parseInt(input_[1]);
            int l = Integer.parseInt(input_[2]);
            
            dist[a][b] = dist[b][a] = l;
            next[a][b] = b;
            next[b][a] = a;
        }

        for(int k =1; k <=N; k++){
            for(int i =1; i <=N; i++){
                for(int j=1; j<=N; j++){
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        // i에서 j로 가기 위한 첫 번째 이동은 i에서 k로 가기 위한 첫번째 이동과 같다.
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for(int i =1; i <=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j && dist[i][j] == 0){
                    System.out.print("- ");
                }
                else{
                    System.out.print(next[i][j] +" ");
                }
            }
            System.out.println();
        }
    }
}
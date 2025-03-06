import java.util.*;
import java.io.*;

public class p14938{
    static final int INF = 101;
    static int N, M , R;
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 지역
        M = Integer.parseInt(input[1]); // 수색범위
        R = Integer.parseInt(input[2]); // 길의 개수
        
        int items[] = new int[N + 1];
        
        // 아이템의 수
        String input_[] = br.readLine().split(" ");
        
        for(int i = 0 ; i < input_.length; i++){
            items[i+1] = Integer.parseInt(input_[i]);
        }

        int dist[][] = new int [N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for(int i = 0; i < R; i++){
            String input__[] = br.readLine().split(" ");

            int a = Integer.parseInt(input__[0]);
            int b = Integer.parseInt(input__[1]);
            int l = Integer.parseInt(input__[2]);

            dist[a][b] = dist[b][a] = l;
        }

        for(int k = 1; k <=N; k++){
            for(int i = 1; i <=N; i++){
                for(int j = 1; j <=N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int result = 0;

        for(int i=1;  i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                if(dist[i][j] <= M){
                    sum += items[j];
                }
            }
            result = Math.max(result,sum);
        }

        System.out.println(result);
    }
}
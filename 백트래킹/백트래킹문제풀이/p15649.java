import java.util.*;
import java.io.*;

public class p15649 {
    static int N, M;
    static boolean[] visited;
    static int[] sequence;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

         visited = new boolean[N + 1];
         sequence = new int[M];

         backtrack(0);
    }

    public static void backtrack(int depth){
        if(depth == M){
            for(int num : sequence){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                sequence[depth] = i;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
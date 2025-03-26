import java.io.*;
import java.util.*;


public class p17071 {
    static int SIZE = 500001;
    static boolean visited[][] = new boolean[SIZE][2];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int result = bfs(N,K);
        
        System.out.println(result);
    }
    static int bfs(int n, int k){
        Queue<int []> q = new LinkedList<>();
        visited[n][0] = true;
        q.add(new int [] {n, k, 0, 0});

        while(!q.isEmpty()){
            int current [] = q.poll();
            int curN = current[0];
            int curK = current[1];
            int curD = current[2];
            int curTime = current[3];
            curTime += 1;

            System.out.println("curN : " + curN + " curK " + curK + " curD " + curD);
            
            if(curN == curK){
                return curD;
            }

            if(curN + 1 >= 0 && curN + 1 < SIZE && curK + curTime >= 0 && curK + curTime < SIZE ){
                if(!visited[curN + 1][curTime % 2]){
                    visited[curN +1][curTime % 2] = true;
                    q.add(new int [] {curN + 1, curK + curTime, curD + 1, curTime });
                }
            }
            if(curN - 1 >= 0 && curN - 1 < SIZE && curK  + curTime >= 0 && curK + curTime < SIZE ){
                if(!visited[curN - 1][curTime % 2]){
                    visited[curN -1][curTime % 2] = true;
                    q.add(new int[] {curN -1, curK + curTime, curD + 1, curTime});
                }
            }
            if(curN * 2 >= 0 && curN * 2 < SIZE && curK + curTime >= 0 && curK + curTime < SIZE){
                if(!visited[curN * 2][curTime % 2]){
                    visited[curN * 2][curTime % 2] = true;
                    q.add(new int[] {curN * 2, curK + curTime, curD + 1, curTime});
                }
            }
        }
        return -1;
    }
}

import java.util.*;
import java.io.*;

public class p14226{
    static int N;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int result = bfs();

        System.out.println(result);
    }
    static int bfs(){
        Queue<int []> q = new LinkedList<>();
        boolean visited[][] = new boolean[1001][1001];
        visited[1][0] = true;
        q.add(new int[]{1, 0, 0});

        while(!q.isEmpty()){
            int current[] = q.poll();
            int screen = current[0];
            int clipboard = current[1];
            int time = current[2];
            
            if(screen == N){
                return time;
            }

            else{
                if(!visited[screen][screen]){
                    q.add(new int[]{screen, screen, time +1});
                    visited[screen][screen] = true;
                }

                if(clipboard > 0 && screen + clipboard <= 1000 && !visited[screen + clipboard][clipboard]){
                    q.add(new int[] {screen + clipboard, clipboard, time + 1});
                    visited[screen + clipboard][clipboard] = true;
                }
                if(screen > 1 && !visited[screen -1][clipboard]){
                    q.add(new int[] {screen -1, clipboard, time + 1});
                    visited[screen -1][clipboard] = true;
                }
            }
        }
        return -1;
    }
}
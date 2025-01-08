import java.util.*;
import java.io.*;

public class p15989 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            int value = Integer.parseInt(br.readLine());

            System.out.println(bfs(value));
        }
    }
    static int bfs(int value){
        Queue<int []> queue = new LinkedList<>();
        boolean visited[] = new boolean[10001];
        int count = 0;
        queue.add(new int []{value, count });

        while(!queue.isEmpty()){
            
        }
    }
}
import java.util.*;
import java.io.*;

public class a13549 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int result = bfs(N, K);

        System.out.println(result);
    }
    static int bfs(int N, int K){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});

        boolean[] visited = new boolean[K + 1];
        visited[N] = true;

        while(!queue.isEmpty()){
            int [] current = queue.poll();
            int value = current[0];
            int count = current[1];

            if(value == K){
                return count;
            }
            if(!visited[value + 1]){
                queue.add(new int[] {value + 1, count + 1});
                visited[value + 1] = true;
            }
            if(!visited[value - 1]){
                queue.add(new int[] {value -1, count + 1});
                visited[value -1] = true;
            }
            if(!visited[value * 2]){
                queue.add(new int[] {value * 2, count});
                visited[value * 2] = true;
            }
        }
    }
}
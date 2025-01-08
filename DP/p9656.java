import java.util.*;
import java.io.*;

public class p9656 {
    static boolean visited[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[1001];
        int result = bfs(N);

        if(result % 2 == 0){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }

    }
    static int bfs(int n){
        Queue<int []> queue = new LinkedList<>();
        int turn = 0;
        queue.add(new int[]{n, turn});

        while(!queue.isEmpty()){
            int current[] = queue.poll();
            int currentN = current[0];
            int currentTurn = current[1];
            
            if(currentN == 1){
                return currentTurn;
            }

            if (currentN - 1 >= 1 && !visited[currentN - 1]) {
                visited[currentN - 1] = true;
                queue.add(new int[]{currentN - 1, currentTurn + 1});
            }

            if (currentN - 3 >= 1 && !visited[currentN - 3]) {
                visited[currentN - 3] = true;
                queue.add(new int[]{currentN - 3, currentTurn + 1});
            }

        }
        return -1;
    }
}
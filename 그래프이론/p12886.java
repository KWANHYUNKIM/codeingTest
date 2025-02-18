import java.util.*;
import java.io.*;

public class p12886{
    static int A,B,C;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");


        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);

        int result = bfs();
        System.out.println(result);

    }
    static int bfs(){
        Queue<int []> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int[] stones = {A, B, C};
        Arrays.sort(stones);
        q.add(stones);
        visited.add(stones[0] + " " + stones[1] + " " + stones[2]);

        while(!q.isEmpty()){
            int current[] = q.poll();

            int cA = current[0];
            int cB = current[1];
            int cC = current[2];

            if(cA == cB && cB == cC){
                return 1;
            }
            
            int[][] nextMoves ={
                {cA * 2, cB-cA, cC},
                {cA * 2, cB, cC-cA},
                {cA, cB * 2, cC-cB}
            };

            for(int[] next : nextMoves){
                if(next[1] < 0 || next[2] < 0) continue;
                Arrays.sort(next);
                String key = next[0] + " " + next[1] + " " + next[2];

                if(!visited.contains(key)){
                    visited.add(key);
                    q.add(next);
                }
            }
        }
        return 0;
    }
}
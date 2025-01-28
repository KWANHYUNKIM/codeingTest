import java.util.*;
import java.io.*;

public class p16928{
    static int size = 101;
    static int matrix[] = new int[size];
    static boolean visited[] = new boolean[size];
    static int dx[] = {1, 2, 3, 4, 5, 6};
    static HashMap<Integer,Integer> hash = new HashMap<>();

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i = 0 ; i < N + M; i++){
            String input_[] = br.readLine().split(" ");
            int s = Integer.parseInt(input_[0]);
            int e = Integer.parseInt(input_[1]);
            hash.put(s,e);
        }

        int result = bfs();

        System.out.println(result);
    }
    static int bfs(){
        int s = 1;
        int d = 0;
        Queue <int []> queue = new LinkedList<>();
        queue.add(new int[] {s, d});
        visited[s] = true;

        while(!queue.isEmpty()){
            int current[] = queue.poll();
            int start = current[0];
            int distance = current[1];

            if(start == 100){
                return distance;
            }

            for(int i = 0 ; i < 6; i++){
                int nextS = start + dx[i];
                if(nextS <= 100 && !visited[nextS]){
                    visited[nextS] = true;
                    if(hash.containsKey(nextS)){
                        queue.add(new int[] {hash.get(nextS), distance + 1});
                    }
                    else{
                        queue.add(new int[] {nextS , distance + 1});
                    }
                }
            }
        }
        return -1;
    }
}
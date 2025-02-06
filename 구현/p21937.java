import java.util.*;
import java.io.*;

public class p21937{
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    static int count = 0;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1];

        for(int i = 0 ; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M; i ++){
            String input_[] = br.readLine().split(" ");

            int a = Integer.parseInt(input_[0]);
            int b = Integer.parseInt(input_[1]);

            graph.get(b).add(a);
        }
        int start = Integer.parseInt(br.readLine());
        dfs(start);

        System.out.println(count);
    }
    static void dfs(int current) {
        for (int prev : graph.get(current)) {
            if (!visited[prev]) {
                visited[prev] = true;
                count++;
                dfs(prev);
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class p4803{
    static List<Integer> graph[];
    static int subtree[];


    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            String input_[] = br.readLine().split(" ");
            int U = Integer.parseInt(input_[0]); // 부모
            int V = Integer.parseInt(input_[1]); // 자식

            graph[U].add(V);
            graph[V].add(U);
        }

        subtree = new int[N + 1];

        dfs(R, - 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < Q; i++){
            int queryNode = Integer.parseInt(br.readLine());
            sb.append(subtree[queryNode]).append("\n");
        }
        System.out.print(sb);
    }
    static int dfs(int node, int parent){
        int count = 1;

        for(int next : graph[node]){
            if(next == parent) continue;
            count += dfs(next, node);
        }
        subtree[node] = count;

        return count;
    }
}
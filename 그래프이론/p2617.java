import java.util.*;
import java.io.*;

public class p2617{
    static int N,M;
    static LinkedList<LinkedList<Integer>> heavyGraph, lightGraph;
    static boolean visited[];

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 무게가 모두 다른 N개의 구슬
        M = Integer.parseInt(input[1]); // M개의 쌍을 골라서 각각 양팔 저울 

        heavyGraph = new LinkedList<>();
        lightGraph = new LinkedList<>();

        for(int i = 0; i <=N; i++){
            heavyGraph.add(new LinkedList<>());
            lightGraph.add(new LinkedList<>());
        }

        for(int i = 0 ; i < M; i++){
            String input_[] = br.readLine().split(" ");
            int heavy = Integer.parseInt(input_[0]);
            int light = Integer.parseInt(input_[1]);

            heavyGraph.get(light).add(heavy);
            lightGraph.get(heavy).add(light);
        }

        int mid = (N + 1) / 2; // 중간 위치
        int count = 0; // 중간이 될 수 없는 구슬 개수

        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            int heavyCount = dfs(i, heavyGraph);

            visited = new boolean[N + 1];
            int lightCount = dfs(i, lightGraph);

            if(heavyCount >= mid || lightCount >= mid){
                count++;
            }
        }
        System.out.println(count);

    }
    static int dfs(int start, LinkedList<LinkedList<Integer>> graph){
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()){
            int now = stack.pop();
            for(int next : graph.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    stack.push(next);
                    count++;
                }
            }
        }

        return count;
    }
}
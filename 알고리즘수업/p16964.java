import java.util.*;
import java.io.*;

public class p16964{
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i <=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < N -1; i++){
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);

        }
        String input_[] = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < input_.length; i++){
            sb.append(input_[i]);
        }

        StringBuilder compareA = new StringBuilder();
        StringBuilder compareB = new StringBuilder();
        boolean visited [] = new boolean[N +1];
        compareA.append(1);
        compareB.append(1);
        dfs(1,visited, compareA);

        Arrays.fill(visited,false);

        for(int i = 1; i <=N; i++){
            Collections.sort(graph.get(i),Collections.reverseOrder());
        }
        dfs(1,visited,compareB);

        System.out.println("compareA ->" + compareA.toString());
        System.out.println("compareB ->" + compareB.toString());
        
        if(sb.toString().equals(compareA.toString()) || sb.toString().equals(compareB.toString())){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
    static void dfs(int start, boolean visited[], StringBuilder a){
        visited[start] = true;
        for(int next : graph.get(start)){
            if(!visited[next]){
                a.append(next);
                dfs(next,visited,a);
            }
        }

    }
}
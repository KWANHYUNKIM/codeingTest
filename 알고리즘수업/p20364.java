import java.util.*;
import java.io.*;

public class p20364{
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static int N,Q;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        Q = Integer.parseInt(input[1]);

        TreeNode nodes [] = new TreeNode[N +1];
        for(int i = 1; i <= N; i++){
            nodes[i] = new TreeNode(i);
        }

        for(int i=1; i<=N; i++){
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;
            
            if(leftIndex <= N){
                nodes[i].left = nodes[leftIndex];
            }
            if(rightIndex <=N){
                nodes[i].right = nodes[rightIndex];
            }
        }

        boolean visited[] = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < Q; i++){
            int land = Integer.parseInt(br.readLine());
            int cur = land;
            int conflict = 0;

            while ( cur > 0){
                if(visited[cur]){
                    conflict = cur;
                    break;
                }
                cur = cur / 2;
            }

            if(conflict == 0){
                visited[land] = true;
                sb.append("0\n");
            }else{
                sb.append(conflict).append("\n");
            }
        }
        System.out.print(sb.toString());
        
    }
}
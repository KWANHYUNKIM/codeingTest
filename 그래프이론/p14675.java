import java.util.*;
import java.io.*;

public class p14675{
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int degree[] = new int[N + 1];

        
        for(int i = 0 ; i < N - 1; i++){
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            degree[a]++;
            degree[b]++;
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < Q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t == 1){ // 단절점
                if(degree[k] >= 2){
                    sb.append("yes\n");
                } else{
                    sb.append("no\n");
                }
            }
            else{
                sb.append("yes\n");
            }
        }
        System.out.print(sb.toString());
    }
    
}
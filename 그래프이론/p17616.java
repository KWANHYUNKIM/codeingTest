import java.util.*;
import java.io.*;

public class p17616{
    static int N,M,X,U,V;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);

        for(int i = 0 ; i <=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++){
            String input_[] = br.readLine().split(" ");

            int A = Integer.parseInt(input_[0]);
            int B = Integer.parseInt(input_[1]);

            graph.get(A).add(B);
        }
        
        

    }
}
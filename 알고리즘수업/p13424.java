import java.util.*;
import java.io.*;

public class p13424{
    static class Node implements Comparable<Node>{
        int index,length;
        Node(int index, int length){
            this.index = index;
            this.length = length;
        }

        @Override
        public int compareTo(Node other){
            return other.length - this.length;
        }
    }

    static int T;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        while(T-- != 0){
            ArrayList<ArrayList<Node>> graph = new ArrayList<>();
            String input___[] = br.readLine().split(" ");

            int N = Integer.parseInt(input___[0]);
            int M = Integer.parseInt(input___[1]);

            for(int i = 0 ; i<= N; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0 ; i < M; i++){
                String input[] = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);

                graph.get(a).add(new Node(b,c));
                graph.get(b).add(new Node(a,c));

            }

            int K = Integer.parseInt(br.readLine());

            String input_[] = br.readLine().split(" ");
            int a = Integer.parseInt(input_[0]);
            int b = Integer.parseInt(input_[1]);

            for(int i = 1 ; i <=N; i++){
                for(Node current : graph.get(i)){
                    System.out.println("current.index " + current.index + " current.length " + current.length);
                }
            }
        }

    }
}
import java.util.*;
import java.io.*;

public class p21278{
    static class Node implements Comparator<Node> {
        int s, e, l;
        public Node() {}
        public Node(int s, int e, int l){
            this.s = s;
            this.e = e;
            this.l = l;
        }

        @Override
        public int compare(Node o1, Node o2){

            if(o1.l != o2.l){
                return o1.l - o2.l;
            }
            if(o1.s != o2.s){
                return o1.s - o2.s;
            }
            return o1.e - o2.e;
        }
    }
    static final int INF = 1000001;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int dist [][] = new int [N + 1][N + 1];
        
        for(int i = 1; i <=N; i++){
            for(int j = 1; j<=N; j++){
                if(i == j){
                    dist[i][j] = 0;
                }
                else dist[i][j] = INF;
            }
        }

        for(int i = 0 ; i < M; i++){
            String input_[] = br.readLine().split(" ");
            int a = Integer.parseInt(input_[0]);
            int b = Integer.parseInt(input_[1]);

            dist[a][b] = dist[b][a] = 1;
        }

        for(int k = 1; k <=N ;k++){
            for(int i =1; i <=N; i++){
                for(int j=1; j<=N; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        LinkedList<Node> result = new LinkedList<>();

        for(int i =1; i<=N; i++){
            for(int j = i+1; j <= N; j++){
                int sum = 0;
                for(int z = 1; z<= N; z++){
                    if(i != z || j != z){
                       sum += Math.min(dist[i][z] , dist[j][z]);
                    }
                }
                result.add(new Node(i ,j, sum * 2));
            }
        }

        Collections.sort(result, new Node());

        for(Node v : result){
            int s = v.s;
            int e = v.e;
            int l = v.l;

            System.out.println(s +" " + e + " " + l);
            break;
        }
    }
}
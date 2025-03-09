import java.util.*;
import java.io.*;

public class p1613{
    static int N,K;
    static int S;
    static ArrayList<ArrayList<Integer>> oneWay;
    static ArrayList<ArrayList<Integer>> returnWay;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        oneWay = new ArrayList<>();
        returnWay = new ArrayList<>();

        for(int i = 0 ; i <=N; i++){
            oneWay.add(new ArrayList<>());
            returnWay.add(new ArrayList<>());
        }

        for(int i = 0 ; i < K; i++){
            String input_[] = br.readLine().split(" ");

            int a = Integer.parseInt(input_[0]);
            int b = Integer.parseInt(input_[1]);

            oneWay.get(a).add(b);
            returnWay.get(a).add(b);
            returnWay.get(b).add(a);
        }

        S = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < S; i++){
            String input__[] = br.readLine().split(" ");

            int a = Integer.parseInt(input__[0]);
            int b = Integer.parseInt(input__[1]);

            boolean oneWayVisited[] = new boolean[N +1];
            boolean returnWayVisited[] = new boolean[N +1];

            if(oneWayBFS(a , b, oneWayVisited)){
                System.out.println("-1");
            }
            else{
                if(returnWayBFS(a, b, returnWayVisited)){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }

        }
    }
    static boolean oneWayBFS(int s, int e, boolean visited[]){
        
        Queue <Integer> q = new LinkedList<>();
        q.add(s);
        visited[s]= true;

        while(!q.isEmpty()){
            int current = q.poll();

            if(current == e){
                return true;
            }

            for(int next : oneWay.get(current)){

                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);

                }
            }
        }

        return false;
    }

    static boolean returnWayBFS(int s, int e, boolean visited[]){
        Queue <Integer> q = new LinkedList<>();
        q.add(s);
        visited[s]= true;

        while(!q.isEmpty()){
            int current = q.poll();

            if(current == e){
                return true;
            }

            for(int next : returnWay.get(current)){

                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return false;
    }
    
}
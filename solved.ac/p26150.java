import java.util.*;
import java.io.*;

public class p26150{
    static class Node implements Comparable<Node>{
        String title;
        int numbers;
        int scores;

        Node(String title, int numbers, int scores){
            this.title = title;
            this.numbers = numbers;
            this.scores = scores;
        }
        
        @Override
        public int compareTo(Node other){
            return this.numbers - other.numbers;
        }
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        LinkedList<Node> list = new LinkedList<>();
        for(int i = 0 ; i < N; i++){
            String input[] = br.readLine().split(" ");
            
            String t = input[0];
            int n = Integer.parseInt(input[1]);
            int s = Integer.parseInt(input[2]);

            list.add(new Node(t,n,s));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for(Node l  : list){
            if(l.title.charAt(l.scores - 1) >= 'a' && l.title.charAt(l.scores - 1) <= 'z')
            sb.append(String.valueOf(l.title.charAt(l.scores - 1)).toUpperCase());
            else{
                sb.append(String.valueOf(l.title.charAt(l.scores - 1)));
            }
        }
        System.out.print(sb.toString());
    }
}
import java.util.*;
import java.io.*;

public class p2412{
    static class Node implements Comparable<Node>{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node other) {
            return this.x - other.x;
        }
    }

    static int n,T;
    static ArrayList<Node> dist = new ArrayList<>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        T = Integer.parseInt(input[1]);

        for(int i = 0 ; i < n; i++){
            String input_[] = br.readLine().split(" ");
            int x = Integer.parseInt(input_[0]);
            int y = Integer.parseInt(input_[1]);
            dist.add(new Node(x,y));
        }
        Collections.sort(dist);
        int count = 0;
        boolean check = true;
        for(int i = 0 ; i < dist.size() -1; i++ ){
            Node current = dist.get(i);
            Node next = dist.get(i + 1);

            if(Math.abs(current.x - next.x) <= 2 && Math.abs(current.y - next.y) <= 2){
                count++;
            }
            else{
                check = false;
                if(i == dist.size() -1 &&  Math.abs(current.y - next.y) <= 2){
                    count++;
                    check = true;
                }
            }
        }
        if(check){
            System.out.println(count);
        }
        else{
            System.out.println(-1);
        }

    }
}
import java.util.*;
import java.io.*;

class Tree{
    int e, weight;
    Tree(int e, int weight){
        this.e = e;
        this.weight = weight;
    }
}
public class p1967 {
    static int size;
    static LinkedList<LinkedList<Tree>> graph = new LinkedList<>();
    static boolean visited[][];

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        visited = new boolean[size][size];

        for(int i = 0 ; i < size + 1; i++){
            graph.add(new LinkedList<Tree>());
        }

        for(int i = 0 ; i < size; i++){
            String input[] = br.readLine().split(" ");

            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph.get(s).add(new Tree(e,w));
            graph.get(e).add(new Tree(s,w));
        }
        System.out.println(graph.toString());
    }
}
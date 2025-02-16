import java.util.*;
import java.io.*;

public class p14267{
    static class Node {
        int number;
        int good;
        Node(int number, int good){
            this.number = number;
            this.good = good;
        }
    }
    static Node matrix[];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 회사의 직원 수
        int M = Integer.parseInt(input[1]); // 칭찬의 횟수

        matrix = new Node[N+1];


        for(int i = 0 ; i < M; i++){
            String input_[] = br.readLine().split(" ");
            int n = Integer.parseInt(input_[0]);
            int c = Integer.parseInt(input_[1]);
        }
        

    }
}
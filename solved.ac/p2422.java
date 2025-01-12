import java.util.*;
import java.io.*;

public class p2422 {
    static class Value {
        int a, b, c;
        Value(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public String toString(){
            return "Value{a=" + a + ", b=" + b + ", c=" + c + "}";
        }
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // N종류의 아이스크림
        int M = Integer.parseInt(input[1]); // M은 섞어먹으면 안되는 조합의 개수
        
        LinkedList<Value> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                for (int z = j + 1; z <= N; z++) {
                    list.add(new Value(i, j, z));
                }
            }
        }
        
        for(int i = 0 ; i < M; i++){
            String input_[] = br.readLine().split(" ");
            
            int C1 = Integer.parseInt(input_[0]);
            int C2 = Integer.parseInt(input_[1]);

            list.removeIf(value -> 
                (value.a == C1 || value.b == C1 || value.c == C1) &&
                (value.a == C2 || value.b == C2 || value.c == C2)
            );
        }
        System.out.println(list.size());
    }
}
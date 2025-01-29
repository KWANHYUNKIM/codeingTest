import java.util.*;
import java.io.*;

public class p7490 {
    static char[] ops = {'+', '-', ' '}; // 사용할 연산자 목록
    static List<String> results;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            results = new ArrayList<>();
            
            dfs(1, N, "1");
            
            Collections.sort(results);
            for (String res : results) {
                System.out.println(res);
            }
            System.out.println();
        }
    }

    // 백트래킹 DFS
    static void dfs(int num, int N, String expr) {
        if (num == N) {
            if (evaluate(expr) == 0) {
                results.add(expr);
            }
            return;
        }

        int next = num + 1;
        dfs(next, N, expr + "+" + next);
        dfs(next, N, expr + "-" + next);
        dfs(next, N, expr + " " + next);
    }

    // 수식 계산 함수
    static int evaluate(String expr) {
        expr = expr.replace(" ", "");
        int sum = 0, num = 0;
        char sign = '+';

        for (char ch : (expr + "+").toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                if (sign == '+') sum += num;
                else if (sign == '-') sum -= num;
                
                num = 0;
                sign = ch;
            }
        }
        return sum;
    }
}

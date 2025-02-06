import java.util.*;
import java.io.*;

public class p17265 {
    static int N;
    static String[][] matrix;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new String[N][N];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().split(" ");
        }

        // DFS 탐색 시작 (초기값은 (0,0)의 숫자로 시작)
        dfs(0, 0, Integer.parseInt(matrix[0][0]));

        // 최댓값과 최솟값 출력
        System.out.println(maxResult + " " + minResult);
    }

    // DFS 탐색
    static void dfs(int x, int y, int currentValue) {
        // 목적지 도달 시 최댓값, 최솟값 갱신
        if (x == N - 1 && y == N - 1) {
            maxResult = Math.max(maxResult, currentValue);
            minResult = Math.min(minResult, currentValue);
            return;
        }

        // 오른쪽과 아래쪽 이동 (연산자가 있는 위치에서만 숫자 위치로 이동)
        if (x + 1 < N) { // 아래쪽 이동 가능
            int nextValue = calculate(currentValue, matrix[x + 1][y], matrix[x + 2][y]);
            dfs(x + 2, y, nextValue);
        }
        if (y + 1 < N) { // 오른쪽 이동 가능
            int nextValue = calculate(currentValue, matrix[x][y + 1], matrix[x][y + 2]);
            dfs(x, y + 2, nextValue);
        }
    }

    // 연산 수행 함수
    static int calculate(int a, String operator, String b) {
        int numB = Integer.parseInt(b);
        switch (operator) {
            case "+":
                return a + numB;
            case "-":
                return a - numB;
            case "*":
                return a * numB;
            default:
                return 0;
        }
    }
}

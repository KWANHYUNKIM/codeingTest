import java.io.*;
import java.util.*;

public class a1613 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 사건 사이의 관계를 저장할 boolean 2차원 배열
        // graph[i][j]가 true이면 사건 i가 사건 j보다 먼저 일어났다는 의미입니다.
        boolean[][] graph = new boolean[n+1][n+1];
        
        // k개의 전후 관계 입력
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
        }
        
        // Floyd-Warshall 알고리즘을 이용한 전이적 폐쇄 계산
        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                if (graph[start][mid]) { // start->mid 경로가 존재할 때만 검사
                    for (int end = 1; end <= n; end++) {
                        if (graph[mid][end]) {
                            graph[start][end] = true;
                        }
                    }
                }
            }
        }
        
        // 질의 처리
        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (graph[a][b]) {   // a가 b보다 먼저
                sb.append("-1\n");
            } else if (graph[b][a]) { // b가 a보다 먼저
                sb.append("1\n");
            } else {              // 관계를 알 수 없는 경우
                sb.append("0\n");
            }
        }
        System.out.print(sb.toString());
    }
}

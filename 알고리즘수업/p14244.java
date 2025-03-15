import java.util.*;
import java.io.*;

public class p14244 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 전체 노드 개수
        int M = Integer.parseInt(input[1]); // 리프 개수

        List<int[]> edges = new ArrayList<>();
        
        // 루트 노드를 0번으로 설정
        int parent = 0;

        // 1. 먼저 트리의 뼈대를 만든다.
        for (int i = 1; i < N - M + 1; i++) {
            edges.add(new int[]{parent, i});
            parent = i;
        }

        // 2. 리프 노드 M개를 마지막 연결된 내부 노드(parent)에 붙인다.
        for (int i = N - M + 1; i < N; i++) {
            edges.add(new int[]{parent, i});
        }

        // 3. 간선 정보 출력
        for (int[] edge : edges) {
            System.out.println(edge[0] + " " + edge[1]);
        }
    }
}

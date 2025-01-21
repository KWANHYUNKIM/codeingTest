import java.util.*;
import java.io.*;

class Tree {
    int e, weight;
    Tree(int e, int weight) {
        this.e = e;
        this.weight = weight;
    }
}

public class p1967 {
    static LinkedList<Tree>[] graph;
    static boolean[] visited;
    static int maxDist = 0; // 최대 거리
    static int farthestNode = 0; // 가장 먼 노드

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        graph = new LinkedList[size + 1];
        for (int i = 0; i <= size; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < size - 1; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph[s].add(new Tree(e, w));
            graph[e].add(new Tree(s, w));
        }

        // 1. 임의의 노드 (1번 노드)에서 가장 먼 노드 찾기
        visited = new boolean[size + 1];
        dfs(1, 0);

        // 2. 가장 먼 노드에서 다시 가장 먼 노드 찾기
        visited = new boolean[size + 1];
        maxDist = 0; // 거리 초기화
        dfs(farthestNode, 0);

        // 3. 트리의 지름 출력
        System.out.println(maxDist);
    }

    static void dfs(int node, int dist) {
        visited[node] = true;

        // 최대 거리 갱신
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        // 인접 노드 탐색
        for (Tree next : graph[node]) {
            if (!visited[next.e]) {
                dfs(next.e, dist + next.weight);
            }
        }
    }
}

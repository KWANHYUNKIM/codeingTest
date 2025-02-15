import java.io.*;
import java.util.*;

public class p3584 {
    static int N;
    static List<Integer>[] children;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            
            // 인접 리스트 초기화 (1번부터 N번 노드 사용)
            children = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                children[i] = new ArrayList<>();
            }
            
            parent = new int[N + 1];
            depth = new int[N + 1];
            // 루트 노드를 찾기 위해 자식 노드로 등장한지 여부를 체크합니다.
            boolean[] isChild = new boolean[N + 1];
            
            // 간선 정보 입력: A가 B의 부모임
            for (int i = 1; i <= N - 1; i++) {
                String[] tokens = br.readLine().split(" ");
                int p = Integer.parseInt(tokens[0]);
                int c = Integer.parseInt(tokens[1]);
                children[p].add(c);
                parent[c] = p;
                isChild[c] = true;
            }
            
            // 루트 찾기: 자식으로 등장하지 않은 노드
            int root = 0;
            for (int i = 1; i <= N; i++) {
                if (!isChild[i]) {
                    root = i;
                    break;
                }
            }
            
            // DFS(또는 BFS)로 각 노드의 깊이와 부모를 기록합니다.
            setDepth(root, 0);
            
            // LCA를 구할 두 노드 입력
            String[] query = br.readLine().split(" ");
            int a = Integer.parseInt(query[0]);
            int b = Integer.parseInt(query[1]);
            
            int lca = findLCA(a, b);
            sb.append(lca).append("\n");
        }
        System.out.print(sb);
    }
    
    // DFS를 사용하여 각 노드의 깊이 정보를 설정합니다.
    static void setDepth(int node, int d) {
        depth[node] = d;
        for (int child : children[node]) {
            setDepth(child, d + 1);
        }
    }
    
    // 두 노드의 LCA를 찾는 함수
    static int findLCA(int a, int b) {
        // 1. 두 노드의 깊이를 동일하게 맞춥니다.
        while (depth[a] > depth[b]) {
            a = parent[a];
        }
        while (depth[b] > depth[a]) {
            b = parent[b];
        }
        
        // 2. 두 노드가 같아질 때까지 동시에 부모 방향으로 올라갑니다.
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        
        return a;
    }
}

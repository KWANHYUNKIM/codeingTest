import java.util.*;
import java.io.*;

public class p11437 {
    // 인접 리스트로 트리 저장
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 각 노드의 깊이 저장 (1번 노드를 루트로)
    static int[] depth;
    // 바이너리 리프팅을 위한 조상 테이블
    static int[][] parent;
    // 최대 레벨 (2^k번째 조상까지 계산할 k의 최대값)
    static int maxLevel;
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        // graph 초기화 (0번 인덱스는 사용하지 않음)
        for (int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        
        // 트리의 간선은 N-1개임
        for (int i = 1; i <= N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // depth 배열과 임시 부모 배열 초기화
        depth = new int[N + 1];
        int[] immediateParent = new int[N + 1];
        Arrays.fill(depth, -1);  // 아직 방문하지 않은 노드는 -1로 표시
        
        // BFS를 사용하여 루트 1부터 각 노드의 깊이와 부모 기록
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        depth[1] = 0;      // 루트의 깊이는 0
        immediateParent[1] = 0;  // 루트의 부모는 0(없음)
        
        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (depth[next] == -1) { // 아직 방문하지 않은 경우
                    depth[next] = depth[current] + 1;
                    immediateParent[next] = current;
                    queue.add(next);
                }
            }
        }
        
        // 바이너리 리프팅 테이블 크기 결정: maxLevel = floor(log2(N)) + 1
        maxLevel = (int)Math.floor(Math.log(N) / Math.log(2)) + 1;
        parent = new int[maxLevel][N + 1];
        
        // 0번째 레벨: 바로 부모 저장
        for (int i = 1; i <= N; i++){
            parent[0][i] = immediateParent[i];
        }
        
        // k번째 레벨 채우기: parent[k][i] = parent[k-1][ parent[k-1][i] ]
        for (int k = 1; k < maxLevel; k++){
            for (int i = 1; i <= N; i++){
                int mid = parent[k - 1][i];
                if (mid != 0) {
                    parent[k][i] = parent[k - 1][mid];
                } else {
                    parent[k][i] = 0;
                }
            }
        }
        //--------------------- 저장 과정 -----------------------------
        
        // 쿼리 처리: 두 노드의 LCA를 구함
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    // LCA를 구하는 함수
    static int lca(int a, int b) {
        // 깊이가 더 깊은 노드가 a가 되도록 swap
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        // 깊이 차이만큼 a를 위로 올림
        int diff = depth[a] - depth[b];
        for (int k = 0; diff > 0; k++){
            if ((diff & 1) == 1) {
                a = parent[k][a];
            }
            diff >>= 1;
        }
        
        // 깊이를 맞춘 후, 두 노드가 같다면 LCA
        if (a == b) return a;
        
        // 두 노드의 조상이 달라질 때까지 동시에 위로 올림
        for (int k = maxLevel - 1; k >= 0; k--){
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        
        // 마지막으로 두 노드의 바로 위 부모가 LCA
        return parent[0][a];
    }
}

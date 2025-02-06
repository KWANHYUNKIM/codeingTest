import java.io.*;
import java.util.*;

public class a2412 {
    static class Node {
        int x, y, moves;
        Node(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
    
    static int n, T;
    static ArrayList<Node> nodes = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        T = Integer.parseInt(firstLine[1]);
        
        // 입력받은 노드들 (홈)
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            nodes.add(new Node(x, y, 0));
        }
        
        // BFS를 위한 큐와 방문 여부 체크 (노드 인덱스 기반)
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        // 시작점 (0, 0)에서 직접 이동 가능한 노드들을 큐에 추가합니다.
        // (시작점은 입력에 없으므로 별도로 처리)
        // 만약 시작점 자체가 T 이상이면 0을 출력.
        if(0 >= T) {
            System.out.println(0);
            return;
        }
        
        // 시작점에서 바로 이동 가능한 노드들을 큐에 넣습니다.
        // 모든 노드에 대해 |x - 0| <= 2, |y - 0| <= 2 인지 확인합니다.
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (Math.abs(node.x) <= 2 && Math.abs(node.y) <= 2) {
                queue.add(new Node(node.x, node.y, 1)); // 1번 이동
                visited[i] = true;
            }
        }
        
        int answer = -1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 목표에 도달했는지 확인 (y좌표가 T 이상)
            if (cur.y >= T) {
                answer = cur.moves;
                break;
            }
            // cur 노드에서 이동 가능한 노드들을 탐색
            for (int i = 0; i < nodes.size(); i++) {
                if (!visited[i]) {
                    Node next = nodes.get(i);
                    if (Math.abs(cur.x - next.x) <= 2 && Math.abs(cur.y - next.y) <= 2) {
                        visited[i] = true;
                        queue.add(new Node(next.x, next.y, cur.moves + 1));
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int order;
    int start;
    int end;

    public Node(int order, int start, int end) {
        this.order = order;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.order, other.order); // `order` 기준 오름차순 정렬
    }

    @Override
    public String toString() {
        return "Node{" +
                "order=" + order +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

public class p1374 {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean visited[];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 노드 입력 및 추가
        for (int i = 1; i <= N; i++) {
            String input[] = br.readLine().split(" ");
            int order = Integer.parseInt(input[0]);
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);
            Node node = new Node(order, start, end);
            graph.get(i).add(node);
        }

        // 각 리스트 정렬
        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Comparator.comparingInt(node -> node.order));
        }

        int count = 0;

        // 정렬 결과 출력
        for (int i = 1; i <= N; i++) {
            for(Node current : graph.get(i)){
                int order = current.order;
                int start = current.start;
                int end = current.end;
                bfs(order,start,end);
            }
        }
    }
    static void bfs(int order, int start, int end){
        Queue<int []> queue = new LinkedList<>();
        visited[order] = true;
        queue.add(new int[] {order ,start, end});

        while(!queue.isEmpty()){
            int current[] = queue.poll();
            
        }
    }
}

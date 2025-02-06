import java.io.*;
import java.util.*;

public class p2251 {
    static int A, B, C;
    // 방문 여부: visited[a][b]가 true면, a, b 상태(그리고 c = C - a - b)는 이미 방문한 상태입니다.
    static boolean[][] visited;
    // 결과를 저장할 집합 (중복 없이, 자동 오름차순 정렬)
    static TreeSet<Integer> result = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        visited = new boolean[A + 1][B + 1];
        
        bfs();
        
        // 결과 출력 (오름차순 정렬된 상태)
        StringBuilder sb = new StringBuilder();
        for (int water : result) {
            sb.append(water).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    
    // BFS 탐색
    static void bfs() {
        Queue<State> queue = new LinkedList<>();
        // 초기 상태: A와 B가 비어있고, C는 가득 차 있음. (즉, (a, b) = (0, 0))
        queue.add(new State(0, 0));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int a = cur.a;
            int b = cur.b;
            int c = C - a - b; // 전체 물은 항상 C이므로 c = C - a - b
            
            // 만약 A가 비어있으면, 현재 C에 담긴 물(c)을 결과에 추가합니다.
            if(a == 0) {
                result.add(c);
            }
            
            // 6가지 물 붓기 연산
            // 1. A → B : A에 있는 물을 B로 붓기
            int pour = Math.min(a, B - b);
            move(queue, a - pour, b + pour);
            
            // 2. A → C : A에 있는 물을 C로 붓기 (즉, A를 모두 비우기)
            // 실제로 pour 양은 a가 되고, 새로운 상태는 (0, b)
            move(queue, 0, b);
            
            // 3. B → A : B에 있는 물을 A로 붓기
            pour = Math.min(b, A - a);
            move(queue, a + pour, b - pour);
            
            // 4. B → C : B에 있는 물을 C로 붓기 (즉, B를 모두 비우기)
            move(queue, a, 0);
            
            // 5. C → A : C에 있는 물을 A로 붓기
            pour = Math.min(c, A - a);
            move(queue, a + pour, b);
            
            // 6. C → B : C에 있는 물을 B로 붓기
            pour = Math.min(c, B - b);
            move(queue, a, b + pour);
        }
    }
    
    // 새로운 상태 (na, nb)가 아직 방문하지 않았다면 큐에 추가하고 방문 처리
    static void move(Queue<State> queue, int na, int nb) {
        if (!visited[na][nb]) {
            visited[na][nb] = true;
            queue.add(new State(na, nb));
        }
    }
    
    // 상태 클래스 (A, B 두 물통의 상태만 저장, C는 전체 물(C)에서 a와 b를 빼서 구함)
    static class State {
        int a, b;
        State(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}

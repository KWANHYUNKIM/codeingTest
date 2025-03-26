import java.io.*;
import java.util.*;

public class a17071 {
    static final int SIZE = 500001;
    // 각 위치에 대해 시간 홀/짝에 따른 방문 여부
    static boolean[][] visited = new boolean[SIZE][2];
    static int N, K;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        int result = bfs();
        System.out.println(result);
    }
    
    static int bfs() {
        // 방문 배열 초기화
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(visited[i], false);
        }
        
        Queue<int[]> q = new LinkedList<>();
        // 상태: {수빈이의 위치, 시간}
        q.add(new int[] {N, 0});
        visited[N][0] = true;
        
        int time = 0;
        while (!q.isEmpty()) {
            // 동생의 위치는 시간 t에 따라 결정됨
            int siblingPos = K + (time * (time + 1)) / 2;
            if (siblingPos >= SIZE) return -1;
            
            // 만약 해당 시간 홀/짝으로 동생의 위치에 도달했다면 정답!
            if (visited[siblingPos][time % 2]) {
                return time;
            }
            
            // 이번 시간에 해당하는 상태들 모두 확장
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.poll();
                int pos = cur[0];
                int curTime = cur[1];
                
                int nextTime = curTime + 1;
                int parity = nextTime % 2;
                
                // 세 가지 이동: pos-1, pos+1, pos*2
                int[] nextPos = { pos - 1, pos + 1, pos * 2 };
                for (int np : nextPos) {
                    if (np >= 0 && np < SIZE && !visited[np][parity]) {
                        visited[np][parity] = true;
                        q.add(new int[] { np, nextTime });
                    }
                }
            }
            time++;
        }
        return -1;
    }
}

import java.io.*;
import java.util.*;

public class p128541 {
    static final int MAX = 100001;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        // 각 위치까지 도달하는 최소 시간과 그 시간에 도달하는 경로의 수를 저장할 배열
        int[] time = new int[MAX];     // 각 위치까지 도달하는 최소 시간
        int[] ways = new int[MAX];     // 해당 최소 시간에 도달하는 경로의 수

        // 배열 초기화: 방문하지 않은 위치는 -1로 초기화
        Arrays.fill(time, -1);

        // BFS 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        time[start] = 0;   // 시작점의 시간은 0
        ways[start] = 1;   // 시작점을 도달하는 경로는 1개

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            // 현재 위치에서 이동할 수 있는 3가지 경우: X-1, X+1, 2*X
            int[] nextPositions = {cur - 1, cur + 1, cur * 2};
            
            for (int next : nextPositions) {
                if (next < 0 || next >= MAX)
                    continue;  // 범위를 벗어나면 무시

                // 아직 방문하지 않은 경우: 새로운 최소 시간 발견
                if (time[next] == -1) {
                    time[next] = time[cur] + 1;  // 최소 시간 갱신
                    ways[next] = ways[cur];      // 경로 수는 현재 경로 수를 그대로 가져감
                    queue.add(next);
                }
                // 이미 방문했지만, 현재 경로로 동일한 최소 시간에 도달하는 경우
                else if (time[next] == time[cur] + 1) {
                    ways[next] += ways[cur];     // 기존 경로에 추가
                }
            }
        }
        
        System.out.println(time[end]);   // 최단 시간 출력
        System.out.println(ways[end]);   // 최단 시간으로 도달하는 경로의 수 출력
    }
}

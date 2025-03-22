import java.util.*;
import java.io.*;

public class p33613 {
    static int N;
    // 나이트 한 번 이동 (8방향)
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        
        // 보드 크기가 작으면 BFS로 탐색 (최대 6×6까지)
        if (N < 7) {
            int count = bfs(R, C);
            System.out.println(count);
        } else {
            // N이 7 이상이면 큰 보드라고 보고,
            // 무한히 연산을 반복하면 시작 위치와 같은 체스판 색깔의 모든 칸에 도달할 수 있다.
            // (1,1)은 짝수이므로, 보드가 홀수이면 짝수 칸: (N*N+1)/2, 홀수 칸: (N*N-1)/2,
            // 보드가 짝수이면 두 색의 칸의 개수는 N*N/2.
            int total = N * N;
            if (N % 2 == 0) {
                System.out.println(total / 2);
            } else {
                if ((R + C) % 2 == 0) { // 시작 위치가 (1,1)과 같은 색(짝수)인 경우
                    System.out.println((total + 1) / 2);
                } else {
                    System.out.println((total - 1) / 2);
                }
            }
        }
    }
    
    // N이 작을 때, BFS로 실제 연결된 칸 수를 구하는 함수 (보드 인덱스 1~N)
    static int bfs(int startR, int startC) {
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        
        // 한 연산은 나이트가 두 번 이동하는 것으로 처리
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            // 두 번 이동하는 모든 경우의 수를 시도
            for (int i = 0; i < 8; i++) {
                int r1 = r + dx[i];
                int c1 = c + dy[i];
                if (r1 < 1 || c1 < 1 || r1 > N || c1 > N) continue;
                for (int j = 0; j < 8; j++) {
                    int r2 = r1 + dx[j];
                    int c2 = c1 + dy[j];
                    if (r2 < 1 || c2 < 1 || r2 > N || c2 > N) continue;
                    if (!visited[r2][c2]) {
                        visited[r2][c2] = true;
                        q.add(new int[]{r2, c2});
                    }
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i][j]) cnt++;
            }
        }
        return cnt;
    }
}

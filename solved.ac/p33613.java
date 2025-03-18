import java.util.*;
import java.io.*;

public class p33613 {
    static int N;
    static boolean[][] visited;
    static int dx[] = {2, 2, -2, -2, 1, 1, -1, -1};
    static int dy[] = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int result = bfs(x, y);
        System.out.println(result);
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N + 1][N + 1];
        visited[startX][startY] = true;
        q.add(new int[]{startX, startY});
        
        int count = 0;
        int level = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();

            if (level == 2) break;
            
            for (int s = 0; s < size; s++) {
                int[] current = q.poll();
                int curX = current[0];
                int curY = current[1];

                for (int i = 0; i < 8; i++) {
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    if (nextX >= 1 && nextY >= 1 && nextX <= N && nextY <= N) {
                        if (!visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            q.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            level++;
            if (level == 2) count = q.size();
        }
        return count;
    }
}

import java.util.*;
import java.io.*;

public class p2146 {
    static int N;
    static int[][] matrix;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    
    // BFS에서 사용할 노드 클래스 (x, y 좌표와 해당 셀까지의 다리 길이)
    static class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N][N];
        
        // 지도 입력 (0: 바다, 1: 육지)
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        
        // DFS를 이용하여 각 섬에 대해 서로 다른 번호(색깔)를 부여
        int color = 1;  // 섬의 번호는 1부터 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    matrix[i][j] = color;
                    dfs(i, j, color);
                    color++;
                }
            }
        }
        // 섬의 총 개수: color - 1
        
        int answer = Integer.MAX_VALUE;
        // 각 섬별로 BFS를 수행하여 다리의 최소 길이를 구함
        for (int islandColor = 1; islandColor < color; islandColor++) {
            answer = Math.min(answer, bfs(islandColor));
        }
        
        System.out.println(answer);
    }
    
    // DFS로 인접한 육지를 같은 color로 칠하는 함수
    static void dfs(int x, int y, int color) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY]) {
                if (matrix[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    matrix[nextX][nextY] = color;
                    dfs(nextX, nextY, color);
                }
            }
        }
    }
    
    // 해당 섬(islandColor)의 경계 셀만을 시작점으로 하여 BFS 수행
    // 다른 섬에 도달하는 최단 다리 길이를 반환함
    static int bfs(int islandColor) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] bfsVisited = new boolean[N][N];
        
        // 해당 섬의 경계 셀(인접에 바다가 있는 육지)만을 큐에 넣음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == islandColor) {
                    // 상하좌우 중 하나라도 바다(0)와 인접해 있으면 경계 셀
                    boolean isBoundary = false;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                        if (matrix[ni][nj] == 0) {
                            isBoundary = true;
                            break;
                        }
                    }
                    if (isBoundary) {
                        queue.offer(new Node(i, j, 0));
                        bfsVisited[i][j] = true;
                    }
                }
            }
        }
        
        // BFS 진행: 바다를 통해 다른 섬까지의 거리를 확장
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x, y = cur.y, dist = cur.dist;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!bfsVisited[nx][ny]) {
                    bfsVisited[nx][ny] = true;
                    // 바다면 BFS로 확장
                    if (matrix[nx][ny] == 0) {
                        queue.offer(new Node(nx, ny, dist + 1));
                    }
                    // 다른 섬의 육지에 도달한 경우
                    else if (matrix[nx][ny] != islandColor) {
                        return dist; // 현재까지의 dist가 다리 길이가 됨
                    }
                }
            }
        }
        return Integer.MAX_VALUE; // 다른 섬을 찾지 못한 경우 (문제 조건상 발생하지 않음)
    }
}

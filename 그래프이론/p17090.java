import java.util.*;
import java.io.*;

public class p17090 {
    static int N, M;
    static char[][] matrix;
    static int[][] dp; // -1: 미방문, 0: 탈출 불가능, 1: 탈출 가능
    static int[] dx = {-1, 1, 0, 0}; // U D L R 순서
    static int[] dy = {0, 0, -1, 1};
    static Map<Character, Integer> directionMap;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new char[N][M];
        dp = new int[N][M];

        // 방향 맵핑
        directionMap = new HashMap<>();
        directionMap.put('U', 0);
        directionMap.put('D', 1);
        directionMap.put('L', 2);
        directionMap.put('R', 3);

        // 미로 입력 및 초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str.charAt(j);
                dp[i][j] = -1; // 아직 판별되지 않은 상태로 초기화
            }
        }

        int result = 0;

        // 모든 칸에서 DFS 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) result++; // 탈출 가능하면 카운트 증가
            }
        }

        System.out.println(result);
    }

    static boolean dfs(int x, int y) {
        // 미로를 벗어나면 탈출 가능
        if (x < 0 || y < 0 || x >= N || y >= M) return true;

        // 이미 방문한 경우 → 저장된 결과 반환
        if (dp[x][y] != -1) return dp[x][y] == 1;

        // 방문 표시 (사이클 방지)
        dp[x][y] = 0;

        // 현재 위치에서 이동할 방향 결정
        int dir = directionMap.get(matrix[x][y]);
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 다음 이동이 탈출 가능하면 현재 위치도 탈출 가능
        if (dfs(nx, ny)) dp[x][y] = 1;

        return dp[x][y] == 1;
    }
}

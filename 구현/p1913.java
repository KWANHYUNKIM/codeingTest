import java.io.*;

public class p1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        int N = Integer.parseInt(br.readLine()); // 홀수 N
        int target = Integer.parseInt(br.readLine()); // 찾을 숫자
        
        int[][] matrix = new int[N][N]; // N x N 배열 생성
        int x = N / 2, y = N / 2; // 중심에서 시작
        int value = 1; // 첫 숫자
        int targetX = 0, targetY = 0; // 입력 숫자의 좌표
        boolean visited[][] = new boolean [N][N];

        // 방향 배열 (위, 오른쪽, 아래, 왼쪽 순서)
        int[] dx = {-1, 0, 1, 0}; // 좌, 상, 우, 하
        int[] dy = {0, 1, 0, -1};
        
        matrix[x][y] = value; // 시작 위치 값 채우기
        if (value == target) { targetX = x; targetY = y; }

        int step = 1; // 각 방향으로 이동할 칸 수
        while (value < N * N) {
            for (int dir = 0; dir < 4; dir++) { // 4방향
                for (int i = 0; i < step; i++) {
                    x += dx[dir];
                    y += dy[dir];

                    if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
                        matrix[x][y] = ++value;
                        visited[x][y] = true;
                        if (value == target) { targetX = x; targetY = y; }
                        if (value == N * N) break; // 마지막 값이면 종료
                    }
                }
                if (dir % 2 == 1) step++; // 상과 하 방향 이동 후 step 증가
            }
        }

        // 배열 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 좌표 출력
        System.out.println((targetX + 1) + " " + (targetY + 1)); // 1-based 좌표
    }
}


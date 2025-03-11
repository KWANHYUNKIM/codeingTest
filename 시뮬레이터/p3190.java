import java.util.*;
import java.io.*;

public class p3190 {
    static int N, K, L;
    static int[][] board;
    static Deque<int[]> snake = new LinkedList<>();
    static Map<Integer, Character> directionChanges = new HashMap<>();

    // 방향: 오른쪽(0), 아래(1), 왼쪽(2), 위(3)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int direction = 0; // 초기 방향: 오른쪽

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 보드 크기 입력
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];

        // 2. 사과 위치 입력
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1; // 사과 위치
        }

        // 3. 방향 변환 입력
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directionChanges.put(time, dir);
        }

        // 4. 게임 실행
        System.out.println(playGame());
    }

    static int playGame() {
        int time = 0;
        int x = 1, y = 1; // 뱀 초기 위치
        snake.add(new int[]{x, y});
        board[x][y] = 2; // 뱀의 위치 표시

        while (true) {
            time++;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 벽에 부딪히거나, 자기 몸에 부딪히면 종료
            if (nx <= 0 || ny <= 0 || nx > N || ny > N || board[nx][ny] == 2) {
                return time;
            }

            // 이동한 위치에 사과가 있으면 길이 유지
            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
            } else { // 사과가 없으면 꼬리 제거 (길이 유지)
                board[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0; // 꼬리 제거
            }

            // 방향 변경 시간이 되면 변경
            if (directionChanges.containsKey(time)) {
                char turnDirection = directionChanges.get(time);
                direction = turn(direction, turnDirection);
            }

            // 현재 머리 위치 갱신
            x = nx;
            y = ny;
        }
    }

    static int turn(int dir, char turnDirection) {
        if (turnDirection == 'L') {
            return (dir + 3) % 4; // 왼쪽으로 회전 (반시계 방향)
        } else {
            return (dir + 1) % 4; // 오른쪽으로 회전 (시계 방향)
        }
    }
}

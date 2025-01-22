import java.util.*;
import java.io.*;

public class p1525 {
    static final String TARGET = "123456780"; // 목표 상태
    static final int SIZE = 3; // 퍼즐 크기
    static int dx[] = {1, -1, 0, 0}; // 상하좌우 이동
    static int dy[] = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder startState = new StringBuilder();
        int zeroX = 0, zeroY = 0;

        // 입력 받아 초기 상태 생성
        for (int i = 0; i < SIZE; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < SIZE; j++) {
                int num = Integer.parseInt(input[j]);
                startState.append(num);
                if (num == 0) { // 빈 칸 위치 저장
                    zeroX = i;
                    zeroY = j;
                }
            }
        }

        // BFS 수행
        int result = bfs(startState.toString(), zeroX * SIZE + zeroY);
        System.out.println(result);
    }

    static int bfs(String start, int zeroIndex) {
        Set<String> visited = new HashSet<>(); // 방문 상태 기록
        Queue<PuzzleState> queue = new LinkedList<>();

        queue.offer(new PuzzleState(start, zeroIndex, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            PuzzleState current = queue.poll();

            // 목표 상태 도달
            if (current.state.equals(TARGET)) {
                return current.moves;
            }

            int zeroPos = current.zeroIndex; // 빈 칸 위치
            int x = zeroPos / SIZE;
            int y = zeroPos % SIZE;

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 확인
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE) {
                    int newZeroPos = nx * SIZE + ny;
                    String nextState = swap(current.state, zeroPos, newZeroPos);

                    // 방문하지 않은 상태라면 큐에 추가
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(new PuzzleState(nextState, newZeroPos, current.moves + 1));
                    }
                }
            }
        }

        // 목표 상태 도달 불가
        return -1;
    }

    // 문자열에서 두 인덱스의 값을 교환
    private static String swap(String state, int i, int j) {
        char[] chars = state.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    // 퍼즐 상태 클래스
    private static class PuzzleState {
        String state; // 현재 퍼즐 상태
        int zeroIndex; // 빈 칸 위치
        int moves; // 이동 횟수

        PuzzleState(String state, int zeroIndex, int moves) {
            this.state = state;
            this.zeroIndex = zeroIndex;
            this.moves = moves;
        }
    }
}

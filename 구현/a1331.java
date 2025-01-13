import java.util.*;
import java.io.*;

public class a1331 {
    static int size = 6;
    static boolean visited[][] = new boolean[size][size];
    static int dx[] = {2, 2, -2, -2, 1, 1, -1, -1};
    static int dy[] = {1, -1, 1, -1, 2, -2, 2, -2};
    static int startX;
    static int startY;
    static String location[] = new String[size * size];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < size * size; i++) {
            location[i] = br.readLine(); // 모든 입력값을 location 배열에 저장
        }

        boolean check = chess();

        if (check) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    static boolean chess() {
        for (int i = 0; i < size * size; i++) {
            String current = location[i];
            String next = location[(i + 1) % (size * size)]; // 마지막에서 첫 번째로 연결 확인

            char currentX = current.charAt(0);
            char currentY = current.charAt(1);
            char nextX = next.charAt(0);
            char nextY = next.charAt(1);

            int x1 = currentX - 'A'; // 현재 위치 x
            int y1 = currentY - '1'; // 현재 위치 y
            int x2 = nextX - 'A';    // 다음 위치 x
            int y2 = nextY - '1';    // 다음 위치 y

            // 나이트의 이동 규칙 확인
            boolean validMove = false;
            for (int j = 0; j < 8; j++) {
                if (x1 + dx[j] == x2 && y1 + dy[j] == y2) {
                    validMove = true;
                    break;
                }
            }
            if (!validMove) {
                return false; // 나이트 이동 규칙 위반
            }

            // 중복 방문 체크
            if (visited[x1][y1]) {
                return false; // 중복 방문 발견
            }
            visited[x1][y1] = true;
        }
        return true;
    }
}

import java.util.*;
import java.io.*;

public class p10157 {
    static int sizeX;
    static int sizeY;
    static int matrix[][];
    static boolean visited[][];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int count = 1;

        sizeX = Integer.parseInt(input[0]); // 열 개수
        sizeY = Integer.parseInt(input[1]); // 행 개수

        int seat = Integer.parseInt(br.readLine()); // 찾으려는 좌석 번호

        matrix = new int[sizeY][sizeX];
        visited = new boolean[sizeY][sizeX]; // 방문 여부 확인

        int dx[] = {0, 1, 0, -1}; // 방향 배열 (우, 하, 좌, 상)
        int dy[] = {1, 0, -1, 0};

        int x = 0, y = 0, direction = 0; // 초기 위치와 방향 설정
        boolean found = false; // 찾으려는 좌석 번호를 발견했는지 여부
        int resultX = 0, resultY = 0; // 좌표 결과

        while (count <= sizeX * sizeY) {
            matrix[y][x] = count; // 현재 위치에 값을 채움
            visited[y][x] = true; // 방문 표시

            if (count == seat) { // 찾으려는 좌석 번호인지 확인
                resultX = x + 1; // 열 위치 (1-based)
                resultY = y + 1; // 행 위치 (1-based)
                found = true;
            }

            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            if (nextX < 0 || nextX >= sizeX || nextY < 0 || nextY >= sizeY || visited[nextY][nextX]) {
                direction = (direction + 1) % 4;
                nextX = x + dx[direction];
                nextY = y + dy[direction];
            }

            // 위치 갱신
            x = nextX;
            y = nextY;
            count++;
        }

        // 결과 출력
        if (found) {
            System.out.println(resultX + " " + resultY);
        } else {
            System.out.println("0");
        }
    }
}

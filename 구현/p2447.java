import java.io.*;

public class p2447 {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N은 3의 거듭제곱
        map = new char[N][N];

        // 패턴 초기화
        drawPattern(0, 0, N, false);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void drawPattern(int x, int y, int size, boolean isBlank) {
        if (isBlank) {
            // 공백 처리
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            // 크기가 1이면 별 추가
            map[x][y] = '*';
            return;
        }

        int newSize = size / 3; // 다음 패턴 크기
        int count = 0; // 9개의 부분 중 중앙인지 확인

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                // 중앙 부분은 공백 처리
                drawPattern(x + i * newSize, y + j * newSize, newSize, count == 5);
            }
        }
    }
}
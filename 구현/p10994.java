import java.io.*;

public class p10994 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int size = 4 * N - 3; // 배열 크기
        char[][] matrix = new char[size][size];

        // 배열 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = ' ';
            }
        }

        // 재귀적으로 별 그리기
        drawStar(matrix, 0, size - 1);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 재귀적으로 테두리 별 그리기
    private static void drawStar(char[][] matrix, int start, int end) {
        if (start > end) {
            return; // 더 이상 그릴 영역이 없으면 종료
        }

        // 테두리 그리기
        for (int i = start; i <= end; i++) {
            matrix[start][i] = '*'; // 상단
            matrix[end][i] = '*';   // 하단
            matrix[i][start] = '*'; // 좌측
            matrix[i][end] = '*';   // 우측
        }

        // 내부 작은 패턴으로 이동
        drawStar(matrix, start + 2, end - 2);
    }
}

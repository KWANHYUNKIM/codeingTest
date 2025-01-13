import java.util.*;
import java.io.*;

public class a2567 {
    static int size = 100;
    static int[][] matrix = new int[size][size];
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int perimeter = 0;

        // 색종이의 위치 입력 및 색종이 그리기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            draw(startX, startY);
        }

        // 둘레 계산
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    // 현재 셀에서 상하좌우 확인
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        // 경계를 넘거나 값이 0이면 둘레 증가
                        if (nx < 0 || ny < 0 || nx >= size || ny >= size || matrix[nx][ny] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        System.out.println(perimeter);
    }

    static void draw(int startX, int startY) {
        // 색종이의 10x10 크기를 matrix에 표시
        for (int i = startX; i < startX + 10; i++) {
            for (int j = startY; j < startY + 10; j++) {
                matrix[i][j] = 1;
            }
        }
    }
}

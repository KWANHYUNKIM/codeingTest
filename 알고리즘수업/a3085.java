import java.io.*;
public class a3085 {
    static int N;
    static char[][] matrix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new char[N][N];

        for(int i = 0 ; i < N; i++){
            String input = br.readLine();
            for(int j = 0 ; j < N; j++){
                matrix[i][j] = input.charAt(j);
            }
        }

        // 우선 현재 상태에서의 최대 연속 사탕 길이
        int answer = getMaxCandy(matrix);

        // 모든 칸(i, j)에 대해 오른쪽, 아래 칸과 스왑 시도
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 1) 오른쪽 칸과 스왑
                if (j + 1 < N && matrix[i][j] != matrix[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    answer = Math.max(answer, getMaxCandy(matrix));
                    swap(i, j, i, j + 1); // 원상 복구
                }

                // 2) 아래 칸과 스왑
                if (i + 1 < N && matrix[i][j] != matrix[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    answer = Math.max(answer, getMaxCandy(matrix));
                    swap(i, j, i + 1, j); // 원상 복구
                }
            }
        }

        System.out.println(answer);
    }

    // 두 칸 교환
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    // 행, 열 전체를 확인하여 연속된 같은 색 사탕의 최대 길이를 구함
    static int getMaxCandy(char[][] board) {
        int maxLength = 1;

        // 모든 행 검사
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if(board[i][j] == board[i][j-1]) {
                    count++;
                } else {
                    maxLength = Math.max(maxLength, count);
                    count = 1;
                }
            }
            maxLength = Math.max(maxLength, count);  // 마지막 구간 확인
        }

        // 모든 열 검사
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if(board[i][j] == board[i-1][j]) {
                    count++;
                } else {
                    maxLength = Math.max(maxLength, count);
                    count = 1;
                }
            }
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }
}

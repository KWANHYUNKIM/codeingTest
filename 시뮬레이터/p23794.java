import java.io.*;

public class p23794 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = (2 * N) + 1;

        // 1) 맨 윗줄
        for (int i = 0; i < size; i++) {
            System.out.print('@');
        }
        System.out.println(); // 줄바꿈

        // 2) 가운데 줄들
        for (int row = 0; row < size - 2; row++) {
            // 왼쪽 테두리 @
            System.out.print('@');
            // 가운데 부분은 공백
            for (int col = 0; col < size - 2; col++) {
                System.out.print(' ');
            }
            // 오른쪽 테두리 @
            System.out.print('@');
            System.out.println();
        }

        // 3) 맨 아랫줄
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                System.out.print('@');
            }
            System.out.println();
        }
    }
}

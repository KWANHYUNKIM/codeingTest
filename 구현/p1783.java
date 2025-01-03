import java.io.*;

public class p1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int result = 0;

        if (N == 1) {
            // N이 1인 경우, 병든 나이트는 이동할 수 없음
            result = 1;
        } else if (N == 2) {
            // N이 2인 경우, 두 가지 이동 방법만 사용 가능
            result = Math.min(4, (M + 1) / 2);
        } else {
            // N이 3 이상인 경우
            if (M < 7) {
                // 가로 길이가 7 미만이면 최대 4칸만 방문 가능
                result = Math.min(4, M);
            } else {
                // 가로 길이가 7 이상이면 이동 제약 없이 가능
                result = M - 2;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}

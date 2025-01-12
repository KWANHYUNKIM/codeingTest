import java.io.*;
import java.util.*;

public class p31883 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 횡단보도의 수
        int[][] matrix = new int[N][4];

        // 입력 처리
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        int currentTime = 0; // 현재 시간

        for (int i = 0; i < N; i++) {
            int a = matrix[i][0]; // 횡단보도를 이용하는 경우 걸리는 시간
            int b = matrix[i][1]; // 육교를 이용하는 경우 걸리는 시간
            int c = matrix[i][2]; // 신호등 녹색 시간
            int d = matrix[i][3]; // 신호등 적색 시간

            // 육교를 선택한 경우
            int timeUsingBridge = currentTime + b;

            // 횡단보도를 선택한 경우
            int cycleTime = c + d; // 한 사이클의 총 시간
            int modTime = currentTime % cycleTime;

            int waitTime = 0;
            if (modTime >= c) {
                waitTime = cycleTime - modTime; // 적색일 때 대기 시간 계산
            }

            int timeUsingCrosswalk = currentTime + waitTime + a;

            // 최적의 선택으로 시간 업데이트
            currentTime = Math.min(timeUsingBridge, timeUsingCrosswalk);
        }

        // 결과 출력
        System.out.println(currentTime);
    }
}

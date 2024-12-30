import java.util.*;
import java.io.*;

public class p25377 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int minTime = Integer.MAX_VALUE; // 최소 시간 저장 변수

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]); // 가게까지 가는 시간
            int B = Integer.parseInt(input[1]); // 빵이 도착하는 시간

            // A <= B를 만족하는 경우, 최소값 갱신
            if (A <= B) {
                minTime = Math.min(minTime, B);
            }
        }

        // 결과 출력
        if (minTime == Integer.MAX_VALUE) {
            System.out.println("-1"); // 조건 만족하는 가게가 없는 경우
        } else {
            System.out.println(minTime); // 최소 시간 출력
        }
    }
}

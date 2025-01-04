import java.util.*;
import java.io.*;

public class p32622 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        // 누적합 배열 계산
        int[] prefixSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + cards[i];
        }

        // 초기 상태에서 색깔이 같은 최대 연속 길이 계산
        int originalMax = getMaxSameColorLength(cards, N);
        int maxScore = originalMax;

        // 뒤집기 가능한 모든 경우에 대해 최대 길이 계산
        for (int x = 0; x <= N; x++) {
            // 뒤집은 구간의 흰색 개수
            int flippedWhite = x - (prefixSum[x] - prefixSum[0]);

            // 뒤집지 않은 구간의 흰색 개수
            int unchangedWhite = (N - x) - (prefixSum[N] - prefixSum[x]);

            // 최대 점수 갱신
            maxScore = Math.max(maxScore, flippedWhite + unchangedWhite);
        }

        System.out.println(maxScore);
    }

    // 배열에서 색깔이 같은 최대 연속 길이를 계산하는 함수
    private static int getMaxSameColorLength(int[] cards, int N) {
        int maxLen = 0, currentLen = 1;

        for (int i = 1; i < N; i++) {
            if (cards[i] == cards[i - 1]) {
                currentLen++;
            } else {
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 1;
            }
        }
        maxLen = Math.max(maxLen, currentLen); // 마지막 연속 길이 갱신

        return maxLen;
    }
}

import java.util.*;
import java.io.*;

public class p2961 {
    static int N; // 재료의 개수
    static int[] sour; // 신맛 배열
    static int[] bitter; // 쓴맛 배열
    static int minDifference = Integer.MAX_VALUE; // 신맛과 쓴맛의 최소 차이

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        N = Integer.parseInt(br.readLine());
        sour = new int[N];
        bitter = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            sour[i] = Integer.parseInt(input[0]); // 신맛
            bitter[i] = Integer.parseInt(input[1]); // 쓴맛
        }

        // 백트래킹 시작
        backtrack(0, 1, 0, 0);

        // 결과 출력
        System.out.println(minDifference);
    }

    // 백트래킹 함수
    static void backtrack(int idx, int currentSour, int currentBitter, int selectedCount) {
        // 종료 조건: 모든 재료를 다 탐색한 경우
        if (idx == N) {
            // 재료를 적어도 하나 선택한 경우만 계산
            if (selectedCount > 0) {
                minDifference = Math.min(minDifference, Math.abs(currentSour - currentBitter));
            }
            return;
        }

        // 현재 재료를 선택하지 않는 경우
        backtrack(idx + 1, currentSour, currentBitter, selectedCount);

        // 현재 재료를 선택하는 경우
        backtrack(
            idx + 1,
            currentSour * sour[idx], // 신맛 곱하기
            currentBitter + bitter[idx], // 쓴맛 더하기
            selectedCount + 1 // 선택한 재료 개수 증가
        );
    }
}

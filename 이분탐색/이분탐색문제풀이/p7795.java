import java.util.*;
import java.io.*;

public class p7795 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            // A와 B의 크기 입력
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); // A의 수
            int M = Integer.parseInt(input[1]); // B의 수

            // A와 B의 배열 입력
            int[] A = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            int[] B = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            Arrays.sort(A); // A 배열 정렬
            Arrays.sort(B); // B 배열 정렬

            int count = 0; // 조건을 만족하는 쌍의 개수

            // A의 각 원소에 대해 B의 원소 중 작은 값 개수를 찾음
            for (int i = 0; i < N; i++) {
                count += lowerBound(B, A[i]); // B에서 A[i]보다 작은 값의 개수 누적
            }

            sb.append(count).append("\n"); // 결과 저장
        }

        System.out.print(sb.toString()); // 결과 출력
    }

    // lowerBound 구현: B에서 target보다 작은 값의 개수를 반환
    static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1; // 더 큰 값을 찾아 이동
            } else {
                right = mid; // mid 포함되지 않으므로 이동
            }
        }
        return left; // lowerBound 위치가 target보다 작은 원소의 개수
    }
}

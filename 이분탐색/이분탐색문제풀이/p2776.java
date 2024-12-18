import java.io.*;
import java.util.*;

public class p2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            // 수첩 1 입력 처리
            int N = Integer.parseInt(br.readLine());
            int[] notebook1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                notebook1[i] = Integer.parseInt(st.nextToken());
            }

            // 수첩 2 입력 처리
            int M = Integer.parseInt(br.readLine());
            int[] notebook2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                notebook2[i] = Integer.parseInt(st.nextToken());
            }

            // 수첩 1 정렬
            Arrays.sort(notebook1);

            // 수첩 2의 각 원소에 대해 이분 탐색
            for (int num : notebook2) {
                if (binarySearch(notebook1, num)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }

        // 결과 출력
        System.out.print(sb);
    }

    // 이분 탐색 메서드
    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}

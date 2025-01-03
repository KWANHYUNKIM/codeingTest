import java.util.*;
import java.io.*;

public class p25631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] matrix = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(input[i]);
        }

        // 크기 오름차순 정렬
        Arrays.sort(matrix);

        // 비어있는 마트료시카 그룹을 추적하기 위한 리스트
        List<Integer> groups = new ArrayList<>();

        for (int size : matrix) {
            boolean placed = false;

            // 현재 마트료시카를 기존 그룹에 넣을 수 있는지 확인
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i) < size) {
                    groups.set(i, size); // 그룹 크기 업데이트
                    placed = true;
                    break;
                }
            }

            // 넣을 수 없으면 새로운 그룹 생성
            if (!placed) {
                groups.add(size);
            }
        }

        // 남은 그룹의 수 출력
        System.out.println(groups.size());
    }
}

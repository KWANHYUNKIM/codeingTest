import java.io.*;
import java.util.*;

public class a1976 {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 수와 여행 계획에 포함된 도시 수 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 부모 배열 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 도시 간 연결 정보 입력 및 Union 수행
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                if (input[j - 1].equals("1")) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력
        String[] tripSchedule = br.readLine().split(" ");
        int root = find(Integer.parseInt(tripSchedule[0]));

        // 여행 계획에 포함된 모든 도시가 같은 연결 요소에 있는지 확인
        boolean possible = true;
        for (String city : tripSchedule) {
            if (find(Integer.parseInt(city)) != root) {
                possible = false;
                break;
            }
        }

        // 결과 출력
        System.out.println(possible ? "YES" : "NO");
    }

    // Find 함수: 경로 압축을 사용해 부모 찾기
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union 함수: 두 도시를 같은 집합으로 합치기
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}

import java.util.*;
import java.io.*;


class Point {
    int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class p15686 {
    static int N, M, answer = Integer.MAX_VALUE;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // 입력 처리: BufferedReader와 StringTokenizer를 사용합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 지도 정보를 읽으며, 집과 치킨집의 좌표를 각각 저장합니다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) { // 집
                    houses.add(new Point(i, j));
                } else if (val == 2) { // 치킨집
                    chickens.add(new Point(i, j));
                }
            }
        }
        
        // 백트래킹을 통해 M개 치킨집 조합 생성
        dfs(0, new ArrayList<Point>());
        System.out.println(answer);
    }

    static void dfs(int idx, ArrayList<Point> selected) {
        if (selected.size() == M) {
            // 현재 선택된 치킨집 조합에 대한 전체 치킨 거리 계산
            int sum = 0;
            for (Point house : houses) {
                int minDist = Integer.MAX_VALUE;
                for (Point chicken : selected) {
                    int dist = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
                    minDist = Math.min(minDist, dist);
                }
                sum += minDist;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            dfs(i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}

import java.util.*;
import java.io.*;

class Draw {
    int x, y;

    public Draw(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p2304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 기둥 정보를 저장할 리스트
        List<Draw> pillars = new ArrayList<>();

        // 입력받은 기둥 정보를 리스트에 추가
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            pillars.add(new Draw(x, y));
        }

        // x 기준으로 정렬
        pillars.sort(Comparator.comparingInt(p -> p.x));

        // 최대 높이 및 해당 기둥의 위치 찾기
        int maxIndex = 0;
        int maxHeight = 0;
        for (int i = 0; i < pillars.size(); i++) {
            if (pillars.get(i).y > maxHeight) {
                maxHeight = pillars.get(i).y;
                maxIndex = i;
            }
        }

        // 왼쪽에서 최대 높이 기둥까지의 면적 계산
        int area = 0;
        int currentHeight = 0;
        for (int i = 0; i <= maxIndex; i++) {
            currentHeight = Math.max(currentHeight, pillars.get(i).y);
            if (i < maxIndex) {
                area += (pillars.get(i + 1).x - pillars.get(i).x) * currentHeight;
            }
        }

        // 오른쪽에서 최대 높이 기둥까지의 면적 계산
        currentHeight = 0;
        for (int i = pillars.size() - 1; i > maxIndex; i--) {
            currentHeight = Math.max(currentHeight, pillars.get(i).y);
            area += (pillars.get(i).x - pillars.get(i - 1).x) * currentHeight;
        }

        // 최대 높이 기둥의 면적 추가
        area += maxHeight;

        System.out.println(area);
    }
}
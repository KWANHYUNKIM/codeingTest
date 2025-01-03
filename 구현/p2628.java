import java.util.*;
import java.io.*;

public class p2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 종이의 가로와 세로 길이 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        
        // 자를 점선의 개수 입력
        int n = Integer.parseInt(br.readLine());
        
        // 가로와 세로 점선 리스트
        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();
        
        // 가로와 세로 점선 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            if (direction == 0) {
                horizontal.add(position);
            } else {
                vertical.add(position);
            }
        }
        
        // 점선 정렬
        Collections.sort(horizontal);
        Collections.sort(vertical);
        
        // 가로/세로 점선의 끝에 전체 길이를 추가
        horizontal.add(height);
        vertical.add(width);
        
        // 최대 높이와 너비 계산
        int maxHeight = getMaxDistance(horizontal);
        int maxWidth = getMaxDistance(vertical);
        
        // 가장 큰 조각의 넓이 출력
        System.out.println(maxHeight * maxWidth);
    }

    // 점선 사이의 최대 거리 계산 함수
    private static int getMaxDistance(List<Integer> lines) {
        int maxDistance = lines.get(0); // 첫 점선까지의 거리
        for (int i = 1; i < lines.size(); i++) {
            maxDistance = Math.max(maxDistance, lines.get(i) - lines.get(i - 1));
        }
        return maxDistance;
    }
}
import java.util.*;
import java.io.*;

public class a2002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력: 차량 대수
        int N = Integer.parseInt(br.readLine());
        
        // 입력: 입구 순서
        Map<String, Integer> startOrder = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            startOrder.put(car, i); // 차량 번호와 입구 순서를 저장
        }
        
        // 입력: 출구 순서
        List<Integer> exitOrder = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            exitOrder.add(startOrder.get(car)); // 입구 순서에 해당하는 번호를 저장
        }
        
        // 추월 계산: 역순 비교
        int overtakeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (exitOrder.get(i) > exitOrder.get(j)) {
                    overtakeCount++;
                    break; // 현재 차량(i)은 추월한 것이 확정되었으므로 더 비교하지 않아도 됨
                }
            }
        }
        
        // 결과 출력
        System.out.println(overtakeCount);
    }
}

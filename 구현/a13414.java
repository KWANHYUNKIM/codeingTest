import java.util.*;
import java.io.*;

public class a13414 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 최대 수강 가능 인원
        int M = Integer.parseInt(st.nextToken()); // 대기목록 길이

        LinkedHashSet<String> students = new LinkedHashSet<>(); // 입력 순서 유지 & 중복 제거

        for (int i = 0; i < M; i++) {
            String studentId = br.readLine();
            // 이미 있는 학번이면 제거하고 다시 추가 (맨 뒤로 이동)
            if (students.contains(studentId)) {
                students.remove(studentId);
            }
            students.add(studentId);
        }

        // 결과 출력
        Iterator<String> iterator = students.iterator();
        while (iterator.hasNext() && N > 0) {
            System.out.println(iterator.next());
            N--;
        }
    }
}

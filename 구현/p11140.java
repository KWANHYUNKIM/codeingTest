import java.io.*;
import java.util.regex.*;

public class p11140 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int t = 0; t < T; t++) {
            String input = br.readLine().trim();
            
            // 0회: 이미 "lol"을 포함하는 경우
            if (input.contains("lol")) {
                System.out.println("0");
                continue;
            }
            
            // 1회: 편집 거리 1에 해당하는 경우
            // 치환: 길이 3인 부분 문자열 중
            //   - 첫 글자, 세 글자가 'l'인 경우 ("l.l")
            //   - 처음 두 글자가 "lo" ("lo.")
            //   - 마지막 두 글자가 "ol" (".ol")
            boolean edit1 = false;
            if (input.matches(".*l.l.*") || input.matches(".*lo..*") || input.matches(".*.ol.*")) {
                edit1 = true;
            }
            // 삽입: 길이 2인 부분 문자열이 "ol", "lo", 또는 "ll"인 경우
            if (input.contains("ol") || input.contains("lo") || input.contains("ll")) {
                edit1 = true;
            }
            // 삭제: 길이 4인 부분 문자열 중
            //   - 어떤 한 글자만 추가된 경우는
            //     ".lol", "l.ol", "lo.l", "lol." 패턴에 해당할 수 있음.
            if (input.matches(".*.lol.*") || input.matches(".*l.ol.*")
                    || input.matches(".*lo.l.*") || input.matches(".*lol..*")) {
                edit1 = true;
            }
            
            if (edit1) {
                System.out.println("1");
                continue;
            }
            
            // 2회: 'l'이나 'o'가 하나라도 있으면 2회로 가정
            if (input.contains("l") || input.contains("o")) {
                System.out.println("2");
            } else {
                // 3회: 둘 다 없는 경우 (예: "abc")
                System.out.println("3");
            }
        }
    }
}

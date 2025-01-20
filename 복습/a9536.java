import java.util.*;
import java.io.*;

public class a9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 여우 소리를 포함한 전체 녹음
            String[] recorded = br.readLine().split(" ");

            // 동물들의 소리 저장
            Set<String> knownSounds = new HashSet<>();

            while (true) {
                String line = br.readLine();

                // 여우의 질문 확인
                if (line.equals("what does the fox say?")) {
                    break;
                }

                // 동물 소리를 저장
                String[] parts = line.split(" ");
                knownSounds.add(parts[2]);
            }

            // 여우의 소리 필터링
            for (String sound : recorded) {
                if (!knownSounds.contains(sound)) {
                    sb.append(sound).append(" ");
                }
            }

            sb.append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}

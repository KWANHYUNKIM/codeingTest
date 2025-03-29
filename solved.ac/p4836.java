import java.io.*;
import java.util.*;

public class p4836 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) break;

            String[] dances = input.split(" ");
            int l = dances.length;
            boolean[] check = new boolean[6]; // 1~5번 규칙
            Arrays.fill(check, true); // 모든 규칙을 true로 시작

            boolean hasDip = false;

            for (int i = 0; i < l; i++) {
                if (dances[i].equals("dip")) {
                    hasDip = true;
                    if (!isValidDip(dances, i)) {
                        dances[i] = "DIP";
                        check[1] = false;
                    }
                }
            }

            // 조건 2: 마지막 3동작이 clap stomp clap
            if (l < 3 || !(dances[l - 3].equals("clap") && dances[l - 2].equals("stomp") && dances[l - 1].equals("clap"))) {
                check[2] = false;
            }

            // 조건 3: twirl이 있으면 hop도 있어야 함
            boolean hasTwirl = false, hasHop = false;
            for (String d : dances) {
                if (d.equals("twirl")) hasTwirl = true;
                if (d.equals("hop")) hasHop = true;
            }
            if (hasTwirl && !hasHop) {
                check[3] = false;
            }

            // 조건 4: jiggle로 시작하면 안됨
            if (dances[0].equals("jiggle")) {
                check[4] = false;
            }

            // 조건 5: dip은 반드시 존재해야 함
            if (!hasDip) {
                check[5] = false;
            }

            // 위반 규칙 수집
            List<Integer> errors = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                if (!check[i]) errors.add(i);
            }

            // 출력 문자열 조립
            StringBuilder sb = new StringBuilder();
            for (String d : dances) {
                sb.append(d).append(" ");
            }
            String resultDance = sb.toString().trim();

            if (errors.isEmpty()) {
                System.out.println("form ok: " + resultDance);
            } else {
                StringBuilder errorMsg = new StringBuilder();
                if (errors.size() == 1) {
                    errorMsg.append("form error ").append(errors.get(0)).append(": ");
                } else {
                    errorMsg.append("form errors ");
                    for (int i = 0; i < errors.size(); i++) {
                        if (i > 0 && i == errors.size() - 1) {
                            errorMsg.append("and ");
                        }
                        errorMsg.append(errors.get(i));
                        if (i < errors.size() - 2) {
                            errorMsg.append(", ");
                        } else if (i == errors.size() - 2) {
                            errorMsg.append(" ");
                        }
                    }
                    errorMsg.append(": ");
                }
                errorMsg.append(resultDance);
                System.out.println(errorMsg.toString());
            }
        }
    }

    private static boolean isValidDip(String[] dances, int i) {
        if (i - 1 >= 0 && dances[i - 1].equals("jiggle")) return true;
        if (i - 2 >= 0 && dances[i - 2].equals("jiggle")) return true;
        if (i + 1 < dances.length && dances[i + 1].equals("twirl")) return true;
        return false;
    }
}

import java.util.*;
import java.io.*;

public class a11140 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            if (input.contains("lol")) {
                System.out.println("0");
                continue;
            }

            if (input.contains("lo") || input.contains("ol") || input.contains("ll")) {
                System.out.println("1");
                continue;
            }

            boolean hasL = input.contains("l");
            boolean hasO = input.contains("o");

            if (hasL || hasO) {
                System.out.println("2");
            } else {
                System.out.println("3");
            }
        }
    }
}

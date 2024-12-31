import java.util.*;
import java.io.*;

public class p10882 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        String[] timeParts = input[0].split(":");
        int yjHours = Integer.parseInt(timeParts[0]);
        int yjMinutes = Integer.parseInt(timeParts[1]);

        double yjTimeZone = Double.parseDouble(input[1].substring(3));
        int yjOffsetMinutes = (int) (yjTimeZone * 60);

        int yjTotalMinutes = yjHours * 60 + yjMinutes - yjOffsetMinutes;

        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            String coworkerTimeZone = br.readLine();
            double coworkerOffset = Double.parseDouble(coworkerTimeZone.substring(3));
            int coworkerOffsetMinutes = (int) (coworkerOffset * 60);

            int coworkerTotalMinutes = yjTotalMinutes + coworkerOffsetMinutes;

            coworkerTotalMinutes = (coworkerTotalMinutes % 1440 + 1440) % 1440;

            int coworkerHours = coworkerTotalMinutes / 60;
            int coworkerMinutes = coworkerTotalMinutes % 60;
            sb.append(String.format("%02d:%02d\n", coworkerHours, coworkerMinutes));
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}

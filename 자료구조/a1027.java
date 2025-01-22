import java.util.*;
import java.io.*;

public class a1027 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(input[i]);
        }

        int maxVisible = 0;

        for (int i = 0; i < N; i++) {
            int visibleCount = 0;

            // 왼쪽 빌딩 탐색
            double maxSlopeLeft = Double.NEGATIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (heights[i] - heights[j]) / (i - j);
                if (slope > maxSlopeLeft) {
                    maxSlopeLeft = slope;
                    visibleCount++;
                }
            }

            // 오른쪽 빌딩 탐색
            double maxSlopeRight = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double slope = (double) (heights[j] - heights[i]) / (j - i);
                if (slope > maxSlopeRight) {
                    maxSlopeRight = slope;
                    visibleCount++;
                }
            }

            maxVisible = Math.max(maxVisible, visibleCount);
        }

        System.out.println(maxVisible);
    }
}

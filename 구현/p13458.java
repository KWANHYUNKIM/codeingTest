import java.util.*;
import java.io.*;

public class p13458 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] inputA = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
        }
        
        String[] input = br.readLine().split(" ");
        long B = Long.parseLong(input[0]);
        long C = Long.parseLong(input[1]);

        long count = 0;
        for (int i = 0; i < N; i++) {
            count++;
            long remain = A[i] - B;
            if (remain > 0) {
                count += remain / C;
                if (remain % C != 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

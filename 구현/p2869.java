import java.util.*;
import java.io.*;

public class p2869 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        
        int A = Integer.parseInt(input[0]); // 낮에 올라가는 높이
        int B = Integer.parseInt(input[1]); // 밤에 미끄러지는 높이
        int V = Integer.parseInt(input[2]); // 나무 막대 높이

        // 마지막 날 제외한 높이 계산
        int remainingHeight = V - A;

        // 하루에 올라가는 실제 높이
        int dailyClimb = A - B;

        // 필요한 날 계산
        int days = (int) Math.ceil((double) remainingHeight / dailyClimb) + 1;

        System.out.println(days);
    }
}

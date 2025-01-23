import java.util.*;
import java.io.*;

public class p3084 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input[] = br.readLine().split(" ");

        int N1SIZE = Integer.parseInt(input[0]);
        int N2SIZE = Integer.parseInt(input[1]);

        int size = N1SIZE + N2SIZE;

        String N1 = br.readLine();
        String N2 = br.readLine();

        int order = Integer.parseInt(br.readLine());

        sb.append(new StringBuilder(N1).reverse());
        sb.append(N2);
        String result = sb.toString();

        for(int t = 0; t < order; t++){
            result = swapIndexes(result, N1SIZE);
        }
        System.out.println(result);
    }
    public static String swapIndexes(String input, int N1SIZE){
        
        char[] chars = input.toCharArray();
        boolean[] swapped = new boolean[chars.length]; // 이번 초에 교환된 개미를 기록

        for (int i = 0; i < chars.length - 1; i++) {
            // N1 그룹의 개미(왼쪽에서 오른쪽 이동)와 N2 그룹의 개미(오른쪽에서 왼쪽 이동)가 만나면 교환
            if (i < N1SIZE && i + 1 >= N1SIZE && !swapped[i] && !swapped[i + 1]) {
                // 개미 교환
                char temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;

                // 교환 처리된 개미 기록
                swapped[i] = true;
                swapped[i + 1] = true;

                // 다음 교환으로 바로 넘어가기 위해 인덱스 이동
                i++;
            }
        }

        return new String(chars);
    }
}
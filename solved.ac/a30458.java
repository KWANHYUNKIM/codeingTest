import java.io.*;

public class a30458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        char[] chars = input.toCharArray();
        int left = 0;
        int right = N - 1;
        int mismatchCount = 0;

        // 양쪽에서 비교
        while (left < right) {
            if (chars[left] != chars[right]) {
                mismatchCount++;
            }
            left++;
            right--;
        }

        // 교환 가능 여부 판단
        if (mismatchCount <= 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

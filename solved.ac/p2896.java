import java.util.Scanner;

public class p2896 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: 구매한 주스 양
        double A = sc.nextDouble(); // 오렌지 주스
        double B = sc.nextDouble(); // 사과 주스
        double C = sc.nextDouble(); // 파인애플 주스

        // 입력: 칵테일 레시피 비율
        double I = sc.nextDouble(); // 오렌지 비율
        double J = sc.nextDouble(); // 사과 비율
        double K = sc.nextDouble(); // 파인애플 비율

        // 최대 배수 계산
        double maxBatch = Math.min(A / I, Math.min(B / J, C / K));

        // 남는 양 계산
        double remainingA = A - (I * maxBatch);
        double remainingB = B - (J * maxBatch);
        double remainingC = C - (K * maxBatch);

        // 정수 또는 소수로 출력
        System.out.println(formatOutput(remainingA) + " " +
                           formatOutput(remainingB) + " " +
                           formatOutput(remainingC));

        sc.close();
    }

    // 출력 포맷: 소수점이 없는 경우 정수, 그렇지 않으면 소수로 표현
    private static String formatOutput(double value) {
        if (value == (int) value) {
            return String.valueOf((int) value); // 정수로 출력
        } else {
            return String.format("%.6f", value); // 소수로 출력
        }
    }
}

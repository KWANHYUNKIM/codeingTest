import java.util.*;

public class a2749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int mod = 1000000;

        // Step 1: Calculate Pisano Period
        int pisanoPeriod = getPisanoPeriod(mod);

        // Step 2: Reduce n using Pisano Period
        int reducedN = (int)(n % pisanoPeriod);

        // Step 3: Compute Fibonacci number modulo mod
        System.out.println(fibModulo(reducedN, mod));
    }

    // Function to compute Pisano Period
    public static int getPisanoPeriod(int mod) {
        int prev = 0;
        int curr = 1;
        for (int i = 0; i < mod * mod; i++) {
            int temp = (prev + curr) % mod;
            prev = curr;
            curr = temp;

            // Pisano Period starts repeating with 0, 1
            if (prev == 0 && curr == 1) {
                return i + 1;
            }
        }
        return 0; // Should never reach here
    }

    // Function to compute Fibonacci number modulo mod
    public static int fibModulo(int n, int mod) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (prev + curr) % mod;
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}

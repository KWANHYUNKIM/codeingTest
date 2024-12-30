import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class p7571 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM", Locale.ENGLISH);
        LocalDate referenceDate = LocalDate.of(2007, Month.AUGUST, 4);

        while (true) {
            String input = sc.nextLine();

            if (input.equals("0 #")) break;

            try {
                // Parse input date
                LocalDate inputDate = LocalDate.parse(input + " 2007", formatter);

                if (inputDate.equals(referenceDate)) {
                    System.out.println("Happy birthday");
                } else if (inputDate.isBefore(referenceDate)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } catch (Exception e) {
                if (input.startsWith("29 February")) {
                    System.out.println("Unlucky");
                }
            }
        }
        sc.close();
    }
}
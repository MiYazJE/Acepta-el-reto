import java.util.Scanner;

public class p626 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int c = s.nextInt();
        s.nextLine();

        while (c-- != 0) {
            String[] parts = s.nextLine().split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            int nextYear = year;
            for (int i = year + 1; i <= year + 5; i++) {
                if (i % 4 == 0) {
                    nextYear = i;
                    break;
                }
            }
            if (month < 2 || (month <= 2 && day < 29)) {
                System.out.printf("%s%04d\n", "29/02/", year % 4 == 0 ? year : nextYear);
            }
            else {
                System.out.printf("%s%04d\n", "29/02/", nextYear);
            }
        }
    }

}

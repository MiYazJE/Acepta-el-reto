import java.util.Scanner;

public class p676 {

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int y1, y2, manyLeapYears;
        int c = s.nextInt();

        while (c-- != 0) {
            y1 = s.nextInt();
            y2 = s.nextInt();
            manyLeapYears = 0;
            for (int i = y1; i <= y2; i++) {
                if (isLeapYear(i)) manyLeapYears++;
            }
            System.out.println((y2 - y1 - manyLeapYears + 1) + " " + manyLeapYears);
        }

    }

}

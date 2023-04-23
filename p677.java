import java.util.Scanner;

public class p677 {

    static int countRepeated(String str, String c) {
        int times = 0;

        for (int i = 0; i < str.length(); i++) {
            if (c.equals(str.charAt(i) + "")) times++;
        }

        return times;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String year;
        int[] digits;
        int ans;

        while (true) {
            year = s.nextLine();
            if (year.equals("0")) break;

            digits = new int[10];

            for (int i = 0; i < 10; i++) {
                digits[i] = s.nextInt();
            }

            ans = Integer.MAX_VALUE;
            for (int i = 0; i < 10; i++) {
                int times = countRepeated(year, i + "");
                if (times > 0) {
                    digits[i] /= times;
                    ans = Math.min(ans, digits[i]);
                }
            }

            System.out.println(ans == Integer.MAX_VALUE ? 0 : ans / 3);
            s.nextLine();
        }

    }

}

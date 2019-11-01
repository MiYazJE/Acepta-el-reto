import java.util.Scanner;

public class p174 {

    static boolean getState(String n) {
        for (int i = 0; i < n.length() - 1; i++) {
            for (int j = i + 1; j < n.length(); j++) {
                if (n.charAt(i) == n.charAt(j)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int num, temp_num;
        int casos = s.nextInt();
        boolean repetido, temp;
        int left, right;

        while (casos-- != 0) {

            num = s.nextInt();

            repetido = getState(String.valueOf(num));

            temp = repetido;
            temp_num = num;

            left = 0;
            while (temp == repetido) {
                temp = getState(String.valueOf(temp_num));
                if (temp == repetido) {
                    temp_num--;
                    left++;
                }
            }

            left--;
            temp_num = num;
            temp = repetido;

            right = 0;
            while (temp == repetido) {
                temp = getState(String.valueOf(temp_num));
                if (temp == repetido) {
                    temp_num++;
                    right++;
                }
            }

            System.out.println((num - left) + " " + (left + right));
        }

    }

}

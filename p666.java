import java.util.Arrays;
import java.util.Scanner;

public class p666 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        char[] str1, str2;
        int C = s.nextInt();
        s.nextLine();

        while (C-- != 0) {

            str1 = s.nextLine()
                    .toLowerCase()
                    .replaceAll("[^A-Z a-z]", "")
                    .replaceAll("\\s", "")
                    .toCharArray();
            str2 = s.nextLine()
                    .toLowerCase()
                    .replaceAll("[^A-Z a-z]", "")
                    .replaceAll("\\s", "")
                    .toCharArray();

            Arrays.sort(str1);
            Arrays.sort(str2);

            System.out.println(new String(str1).equals(new String(str2)) ? "SI" : "NO");
        }

    }

}

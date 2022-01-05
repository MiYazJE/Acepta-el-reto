import java.util.Arrays;
import java.util.Scanner;

public class p623 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int c = s.nextInt();

        while (c-- != 0) {
            String strLeft = s.next();
            String strRight = s.next();
            char[] left = strLeft.toCharArray();
            char[] right = strRight.toCharArray();
            Arrays.sort(left);
            Arrays.sort(right);
            System.out.println(String.valueOf(left).equals(String.valueOf(right)) ? "GANA" : "PIERDE");
        }

    }

}

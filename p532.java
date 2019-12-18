import java.util.*;

/**
 * @author Rubén Saiz
 * 18/12/2019
 */

public class p532 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n1, n2;
        int casos = s.nextInt();

        while (casos-- != 0) {
            n1 = s.nextInt();
            n2 = s.nextInt();
            System.out.println(Math.abs(n1 - n2));
        }


    }

}

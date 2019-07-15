import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p269 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        int num, distancia, sum;

        for (int i = 0; i < casos; i++) {

            num = s.nextInt();
            distancia = num;
            sum = num;
            while (num != 0) {
                num = s.nextInt();
                if (num != 0) {
                    sum += num;
                    distancia += sum;
                }
            }

            System.out.println( distancia * 2 );
        }

    }

}

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Rubén Saiz
 */

public class p209 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int consultas, n;
        String tunel;
        TreeSet<Integer> telefonos = new TreeSet<>();

        while (s.hasNext()) {

            tunel = s.nextLine();

            for (int i = 0; i < tunel.length(); i++)
                if (tunel.charAt(i) == 'T') telefonos.add(i + 1);

            consultas = s.nextInt();
            for (int i = 0; i < consultas; i++) {
                n = s.nextInt();
                if (telefonos.contains(n)) {
                    System.out.println("AQUI");
                }
                else {

                    Integer leftCost = telefonos.lower(n);
                    if (leftCost == null) leftCost = n;
                    else leftCost = n - leftCost;

                    Integer rightCost = telefonos.higher(n);
                    if (rightCost == null) rightCost = tunel.length() - n + 1;
                    else rightCost -= n;

                    if (leftCost < rightCost) System.out.println("PENINSULA");
                    else if (rightCost < leftCost) System.out.println("ISLAS");
                    else {
                        int right = tunel.length() - n + 1;
                        if (n <= right) System.out.println("PENINSULA");
                        else System.out.println("ISLAS");
                    }

                }
            }

            if (s.hasNext()) s.nextLine();
            telefonos.clear();
        }

    }

}

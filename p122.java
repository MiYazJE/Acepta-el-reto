import java.util.Scanner;

public class p122 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n1, n2, pos, kl, tempKl, tempPlanas, planas;
        boolean comen, first;

        while (true) {

            comen = first = false;
            pos = kl = planas = tempKl = 0;
            tempPlanas = -1;

            n1 = s.nextInt();
            if (n1 == -1) break;

            while (true) {
                n2 = s.nextInt();
                if (n2 == -1) break;
                if (n1 == n2) {
                    comen = true;
                    if (!first) {
                        tempPlanas = 0;
                        first = true;
                        tempKl = pos;
                    }
                    tempPlanas++;
                    if (tempPlanas > planas) {
                        planas = tempPlanas;
                        kl = tempKl;
                    }
                }
                else first = false;
                n1 = n2;
                pos++;
            }

            if (!comen) System.out.println("HOY NO COMEN");
            else System.out.println(kl + " " + planas);
        }

    }

}

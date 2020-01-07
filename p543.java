import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

class Sombrilla {
    double n1, n2, r;
    Sombrilla(int n1, int n2, int r) {
        this.n1 = n1;
        this.n2 = n2;
        this.r = r;
    }
}

public class p543 {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        ArrayList<Sombrilla> sombrillas = new ArrayList<>();

        while(casos-- != 0) {
            for (int i = s.nextInt(); i > 0; i--) {
                sombrillas.add(new Sombrilla(s.nextInt(), s.nextInt(), s.nextInt()));
            }
            int res = 0;
            for (int i = 0; i < sombrillas.size(); i++) {
                Sombrilla s1 = sombrillas.get(i);
                for (int j = i + 1; j < sombrillas.size(); j++) {
                    Sombrilla s2 = sombrillas.get(j);
                    double distance = Math.sqrt(
                            ((s1.n1 - s2.n1) * (s1.n1 - s2.n1)) + ((s1.n2 - s2.n2) * (s1.n2 - s2.n2))
                    );
                    if (distance < s1.r + s2.r) res++;
                }
            }
            System.out.println( res );
            sombrillas.clear();
        }

    }

}

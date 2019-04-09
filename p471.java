import java.util.*;

public class p471 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos = s.nextInt();
        int pI, pF;

        for (int i = 0; i < casos; i++) {

            pI = s.nextInt();            
            pF = s.nextInt();            

            int dif1 = Math.abs(pI - pF) + (360 - pF);
            int dif2 = (360 - pF) + pI;

            if (dif1 == dif2) {
                System.out.println("DA IGUAL");
            }

            if (dif1 > dif2) {
                System.out.println("ASCENDENTE");
            }
            else {
                System.out.println("DESCENDENTE");
            }

        }

    }


}

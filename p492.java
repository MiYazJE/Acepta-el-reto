import java.util.*;

public class p492 { 

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int numMarta;
        int numDaniel;
        int numPadre;
        int veces;
        int num;

        while (true) {

            numMarta  = s.nextInt();
            numDaniel = s.nextInt();
            numPadre  = s.nextInt();

            if (numMarta == 0 && numDaniel == 0 && numPadre == 0) break;
            veces = 0;

            num = Math.max(numMarta, numDaniel);

            for (int i = num; i <= numPadre; i+=num) {
                if (i % numMarta == 0 && i % numDaniel == 0) { 
                    veces = numPadre / i;
                    break;
                }                
            }

            System.out.println(veces);  
        }

    }

}

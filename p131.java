import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p131 {

    private static int getViajes(int piscina, int barreno, int pierde) {
        if (pierde >= barreno && barreno < piscina) return Integer.MAX_VALUE;
        else if (barreno >= piscina) return 1;
        int viajes = 0, aux, rest;
        while (piscina > 1) {
            aux = piscina / barreno;
            rest = aux * pierde;
            piscina = (piscina - (aux * barreno)) + rest;
            viajes += aux;
            if (piscina != 0 && piscina <= barreno) {
                viajes++; break;
            }
        }
        return viajes;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int pisA, barrA, piA, pisB, barrB, piB;
        int yo, vecino;

        while (true) {

            pisA  = s.nextInt();
            barrA = s.nextInt();
            piA   = s.nextInt();
            pisB  = s.nextInt();
            barrB = s.nextInt();
            piB   = s.nextInt();

            if (pisA == 0 || pisB == 0) break;

            yo     = getViajes(pisA, barrA, piA);
            vecino = getViajes(pisB, barrB, piB);

            /*if (yo == -1 && vecino == -1) {
                yo = 0;
                vecino = 0;
            }*/

            if (yo == vecino) System.out.println("EMPATE " + yo);
            else if (yo < vecino) System.out.println("YO " + yo);
            else System.out.println("VECINO " + vecino);
        }

    }

}

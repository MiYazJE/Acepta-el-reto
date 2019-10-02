import java.util.ArrayList;
import java.util.Scanner;

class Arma {
    int dVillano;
    int dInocente;
    int pos;
    Arma(int x, int y, int j) {
        dInocente = x;
        dVillano  = y;
        pos       = j;
    }
}

public class p477 {

    static Arma getArma(ArrayList<Arma> armas) {
        Arma res = armas.get(0);
        for (int i = 1; i < armas.size(); i++)
            if (armas.get(i).dInocente < res.dInocente)
                res = armas.get(i);
        return getMax(armas, res);
    }

    static Arma getMax(ArrayList<Arma> armas, Arma actual) {
        for (int i = 0; i < armas.size(); i++) {
            Arma posible = armas.get(i);
            if (posible.dInocente == actual.dInocente &&
                posible.dVillano > actual.dVillano) {
                actual = posible;
            }
        }
        return actual;
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int vida, numArmas;
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Integer> sucesion = new ArrayList<>();
        boolean muerto;

        while (true) {

            vida = s.nextInt();
            if (vida == 0) break;

            numArmas = s.nextInt();
            for (int i = 1; i <= numArmas; i++)
                armas.add(new Arma(s.nextInt(), s.nextInt(), i));

            muerto = false;
            while (!armas.isEmpty() && vida > 0) {
                Arma arma = getArma(armas);
                vida -= arma.dVillano;
                sucesion.add(arma.pos);
                armas.remove(arma);
                muerto = (vida <= 0);
            }

            if (muerto) {
                for (int i = 0; i < sucesion.size(); i++) {
                    System.out.print(sucesion.get(i));
                    if (i < sucesion.size() - 1) System.out.print(" ");
                    else System.out.println();
                }
            }
            else {
                System.out.println("MUERTE ESCAPA");
            }

            sucesion.clear();
            armas.clear();
        }

    }

}

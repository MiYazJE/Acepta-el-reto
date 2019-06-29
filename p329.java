import java.util.*;

class Casa implements Comparable<Casa> {

    int ini;
    int fin;

    public Casa(int ini, int fin) {
        this.ini = ini;
        this.fin = fin;
    }

    @Override
    public int compareTo(Casa o) {
        if (this.fin < o.fin) return -1;
        else if (this.fin > o.fin) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format(this.ini + " " + this.fin);
    }
}

public class p329 {

    public static void imprimir(Casa[] casas) {
        for (Casa casa : casas) {
            System.out.println(casa);
        }
    }
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int casos, tuneles, limite;
        Casa[] casas;

        while (true) {

            casos = s.nextInt();
            if (casos == 0) break;
            casas = new Casa[casos];

            for (int i = 0; i < casos; i++)
                casas[i] = new Casa(s.nextInt(), s.nextInt());
            Arrays.sort( casas );

            tuneles = 0;
            limite  = -1;
            for (Casa casa : casas) {
                if (casa.ini >= limite) {
                    tuneles++;
                    limite = casa.fin;
                }
            }

            System.out.println( tuneles );
        }

    }

}

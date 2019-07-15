import java.util.Scanner;

public class p494 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int tamSerie;
        int[] serie;
        int actualNum, ultimoNum;
        int posActual, backup;
        int i;

        while (true) {

            tamSerie = s.nextInt();
            if (tamSerie == 0) return;
            serie = new int[tamSerie-1];

            posActual = 0;
            backup = 0;
            ultimoNum = s.nextInt();
            for (i = 0; i < tamSerie-1; i++) {
                actualNum = s.nextInt();
                serie[i] = actualNum-ultimoNum;
                ultimoNum = actualNum;
            }

            // System.out.println(Arrays.toString(serie));

            for (i = 0; i < tamSerie-1; i++) {
                if (i != 0 && serie[i] == serie[posActual]) {
                    posActual++;
                } else {
                    posActual = 0;
                    i = backup;
                    backup++;
                }
            }

            System.out.println( ultimoNum + serie[posActual] );
        }

    }

}

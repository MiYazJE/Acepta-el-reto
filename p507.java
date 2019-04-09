import java.util.*;

public class p507 { 


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int integrantes, i, numPersonas;
        long pesoMax, parejas, peso, pesoTandem;
        int ini, fin;
        long[] personas;

        while (true) {

            integrantes = s.nextInt();
            pesoMax     = s.nextLong();
            if (integrantes == 0 && pesoMax == 0) break;

            personas = new long[integrantes];
            numPersonas = 0;
            
            for (i = 0; i < integrantes; i++) {
                peso = s.nextLong();
                if (peso <= pesoMax) {
                    personas[numPersonas] = peso;
                    numPersonas++;                 
                }
            }
            
            Arrays.sort(personas, 0, numPersonas);
            
            parejas = 0;
            ini = 0;
            fin = numPersonas - 1;

            while (ini < fin) {
                pesoTandem = personas[ini] + personas[fin];
                if (pesoTandem > pesoMax) {
                    fin--;
                }
                else {
                    parejas += fin - ini;
                    ini++;
                }
            }

            System.out.println( parejas );
        }

    }

}

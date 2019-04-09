import java.util.*;

public class p478 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int nHechizos;
        long[] hechizos;
        int pDer;
        int pIzq;
        long suma, target, sum, danyo;
        boolean found;
        
        while (true) {

        	nHechizos = s.nextInt();
        	if (nHechizos == 0) break;
        	
            hechizos = new long[nHechizos];
            suma = 0L;

            for (int i = 0; i < nHechizos; i++) {
                hechizos[i] = s.nextLong(); 
                suma += hechizos[i];
            }
            danyo = s.nextLong();

            pIzq = 0;
            pDer = nHechizos-1;
            found = false;
            target = suma - danyo;
            
            while (!found) {

            	sum = hechizos[pIzq] + hechizos[pDer];
            	if (sum == target) found = true;
            	else if (sum > target) {
                    pDer--;
                }
                else {
                    pIzq++;
                }

            }

            System.out.print(hechizos[pIzq] + " " + hechizos[pDer] + "\n");
        }

    }

}
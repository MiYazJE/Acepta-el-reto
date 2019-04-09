package aceptaElReto;

import java.util.*;

public class p493 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int c, nPiezas;
        int pieza, rotacion, pos, max;
        int[] tablero;

        while (true) {

            c = s.nextInt();
            nPiezas = s.nextInt();
            if (c == 0 && nPiezas == 0) break;

            tablero = new int[c];
            for (int i = 0; i < nPiezas; i++) {

                pieza    = s.nextInt();
                rotacion = s.nextInt();
                pos      = s.nextInt();

                switch (pieza) {

                    case 1: 

                        if (rotacion == 0 || rotacion == 180) {
                            max = Collections.max(Arrays.asList(tablero[pos-1], tablero[pos], tablero[pos+1]));
                            tablero[pos-1] += (max - tablero[pos-1]) + 1;
                            tablero[pos]   += (max - tablero[pos]) + 1;
                            tablero[pos+1] += (max - tablero[pos+1]) + 1;
                        }
                        else if (rotacion == 90 || rotacion == 270) {
                            tablero[pos-1] += 3;
                        }


                    break;

                    case 2: 

                        if (rotacion == 0) {
                        	max = Collections.max(Arrays.asList(tablero[pos-1], tablero[pos], tablero[pos+1]));
                        	tablero[pos-1] += (max - tablero[pos-1]) + 2;
                        	tablero[pos]   += (max - tablero[pos])   + 1;
                        	tablero[pos+1] += (max - tablero[pos+1]) + 1;
                        }
                        else if (rotacion == 90) {
                        	max = Math.max(tablero[pos-1], tablero[pos]);
                        	tablero[pos-1] += (max - tablero[pos-1]) + 1;
                        	tablero[pos]   += (max - tablero[pos])   + 3;
                        }
                        else if (rotacion == 180) {
                    		max = Collections.max(Arrays.asList(tablero[pos-1], tablero[pos], tablero[pos+1]));
                    		tablero[pos+1] += (max - tablero[pos+1]) + 1;
                    		tablero[pos-1] = tablero[pos+1];
                        	tablero[pos]   = tablero[pos+1];
                        }
                        else if (rotacion == 270) {
                        	max = Math.max(tablero[pos-1], tablero[pos]);
                        	tablero[pos]   += (max - tablero[pos]) + 3;
                        	tablero[pos-1] = tablero[pos];
                        }

                    break;

                    case 3: 

                        if (rotacion == 0) {
                        	max = Collections.max(Arrays.asList(tablero[pos-1], tablero[pos], tablero[pos+1]));
                        	tablero[pos-1] += (max - tablero[pos-1]) + 1;
                        	tablero[pos]   += (max - tablero[pos])   + 1;
                        	tablero[pos+1] += (max - tablero[pos+1]) + 2;
                        }
                        else if (rotacion == 90) {
                        	max = Math.max(tablero[pos-1], tablero[pos]);
                        	tablero[pos]  += (max - tablero[pos]) + 3;
                        	tablero[pos-1] = tablero[pos];
                        }
                        else if (rotacion == 180) {
                        	max = Collections.max(Arrays.asList(tablero[pos-1], tablero[pos], tablero[pos+1]));
                        	tablero[pos+1] += (max - tablero[pos+1]) + 1;
                    		tablero[pos-1] = tablero[pos+1];
                        	tablero[pos]   = tablero[pos+1];
                        }
                        else if (rotacion == 270) {
                        	max = Math.max(tablero[pos-1], tablero[pos]);
                        	tablero[pos-1] += (max - tablero[pos-1]) + 3;
                        	tablero[pos]   += (max - tablero[pos])   + 1;
                        }

                    break;

                    case 4: 

                        max = Math.max(tablero[pos-1], tablero[pos]);
                        tablero[pos-1] += (max - tablero[pos-1]) + 2;
                        tablero[pos]   += (max - tablero[pos]) + 2;

                    break;

                    case 5: 

                        if (rotacion == 0) {
                        	max = Collections.max(Arrays.asList(tablero[pos-1], tablero[pos], tablero[pos+1]));
                        	if (tablero[pos-1] < max && tablero[pos] < max && tablero[pos+1] == max) {
                        		tablero[pos+1] += (max - tablero[pos-1]) + 2;
                        	}
                        	else {
                        		tablero[pos+1] += (max - tablero[pos-1]) + 1;
                        	}
                        	tablero[pos]   = tablero[pos+1];
                        	tablero[pos-1] = tablero[pos+1] - 1;
                        }
                        else if (rotacion == 90) {
                            
                        }
                        else if (rotacion == 180) {

                        }
                        else {

                        }

                    break;

                    case 6: 

                        if (rotacion == 0) {

                        }
                        else if (rotacion == 90) {
                            
                        }
                        else if (rotacion == 180) {

                        }
                        else {

                        }

                    break;

                    case 7: 

                        if (rotacion == 0) {

                        }
                        else if (rotacion == 90) {
                            
                        }
                        else if (rotacion == 180) {

                        }
                        else {

                        }

                    break;

                }

                
            }
            
            int len = tablero.length;
            for (int j = 0; j < len; j++) {
                if (j + 1 != len) System.out.print(tablero[j] + " ");
                else System.out.println(tablero[j]);
            }
        }

    }

}

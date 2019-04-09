import java.util.*;

public class p465 {

    public static int getCurvas(int[][] m, int f, int c) {

        int curvas = 0;

        validos[f][c] = true;
        
        if (valido(m, f-1, c)) {
            curvas += getCurvas(m, f-1, c); // arriba
            if (abajo(m, f+1, c)) curvas++;
        }
        else if (valido(m, f, c+1)) {
            curvas += getCurvas(m, f, c+1); // derecha
            if (izq(m, f, c-1)) curvas++;
        }
        else if (valido(m, f, c-1)) {
            curvas += getCurvas(m, f, c-1); // izquerda
            if (der(m, f, c+1)) curvas++;
        }
        else if (valido(m, f+1, c)) {
            curvas += getCurvas(m, f+1, c); // abajo
            if (arriba(m, f-1, c)) curvas++;
        }
        	
        return curvas;
    }

    public static boolean abajo(int[][] m, int f, int c) {
    	return (f >= m.length || (secure(m, f, c) && m[f][c] == 1));
    }
    
    public static boolean der(int[][] m, int f, int c) {
    	return (c >= m[0].length || (secure(m, f, c) && m[f][c] == 1));
    }
    
    public static boolean izq(int[][] m, int f, int c) {
    	return (c < 0 || (secure(m, f, c) && m[f][c] == 1));
    }
    
    public static boolean arriba(int[][] m, int f, int c) {
    	return (f < 0 || (secure(m, f, c) && m[f][c] == 1));
    }
    
    public static boolean secure(int[][] m, int f, int c) {
    	return ((f >=0 && f < m.length) && (c >= 0 && c < m[0].length));
    }
    
    public static boolean valido(int[][] m, int f, int c) {
        if ((f >= 0 && f < m.length) && (c >= 0 && c < m[0].length)) {
            if (m[f][c] == 0 && !validos[f][c]) {
                return true;
            }
        }
        return false;
    }

    // public static void imprimir(int[][] m) {
    // 	for (int i = 0; i < m.length; i++) {
	// 		for (int j = 0; j < m[0].length; j++) {
	// 			if (m[i][j] == 0) {
	// 				System.out.print("# ");
	// 			} else if (m[i][j] == 1) {
	// 				System.out.print("* ");
	// 			}
	// 		}
	// 		System.out.println("");
	// 	}
    // }
    
    public static boolean[][] validos;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int f, c;
        int[][] m;
        String linea;
        int x = 0, y = 0;
        int curvas;
        int izq;
        int der;

        while (s.hasNext()) {

        	c = s.nextInt();
            f = s.nextInt();
            s.nextLine();
            m = new int[f][c];
            validos = new boolean[f][c];
            curvas = 0; izq = 0; der = 0;

            for (int i = 0; i < f; i++) {
                linea = s.next();
                for (int j = 0; j < c; j++) {
                    if (linea.charAt(j) == 'O') {
                        x = i;
                        y = j;
                    }
                    if (linea.charAt(j) == '.') {
                    	m[i][j] = 1;
                    }
                }
            }
            
            curvas = getCurvas(m, x, y);
            curvas++;

            if (curvas > 4) {
            	izq = curvas / 2 - 2;
            	der = curvas / 2 + 2;
            }
            else {
            	der = curvas;
            }
            
            System.out.println(izq + " " + der);
        }

    }

}
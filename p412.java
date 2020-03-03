import java.util.*;

public class p412 {
	
	public static void pintar(char[][] m, int posX, int posY) {
		
		if (valido(posX, posY, m)) {
			
			if (posX == m.length-1 && posY == m[0].length-1) {
				validos[posX][posY] = true;
			}
			else {
				validos[posX][posY] = true;
				pintar(m, posX+1, posY); // abajo
				pintar(m, posX, posY+1); // derecha
				pintar(m, posX, posY-1); // izquierda
				pintar(m, posX-1, posY); // arriba
			}
			
        }
        
	}
	
	public static boolean valido(int posX, int posY, char[][] m) {
		
		boolean valido = false;
		
		if ((posX >= 0 && posX <= m.length-1) && (posY >= 0 && posY <= m[0].length-1)) {
			if (m[posX][posY] != 'X' && !validos[posX][posY]) {
				valido = true;
			}
		}
		
		return valido;
	}
    
    public static boolean ovejaBlanca(char[][] m) {
		for (int i = 0; i < validos.length; i++) {
			for (int j = 0; j < validos[0].length; j++) {
                if (!validos[i][j]) {
					if (m[i][j] == '.') {
						return true;
					}
				}
			}
        }
        return false;
	}
	
	public static boolean[][] validos;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int f, c;
		char[][] m;
		String linea;
		
		while (s.hasNext()) {

            c = s.nextInt();
			f = s.nextInt();
			m = new char[f][c];
			validos = new boolean[f][c];

            for (int i = 0; i < f; i++) {
                linea = s.next();
                for (int j = 0; j < c; j++) {
                    m[i][j] = linea.charAt(j);
                }
            }
            
            pintar(m, 0, 0);
            
			System.out.println((ovejaBlanca(m) ? "SI" : "NO"));
		}
		
	}

}

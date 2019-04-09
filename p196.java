import java.util.*;

public class p196 {

    public static void transponerMatriz(int[][] matriz, int[][] transpuesta){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				transpuesta[8-i][8-j] = matriz[i][j]; 
			}
		}
    }
    
    public static boolean test(int[][] m, int[][] ref) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (m[i][j] != ref[i][j]) return false;
            }
        }
        return true;
    } 
    
    public static void imprimir(int[][] m) {
    	System.out.println();
    	for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");
		}
    	System.out.println();
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int[][] m;
        int[][] mT;
        int nNum;
        String linea;
        int casos = s.nextInt();
        s.nextLine();

        for (int k = 0; k < casos; k++) {

            m   = new int[9][9];
            mT  = new int[9][9];
            s.nextLine();

            nNum = 0;
            for (int i = 0; i < 9; i++) {
                linea = s.nextLine();
                for (int j = 0; j < 9; j++) {
                    if (linea.charAt(j) >= 48 && linea.charAt(j) <= 57) {
                        m[i][j] = 1;
                        nNum++;
                    }
                }
            }

            if (nNum <= 32) {
                transponerMatriz(m, mT);
                
                System.out.println((test(m, mT) ? "SI" : "NO"));
            }
            else {
                System.out.println("NO");
            }

        }

    }

}

package aceptaElReto;

import java.util.Scanner;

public class p459 {

	public static int moverme(int f, int c, int[][] pueblo) {
        
        int veces = 0;
        
        if (f-1 >= 0 && f-1 < pueblo.length && c >= 0 && c < pueblo[0].length)
        	if (pueblo[f-1][c] == 1) 
        		veces++;
        
        if (f >= 0 && f < pueblo.length && c+1 >= 0 && c+1 < pueblo[0].length)
        	if (pueblo[f][c+1] == 1) 
        		veces++;
        
        if (f+1 >= 0 && f+1 < pueblo.length && c >= 0 && c < pueblo[0].length)
        	if (pueblo[f+1][c] == 1) 
        		veces++;
        
        if (f >= 0 && f < pueblo.length && c-1 >= 0 && c-1 < pueblo[0].length)
        	if (pueblo[f][c-1] == 1) 
        		veces++;

        return (veces > 2) ? veces : 0;
        
    }
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int f, c, semaforos;
		String linea;
		int[][] pueblo;
		
		while (s.hasNext()) {
			
			c = s.nextInt();
            f = s.nextInt();
            s.nextLine();
            
            pueblo = new int[f][c];

           for (int i = 0; i < f; i++) {
               linea = s.nextLine();
               for (int j = 0; j < c; j++) {
                    if (linea.charAt(j) == '#') {
                        pueblo[i][j] = 1;
                    }
               }
           }
			
           semaforos = 0;
           for (int i = 0; i < f; i++) {
               for (int j = 0; j < c; j++) {
                    if (pueblo[i][j] == 1) {
                    	semaforos += moverme(i, j, pueblo);
                    }
               }
           }
			
           System.out.println( semaforos );
		}	
		
	}
	
}

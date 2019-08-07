package aceptaElReto;

import java.util.*;

public class p514 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int[] paro;
		int[] meses;
		int n, j;
		
		while (true) {
			
			n = s.nextInt();
			if (n == 0) break;
			
			paro = new int[n];
			meses = new int[n];
			
			for (int i = 0; i < n; i++) {
				
				paro[i] = s.nextInt();
				
				j = i - 1;
				
				while (j >= 0 && paro[i] < paro[j]) {
					meses[i] += meses[j] + 1;
					j -= (meses[j] + 1);
				}
				
			}
			
			for (int i = 0; i < n; i++) {
				System.out.print(meses[i]);
				if (i + 1 != n) System.out.print(" ");
			}
			
			System.out.println("");
		}
		
	}
	
}

import java.util.Scanner;

public class p367 {


	public static int[] ordenarVector(int[] V) {

		int aux = 0;

		for (int i=0; i<V.length-1; i++) {
		   for (int j=i+1; j<V.length; j++) {
		    
		    if(V[i]>V[j]) {

			    aux = V[i];
			    V[i] = V[j];
			    V[j] = aux;

		    }

		  }
		}

		return V;

	}


	public static int devolverPortal(int[] numeroPortales, int aterrizaje) {

		int[] posiciones = new int[numeroPortales.length];
		int[] semejantes = new int[2];
		boolean igual    = false;
		int menor  = Integer.MAX_VALUE;
		int portal = 0;
		
		for (int i = 0; i < numeroPortales.length; i++) {

			if (numeroPortales[i] == 0) continue;
			
			posiciones[i] = Math.abs(aterrizaje - numeroPortales[i]);

			if (posiciones[i] < menor) {
				menor  = posiciones[i];
				portal = i; 
			}

			for (int j = 0; j < posiciones.length; j++) {
				if (posiciones[i] == posiciones[j] && posiciones[i] == menor && i != j && posiciones[i] != 0) {
					semejantes[0] = i;
					semejantes[1] = j;
					igual = true;
					break;
				}
			}
			
		}
				
		if (igual) {
			if (numeroPortales[semejantes[0]] > numeroPortales[semejantes[1]]) {
				portal = semejantes[0];
			} 
			else {
				portal = semejantes[1];
			}
		}

		return portal;

	} 



	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		int aterrizaje;
		int portales;
		int[] numeroPortales;
		int portal;
		boolean mayor;
		boolean menor;

		for (int i = 0; i < casos; i++) {

			aterrizaje = s.nextInt();
			portales   = s.nextInt();

			numeroPortales = new int[portales];

			menor = true;
			mayor = true;

			for (int j = 0; j < portales; j++) {

				numeroPortales[j] = s.nextInt();

				if (numeroPortales[j] < aterrizaje) menor = false;
				if (numeroPortales[j] > aterrizaje) mayor = false;

			}

			numeroPortales = ordenarVector(numeroPortales);

			if (menor) {
				for (int j = 0; j < numeroPortales.length; j++) {

					if (j != numeroPortales.length-1) {
						System.out.print(numeroPortales[j] + " ");
					}
					else {
						System.out.println(numeroPortales[j]);
					}

				}

			}
			else if (mayor) {
				for (int j = numeroPortales.length; j > 0; j--) {

					if (j != 1) {
						System.out.print(numeroPortales[j-1] + " ");
					}
					else {
						System.out.println(numeroPortales[j-1]);
					}

				} 
			}
			else {

				for (int j = 0; j < numeroPortales.length; j++) {

					portal = numeroPortales[devolverPortal(numeroPortales, aterrizaje)];
					System.out.print(portal);
					
					if (j != numeroPortales.length-1) {
						System.out.print(" ");

						for (int k = 0; k < numeroPortales.length; k++) {
							if (numeroPortales[k] == portal) {
								numeroPortales[k] = 0;
								break;
							}
						}

						aterrizaje = portal;

					} else {
						System.out.println("");
					}
					
				}

			}

		}


	}

}
import java.util.Scanner;

public class p476 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos;
		int[] heroes;
		int numeroI;
		int numeroJ;
		String[] preferencias;
		boolean igual, menor, mayor, hay;
		
		while (true) {

			casos = s.nextInt();

			if (casos == 0) break;

			heroes       = new int[casos];
			preferencias = new String[casos];


			for (int i = 0; i < casos; i++) heroes[i] = s.nextInt();
			for (int i = 0; i < casos; i++) preferencias[i] = s.next();

			hay = false;

			for (int i = 0; i < casos; i++) {	

				if (heroes[i] == -1) continue;

				mayor = false;
				menor = false;
				igual = false;

				if (preferencias[i].charAt(0) == '<') menor = true;
				if (preferencias[i].charAt(0) == '>') mayor = true;
				if (preferencias[i].charAt(0) == '=') igual = true;

				for (int j = i+1; j < casos; j++) {

					if (heroes[j] == -1) continue;

					numeroI = Integer.parseInt(preferencias[i].substring(1, preferencias[i].length()));
					numeroJ = Integer.parseInt(preferencias[j].substring(1, preferencias[j].length()));

					if (menor) {
						if (heroes[j] < numeroI) {

							if (preferencias[j].charAt(0) == '>') {
								if (heroes[i] > numeroJ) {
									System.out.println((i+1) + " " + (j+1));  
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							} 
							else if (preferencias[j].charAt(0) == '<') {
								if (heroes[i] < numeroJ) {
									System.out.println((i+1) + " " + (j+1));  
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							} 
							else {
								if (heroes[i] == numeroJ) {
									System.out.println((i+1) + " " + (j+1)); 
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							}
							
						}


					}
					else if (mayor) {

						if (heroes[j] > numeroI) {

							if (preferencias[j].charAt(0) == '>') {
								if (heroes[i] > numeroJ) {
									System.out.println((i+1) + " " + (j+1));  
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							} 
							else if (preferencias[j].charAt(0) == '<') {
								if (heroes[i] < numeroJ) {
									System.out.println((i+1) + " " + (j+1));  
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							} 
							else {
								if (heroes[i] == numeroJ) {
									System.out.println((i+1) + " " + (j+1));
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							}

						}

					}
					else if (igual) {

						if (heroes[j] == numeroI) {

							if (preferencias[j].charAt(0) == '>') {
								if (heroes[i] > numeroJ) {
									System.out.println((i+1) + " " + (j+1));  
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							} 
							else if (preferencias[j].charAt(0) == '<') {
								if (heroes[i] < numeroJ) {
									System.out.println((i+1) + " " + (j+1));  
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							} 
							else {
								if (heroes[i] == numeroJ) {
									System.out.println((i+1) + " " + (j+1));  
									hay = true;
									heroes[i] = -1;
									heroes[j] = -1;
									break;
								}
							}

						}

					}

				}
			}

			if (hay == false) {
				System.out.println("NO HAY");
			}

			System.out.println("---");
		}

	}

}

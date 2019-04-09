public class p263 {
	static java.util.Scanner s;

	public static String[][] rellenarMatriz(int n, String[][] matriz) {

		String total;
		
		for(int i = 0; i < n; i++) {
			total = s.next();
			for(int j = 0; j < n; j++) {
				
				matriz[i][j] = ("" + total.charAt(j));

			}
		}

		return matriz;

	}


	public static String[][] desplazar(String[][] matriz) {

		String CF = s.next();
		int fc;

		while(!CF.equals("x")) {

			if(CF.equals("f")) {

				fc = s.nextInt();

				matriz = desplazarFila( matriz, fc );

			} else {

				fc = s.nextInt();

				matriz = desplazarColumna( matriz, fc );

			}

			CF = s.next();

		}

		return matriz;

	}


	public static String[][] desplazarFila(String[][] matriz, int valor) {

		String aux;

		if(valor > 0) {

			aux = matriz[valor-1][matriz.length-1];
			for(int j = matriz.length-1; j > 0; j--) {

				matriz[valor-1][j] = matriz[valor-1][j-1];

			}
			matriz[valor-1][0] = aux;

		} else {

			valor *= -1;

			aux = matriz[valor-1][0];
			for(int j = 0; j < matriz.length-1; j++) {

				matriz[valor-1][j] = matriz[valor-1][j+1];

			}
			matriz[valor-1][matriz.length-1] = aux;

		}

		return matriz;

	}


	public static String[][] desplazarColumna(String[][] matriz, int valor) {

		String aux;

		if(valor > 0) {

			aux = matriz[matriz.length-1][valor-1];
			for(int j = matriz.length-1; j > 0; j--) {

				matriz[j][valor-1] = matriz[j-1][valor-1];

			}
			matriz[0][valor-1] = aux;

		} else {

			valor *= -1;

			aux = matriz[0][valor-1];
			for(int j = 0; j < matriz.length-1; j++) {

				matriz[j][valor-1] = matriz[j+1][valor-1];

			}
			matriz[matriz.length-1][valor-1] = aux;

		}

		return matriz;

	}




	public static void imprimir(String[][] matriz) {

		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
  
				System.out.print(matriz[i][j]);

			}
			System.out.println();
		}

		System.out.println("---");

	}



	public static void main(String[] args) {

		s = new java.util.Scanner(System.in);

		int tamano = s.nextInt();
		String[][] matriz;

		while(tamano != 0) {

			matriz = new String[tamano][tamano];
			matriz = rellenarMatriz( tamano, matriz);
			matriz = desplazar( matriz );

			imprimir( matriz );

			tamano = s.nextInt();

		}




	}

}

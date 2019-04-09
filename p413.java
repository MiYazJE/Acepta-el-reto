import java.util.Scanner;

public class p413 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos;
		int filas;
		int columnas;
		int blancas = 0;
		int negras = 0;
		double cantidad = 0;
		double total;


		casos = s.nextInt();

		for(int i=0; i<casos; i++) {

			filas = s.nextInt();
			columnas = s.nextInt();

			total = (double)filas * columnas;
			cantidad = (double)total / 2;

			blancas = (int)cantidad;
			negras = (int)cantidad;

			if(filas == 1 && columnas == 1) {

				blancas = 1;
				negras = 0;

			} else if(total %2 != 0 ) {

				blancas = (int)cantidad + 1;

 			}

			System.out.print(blancas + " " + negras);
			System.out.println();

		}


	}

}
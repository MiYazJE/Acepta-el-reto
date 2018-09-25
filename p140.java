import java.util.Scanner;

public class p140 {
	

	public static void main(String[] args){

		Scanner s = new Scanner(System.in);

		int numero;
		int aux;
		int digito = 0;
		int suma = 0;
		int div;

		do {

			numero = s.nextInt();
			aux = numero;
			suma = 0;
			div = 1000000000;

			if (numero > 0 && numero < 1000000000) {
				
				do {

					do {

						digito = aux / div;

						if(digito == 0){
							div /= 10;
						} else {
							aux %= div;
						}

					} while(digito == 0);
					
					suma += digito;

					System.out.print(digito);
					
					if(aux > 0){
						System.out.print(" + ");
					}

				} while(aux > 0);

				System.out.print(" = " + suma);
				System.out.println();
				
			}

		} while(numero > 0);


	}



}
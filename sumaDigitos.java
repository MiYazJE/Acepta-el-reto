import java.util.Scanner;

public class sumaDigitos {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int num;
		int aux;
		int decima;
		int veces;
		int suma;

		num = s.nextInt();

		while (num >= 0) {

			decima = 1;
			aux    = num;
			veces  = 1; 
			suma   = 0;

			while(aux > 9) {
				aux    = aux / 10; 
				decima = decima * 10;
				veces  = veces + 1;
			}

			aux = num;

			for(int i = 0; i < veces; i++) {

				aux    = num / decima;
				num    = num % decima;
				decima = decima / 10;
				suma   = suma + aux;

				System.out.print( aux );

				if((i+1) <= (veces-1)) { 
					System.out.print( " + " );
				} else {
					System.out.print( " = " + suma + "\n");
				}

			}


			num = s.nextInt();

		}

		s.close();
	}



}
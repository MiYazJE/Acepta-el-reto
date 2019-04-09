import java.util.Scanner;

public class p374 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos;
		long num;
		long mayor = 0; 
		long menor = 0; 
		int vecesMenor = 0;
		int vecesMayor = 0;

		casos = s.nextInt();


		for(int i=0; i<casos; i++) {

		    num = s.nextLong();

		    menor = 9999999999999L;
		    mayor = 0;

			while(num != 0) {

				if(num < menor) {

					menor = num;
					vecesMenor = 1;
							
				} else if(menor == num) {
					
					vecesMenor++;
					
				}

				if(num > mayor) {

					mayor = num;
					vecesMayor = 1;

				} else if(mayor == num) {
					
					vecesMayor++;

				}

				
				num = s.nextLong();

			}

			System.out.printf("%d %d %d %d\n", menor, vecesMenor, mayor, vecesMayor);

		}

		s.close();

	}


}
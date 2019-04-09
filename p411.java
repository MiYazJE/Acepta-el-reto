import java.util.Scanner;

public class p411 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int pesoMaximo;
		int pesoElefante;
		int pesoTotal;
		boolean seguir;
		int numElefantes;

		pesoMaximo = s.nextInt();

		while(pesoMaximo != 0) {

			numElefantes = 0;
			pesoTotal = 0;
			seguir = true;

			pesoElefante = s.nextInt();

			while(pesoElefante != 0) {
				
				if(seguir) {
					pesoTotal += pesoElefante;
				}				

				if(pesoMaximo < pesoTotal) {
					seguir = false;
				} else {
					numElefantes++;
				}

				pesoElefante = s.nextInt();

			}

			System.out.println( numElefantes );
			pesoMaximo = s.nextInt();
		}


		s.close();
	}



}

import java.util.Scanner;

public class p397 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos;
		int numero;

		casos = s.nextInt();

		for (int i = 0; i < casos; i++) {

			numero = s.nextInt();
				
			if(numero % 3 == 0 || (numero + 1) % 3 == 0) {
				System.out.println("SI");
			} 
			else {
				System.out.println("NO");
			}


		}



		s.close();
	}

}
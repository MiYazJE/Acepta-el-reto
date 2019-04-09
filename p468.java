import java.util.Scanner;

public class p468 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos;
		int diferencia;
		int dia;
		int dia2;

		while (s.hasNext()) {

			casos = s.nextInt();
			dia   = s.nextInt();

			diferencia = 0;

			for (int i = 1; i < casos; i++) {

				dia2 = s.nextInt(); 

				if (dia2 < dia) dia = dia2;
				else diferencia = Math.max(diferencia, dia2-dia);

			}

			System.out.println( diferencia );

		}

	}

}
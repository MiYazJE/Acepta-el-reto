import java.util.Scanner;

public class p438 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String frase;
		int nLetras;
		int nExclamaciones;

		while (s.hasNext()) {

			nExclamaciones = 0;
			nLetras        = 0;

			frase = s.nextLine();

			frase = frase.toLowerCase();
			frase = frase.replaceAll(" ", "");

			for (int i = 0; i < frase.length(); i++) {
				if (frase.charAt(i) == 33) nExclamaciones++;
				if (frase.charAt(i) >= 97 && frase.charAt(i) <= 122) nLetras++;
			}

			if (nExclamaciones > nLetras) {
				System.out.println("ESGRITO");
			}
			else {
				System.out.println("esgrito");
			}


		}

	}

}
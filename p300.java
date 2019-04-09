import java.util.Scanner;

public class p300 {


	public static boolean pentavocalica(String palabra) {

		boolean pentavocalica = true;
		char[] vocales = {'a', 'e', 'i', 'o', 'u'};
		char letra;

		for(int i = 0; i < palabra.length(); i++) {

			letra = palabra.charAt(i);

			if(     (letra == 'a') ||
					(letra == 'e') ||
					(letra == 'i') ||
					(letra == 'o') ||
					(letra == 'u')) {
				
				for(int j = 0; j < vocales.length; j++) {

					if(letra == vocales[j]) {
						vocales[j] = 'x';
						break; 
					}

				}
				
			}
			
		}

		for(int i = 0; i < vocales.length; i++) {

			if(vocales[i] != 'x') {
				pentavocalica = false;
				return pentavocalica;
			}

		}

		return pentavocalica;

	}


	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		String palabra;

		for(int i = 0; i < casos; i++) {

			palabra = s.next();

			if(pentavocalica(palabra)) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}
			
		}

		s.close();
		System.exit(0);

	}

}

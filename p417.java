import java.util.Scanner;

public class p417 {

	public static int devolverCiclica(String palabra) {

		String ciclica  = "";
		String comparar = "";
		boolean esCiclica = true;
		char letra = palabra.charAt(0);
		boolean igual = true;

		for (int i = 1; i < palabra.length(); i++) {
			if (palabra.charAt(i) != letra)  {
				igual = false;
				break;
			}
		}
		
		
		if (igual == false) {
			
			for (int i = 0; i < palabra.length()/2; i++) {

				esCiclica = true;
				ciclica += palabra.charAt(i);

				for (int j = i+1; j < palabra.length(); j+=i+1) {

					if (j+i+1 > palabra.length()) {
						esCiclica = false;
						break;
					}
					
					comparar = palabra.substring(j, j+ciclica.length());

					if (!ciclica.equals(comparar)) {
						esCiclica = false;
						break;
					}

				}
				
				if (esCiclica) break;

			}
			
		} else {
			return 1;
		}

		if (esCiclica) {
			return ciclica.length();
		} else {
			return palabra.length();
		}

	}


	public static void main(String[] args ) {

		Scanner s = new Scanner(System.in);

		String palabra;

		while (s.hasNext()) {

			palabra = s.next();
			
			palabra = palabra.toLowerCase();

			System.out.println( devolverCiclica(palabra) );

		}

	}

}

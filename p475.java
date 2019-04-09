import java.util.Scanner;

public class p475 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		s.nextLine();
		String frase;
		String nombre = "stanlee";
		int pos;
		int repeat;

		for (int i = 0; i < casos; i++) {

			frase = s.nextLine();
			frase = frase.trim().toLowerCase();

			pos    = 0;
			repeat = 0;

			for (int j = 0; j < frase.length(); j++) {

				if (frase.charAt(j) == nombre.charAt(pos)) {
					pos++;	
				} 
				if (pos == nombre.length()) {
					pos = 0; repeat++;	
				} 

			}

			System.out.println( repeat );
			
		}

	}

}
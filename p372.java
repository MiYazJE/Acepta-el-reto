import java.util.Scanner;

public class p372 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String palabra;
		int casos;

		casos = s.nextInt();

		for(int i=0; i<casos; i++) {

			palabra = s.next();

			System.out.println(inversa(palabra));

		}


		s.close();
	}

	
	public static String inversa(String palabra) {

		String inversa = "";

		for(int i=palabra.length()-1; i>=0; i--) {

			if(Character.isUpperCase(palabra.charAt(0)) && i == palabra.length()-1) {
				inversa += ("" + Character.toUpperCase(palabra.charAt(i)));
			}
			else if(Character.isUpperCase(palabra.charAt(i))) {
				inversa += ("" + Character.toLowerCase(palabra.charAt(i)));
			}
			else {
				inversa += ("" + palabra.charAt(i));
			}
			
		}

		return inversa;

	} 






}
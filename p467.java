import java.util.Scanner;

public class p467 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String palabra1;
		String basura;
		String palabra2;
		int casos = s.nextInt();

		for(int i = 0; i < casos; i++) {

			palabra1 = s.next();
			basura   = s.next();
			palabra2 = s.next();

			palabra1 = palabra1.toLowerCase();
			palabra2 = palabra2.toLowerCase();

			if(palabra1.equals(palabra2)) {
				System.out.println( "TAUTOLOGIA" );
			} else {
				System.out.println( "NO TAUTOLOGIA" );
			}

		}
		
	}




}
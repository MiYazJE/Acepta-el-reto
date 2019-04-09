import java.util.*;


public class p260 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String palabra1;
		String palabra2;
		char[] palabreja = new char[1000];
		char[] palabreja2 = new char[1000];
		int casos;

		casos = s.nextInt();
		s.nextLine();

		for (int i = 0; i < casos; i++) {

			palabra1 = s.nextLine();
			palabra1 = palabra1.toLowerCase();
			palabra1 = palabra1.replace(" ", "");

			palabra2 = s.nextLine();
			palabra2 = palabra2.toLowerCase();
			palabra2 = palabra2.replace(" ", "");

			palabreja = palabra1.toCharArray();
			palabreja2 = palabra2.toCharArray();

			Arrays.sort(palabreja);
			Arrays.sort(palabreja2);

			if(palabreja.length == palabreja2.length) {

				if(String.valueOf(palabreja).equals(String.valueOf(palabreja2))) {
					System.out.println("SI");
				} else {
					System.out.println("NO");
				}

			} else {
				System.out.println("NO");
			}

		}

		s.close();
	}

}
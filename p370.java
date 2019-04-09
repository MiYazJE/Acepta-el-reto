import java.util.Scanner;

public class p370 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos;
		String cadena;
		String[] partes = new String[2];
		String left;
		String right;
		int mayor;
		int menor;

		casos = s.nextInt();
		s.nextLine();

		for(int i = 0; i < casos; i++) {

			cadena = s.nextLine();
			partes = cadena.split("-");
			left   = partes[0];
			right  = partes[1];

			if(Integer.parseInt(left) > Integer.parseInt(right)) {
				mayor = Integer.parseInt(left);
				menor = Integer.parseInt(right);
			} else {
				menor = Integer.parseInt(left);
				mayor = Integer.parseInt(right);
			}

			if(menor % 2 == 0 && menor + 1 == mayor) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}


		}



		s.close();
	}


}
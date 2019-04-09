import java.util.Scanner;

public class p472 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int desPermitido;
		int desnivel;
		int tramos;
		int altura1;
		int altura2;
		boolean apto; 

		while (s.hasNext()) {

			desPermitido = s.nextInt();
			tramos       = s.nextInt();

			apto     = true;
			desnivel = 0;

			altura1 = s.nextInt();
			for (int i = 1; i < tramos; i++) {

				altura2 = s.nextInt();

				if (altura2 > altura1) {
					desnivel += altura2 - altura1;
				} else {
					desnivel = 0;
				}

				if(desnivel > desPermitido) {
					apto = false;
					s.nextLine();
					break;
				}

				altura1 = altura2;
			}

			if (apto) {
				System.out.println("APTA");
			} else {
				System.out.println("NO APTA");
			}

		}
		

		s.close();

	}

}
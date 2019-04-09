import java.util.Scanner;

public class p487 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		long horasRetroceder = 0;
		long vueltasAnadidas;
		long parteEntera;
		long resto;

		for (int i = 0; i < casos; i++) {

			vueltasAnadidas = 0;
			horasRetroceder = s.nextLong();

			long total = horasRetroceder;

			while (total >= 3600) {

				parteEntera     = total / 3600;
				resto           = total % 3600;
				vueltasAnadidas += parteEntera;

				total = parteEntera + resto; 

			}

			System.out.println(vueltasAnadidas + horasRetroceder);

		}


	}

}
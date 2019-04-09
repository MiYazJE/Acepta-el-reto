import java.util.Scanner;

public class p488 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		int guardados;
		int tiempoLimite;
		int tiempo;
		int tiempo1;
		int tiempo2;
		int sesiones;

		for (int j = 0; j < casos; j++) {

			tiempo   = 0;
			sesiones = 1;

			guardados    = s.nextInt();
			tiempoLimite = s.nextInt();

			tiempo1 = s.nextInt();

			for (int i = 1; i < guardados; i++) {

				tiempo2 = s.nextInt();

				tiempo += Math.abs(tiempo1 - tiempo2);
				
				if (tiempo >= tiempoLimite) {
					sesiones += tiempo / tiempoLimite;
					tiempo = tiempo % tiempoLimite;
				}
				
				tiempo1 = tiempo2;
			}

			System.out.println( sesiones );

		}

	}


}
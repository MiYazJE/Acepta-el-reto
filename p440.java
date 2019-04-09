import java.util.Scanner;

public class p440 {
	
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int grupos;
		int integrantes;
		int grupoMayor;
		int grupoMenor;
		int menor;
		int comparar;
		int numeroEscaladores = s.nextInt();

		while (numeroEscaladores != 0) {

			grupos      = 1;
			integrantes = 1;
			grupoMayor  = Integer.MIN_VALUE;
			grupoMenor  = Integer.MAX_VALUE;

			menor = s.nextInt();
			for (int i = 1; i < numeroEscaladores; i++) {

				comparar = s.nextInt();

				if (menor <= comparar) {
					integrantes++;
				}
				else {

					grupos++;
					if (integrantes > grupoMayor) grupoMayor = integrantes;
					if (integrantes < grupoMenor) grupoMenor = integrantes;
					menor = comparar;
					integrantes = 1;

				}

			}

			if (integrantes > grupoMayor) grupoMayor = integrantes;
			if (integrantes < grupoMenor) grupoMenor = integrantes;
			
			System.out.print(grupos + " ");
			System.out.print(grupoMenor + " ");
			System.out.print(grupoMayor + "\n");

			numeroEscaladores = s.nextInt();

		}


	}
}

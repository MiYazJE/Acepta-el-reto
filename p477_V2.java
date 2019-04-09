import java.util.Scanner;

public class p477_V2 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int vida;
		int armas;
		int[][] equipo;
		int[] armasUtilizadas;
		int pos = 0;
		int menorDanyo;

		while (true) {

			vida = s.nextInt();

			if (vida == 0) System.exit(0);

			armas  = s.nextInt();
			equipo = new int[armas][2];
			armasUtilizadas = new int[armas];

			// en la matriz equipo guardamos el arma y su danyo, en este orden equipo[ciudadano][villano]
			for (int i = 0; i < armas; i++) {
				for (int j = 0; j < 2; j++) {
					equipo[i][j] = s.nextInt();
				}
			}


			for (int j = 0; j < armas && vida > 0; j++) {

				menorDanyo = Integer.MAX_VALUE;
				for (int i = 0; i < armas; i++) {

					if (equipo[i][0] < menorDanyo && equipo[i][0] > -1) {
						menorDanyo = equipo[i][0];
						pos = i;
					}
					else if (equipo[i][0] == menorDanyo) {

						if (equipo[i][1] > equipo[pos][1] && equipo[i][0] > -1) {
							menorDanyo = equipo[i][0];
							pos = i;
						}

					}

				}
				
				// extraemos la posicion del arma que vamos a utilizar
				vida -= equipo[pos][1];
				armasUtilizadas[j] = pos+1;

				// las posiciones ya utilizadas las dejamos a -1 para no reutilizarlas
				equipo[pos][0] = -1;
				equipo[pos][1] = -1;

				if (vida <= 0) break;
				
			}

			// Si la vida del Dr Muerte es mayor de 0 escribimos MUERTE ESCAPA
			if (vida > 0) System.out.println("MUERTE ESCAPA");
			else {

				for (int i = 0; i < armasUtilizadas.length; i++) {

					// Imprimimos las armas utilizadas, existen posiciones a 0 asi que hay que evitarlas.
					if (armasUtilizadas[i] != 0) {
						// Compruebo esto para no dejar espacios al final, para que no de PE
						if (i+1 != armasUtilizadas.length) {
							if (armasUtilizadas[i+1] != 0) {
								System.out.print(armasUtilizadas[i] + " ");
							} else {
								System.out.print(armasUtilizadas[i]);
							}
						} else {
							System.out.print(armasUtilizadas[i]);
						}
					} else {
						break;
					}

				}

				System.out.println("");
			}

		}


	}

}
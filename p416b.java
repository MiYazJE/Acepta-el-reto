import java.util.*;

public class p416b {


	public static boolean comprobarCumpleanyos(String[] fechas) {

		boolean cumpleanyos = false;

		for(int i = 0; i < fechas.length-1; i++) {
			for(int j = i+1; j < fechas.length; j++) {

				if(fechas[i].equals(fechas[j])) {

					cumpleanyos = true;
					return cumpleanyos;

				}

			}
		}

		return cumpleanyos;

	}



	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int totalFechas = s.nextInt();
		String aux;
		String[] fechas;

		while(totalFechas != 0) {

			fechas = new String[totalFechas];

			for(int i = 0; i < totalFechas; i++) {

				aux = s.next();
				fechas[i] = aux.substring(0, aux.length()-5);

			}

			if(comprobarCumpleanyos( fechas )) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}

			totalFechas = s.nextInt();

		}


	}


}

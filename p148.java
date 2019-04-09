import java.util.Scanner;

public class p148 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String linea;
		String[] tiempo = new String[10];
		int horas, minutos;
		int resultado = 0;

		linea = s.next();


		while(!linea.equals("00:00")) {

			tiempo = linea.split(":");
			horas = Integer.parseInt(tiempo[0]);
			minutos = Integer.parseInt(tiempo[1]);

			resultado = (86400 - ((horas * 60 * 60) + (minutos * 60))) / 60;

			System.out.println(resultado);

			linea = s.next();
		}


		s.close();
	}


}
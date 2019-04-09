import java.util.*;
import java.text.*;

public class p437 {

	public static void main(String[] args) throws ParseException {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		final String hora1 = "23:59:60";
		String hora2;

		for (int i = 0; i < casos; i++) {

			int hora = 0;
			int min  = 0;
			int seg  = 0;

			hora2 = s.next();

			SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
			Date fechaFinal   = formato.parse(hora1);
			Date fechaInicial = formato.parse(hora2);

			int resultado = (int)(fechaFinal.getTime() - fechaInicial.getTime());

			resultado /= 1000;

			hora = resultado/3600;
			min  = (resultado-(3600*hora))/60;
			seg  = resultado-((hora*3600)+(min*60));

			System.out.printf("%02d:%02d:%02d\n", hora, min, seg);

		}

	}


}
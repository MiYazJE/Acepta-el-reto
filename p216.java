import java.util.Scanner;

public class p216 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos;
		int gotas;
		int segundos = 0;
		int minutos = 0;
		int horas = 0;



		casos = s.nextInt();

		for(int i=0; i<casos; i++) {

			gotas = s.nextInt();

			horas = gotas / 3600;
			minutos = (gotas / 60) - (horas * 60);
			segundos = gotas - (minutos * 60) - (horas * 3600);

			System.out.printf("%02d:%02d:%02d", horas, minutos, segundos);
			System.out.println();


		}





	}


}
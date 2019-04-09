import java.util.Scanner;

public class p363 {

	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);

		int calQuemadas;
		int numComilonas;
		int calComilonas;
		int entrenamientos;

		calQuemadas = s.nextInt();

		while(calQuemadas != 0) {

			numComilonas = s.nextInt();

			entrenamientos = 0;
			calComilonas   = 0;

			for(int i=0;i<numComilonas;i++) calComilonas += s.nextInt();

			do {

				entrenamientos++;
				calComilonas -= calQuemadas;

			} while(calComilonas > 0);

			System.out.println( entrenamientos );

			calQuemadas = s.nextInt();
		}

	}
	
}
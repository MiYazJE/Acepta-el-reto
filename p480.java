import java.util.Scanner;

public class p480 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		double uvas;
		double a, b;
		double calculo;

		for (int i = 0; i < casos; i++) {

			uvas = s.nextDouble();
			a    = s.nextDouble();
			b    = s.nextDouble(); 

			calculo = Math.ceil((uvas / b * a)+1);

			System.out.println( (int)calculo );

		}

	}


}
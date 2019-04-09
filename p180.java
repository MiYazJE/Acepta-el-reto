import java.util.Scanner;

public class p180 {

	public static void main(String[] args){

		Scanner s = new Scanner(System.in);

		int lado1 = 0; 
		int lado2 = 0; 
		int lado3 = 0;
		int p1, p2;
		int iteraciones;


		iteraciones = s.nextInt();


		for (int i = 0; i < iteraciones; ++i){

			lado1 = s.nextInt();
			lado2 = s.nextInt();
			lado3 = s.nextInt();



			if ((lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1)) {

				if (lado1 >= lado2 && lado1 >= lado3){
					p1 = lado1*lado1;
					p2 = lado2*lado2 + lado3*lado3;

					if (p1 < p2)
						System.out.println("ACUTANGULO");
					else if (p1>p2)
						System.out.println("OBTUSANGULO");
					else System.out.println("RECTANGULO");
				}

				else if (lado2 >= lado1 && lado2 >= lado3){
					p1 = lado2*lado2;
					p2 = lado1*lado1 + lado3*lado3;

					if (p1 < p2)
						System.out.println("ACUTANGULO");
					else if (p2 < p1)
						System.out.println("OBTUSANGULO");
					else System.out.println("RECTANGULO");
				}
				else if (lado3 >= lado1 && lado3>=lado2){
					p1 = lado3*lado3;
					p2 = lado1*lado1 + lado2*lado2;

					if (p1 < p2)
						System.out.println("ACUTANGULO");
					else if (p2 < p1)
						System.out.println("OBTUSANGULO");
					else System.out.println("RECTANGULO");
				}

			} else {
				System.out.println("IMPOSIBLE");
			}
			
		}

	}
	
}
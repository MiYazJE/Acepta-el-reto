import java.util.Scanner;

public class p433 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int uvas;
		int acumulador;

		uvas = s.nextInt();

		while(uvas != 0) {

			acumulador = 0;

			for(int i = 1; i <= uvas; i++) {

				acumulador += i;

				if(acumulador >= uvas) {
					System.out.println(i);
					break;
				}

			}

			
			uvas = s.nextInt();
		}


	}

}
import java.util.Scanner;

public class p369 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int entrada;

		entrada = s.nextInt();


		while(entrada != 0) {

			for(int i=0; i<entrada; i++) {

				System.out.print("1");

			}

			System.out.println();

			entrada = s.nextInt();
		}


	}


}
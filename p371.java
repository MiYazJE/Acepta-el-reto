import java.util.Scanner;

public class p371 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int entrada;
		int cerillas;


		entrada = s.nextInt();

		while(entrada != 0) {

			cerillas = 0;

			for(int i=entrada; i>0; i--) {
				
				cerillas += 3 * i;

			}

			System.out.println(cerillas);

			entrada = s.nextInt();

		}



	}


}
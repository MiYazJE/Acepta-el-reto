import java.util.Scanner;

public class p117 {

	public static void main(String[] args){

		Scanner s = new Scanner(System.in);

		int casos;
		casos = s.nextInt();		

		String basura;

		String nombre;

		for(int i=1; i<=casos; i++){

			basura = s.next();

			nombre = s.next();

			System.out.println("Hola, " +nombre+ ".");

		}


	}

}
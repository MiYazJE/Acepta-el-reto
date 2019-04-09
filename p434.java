import java.util.Scanner;

public class p434 {

	public static void main(String[] args){

		Scanner s = new Scanner(System.in);

		int caso;
		int palomas;
		int cajas;

		caso = s.nextInt();


		for(int i=0; i<caso; i++) {

			palomas = s.nextInt();
			cajas = s.nextInt();

			if(palomas < cajas) {
				System.out.println("ROMANCE");
			} else if(palomas == cajas) {
				System.out.println("ROMANCE");
			} else {
				System.out.println("PRINCIPIO");
			}

		}

		


	}



}
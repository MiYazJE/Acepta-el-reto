import java.util.Scanner;

public class p482 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String calcetin;
		int negros;
		int grises;

		while (true) {

			negros = 0;
			grises = 0;

			calcetin = s.next(); 

			if (calcetin.equals(".")) {
				break;
			}

			while (!calcetin.equals(".")) {

				if (calcetin.equals("N")) {
					negros++;
				} else if (calcetin.equals("G")) {
					grises++;
				}

				calcetin = s.next(); 
			}

			if ((negros + grises) % 2 == 0 && negros % 2 == 0 && grises % 2 == 0) {
				System.out.println("EMPAREJADOS");
			}
			else if (negros - grises == 1) {
				System.out.println("NEGRO SOLITARIO");
			}
			else if (grises - negros == 1) {
				System.out.println("GRIS SOLITARIO");
			}
			else {
				System.out.println("PAREJA MIXTA");
			}

		}

	}


}
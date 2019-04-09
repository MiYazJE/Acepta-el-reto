import java.util.Scanner;

public class p390 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		int magenta, amarillo, cian;
		String pixeles;

		for (int j = 0; j < casos; j++) {

			magenta  = s.nextInt();
			amarillo = s.nextInt();
			cian     = s.nextInt();
			pixeles  = s.nextLine();

			for (int i = 0; i < pixeles.length(); i++)  {

				switch (pixeles.charAt(i) + "") {
					case "M": magenta--; break;
					case "C": cian--; break;
					case "A": amarillo--; break;
					case "R": magenta--; amarillo--; break;
					case "N": magenta--; amarillo--; cian--; break;
					case "V": amarillo--; cian--; break;
					case "L": magenta--; cian--; break;
				}

			}

			if (magenta < 0 || cian < 0 || amarillo < 0) {
				System.out.println("NO");
			} else {
				System.out.printf("SI %d %d %d\n", magenta, amarillo, cian);
			}

		}

	}
	
}
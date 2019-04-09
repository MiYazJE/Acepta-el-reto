import java.util.Scanner;

public class p416 {

	public static boolean comprobarFecha(String[] diaMes) {

		boolean cumpleanyos = false;

		for(int i = 0; i < diaMes.length; i=i+3) {
			for(int j = 3; j < diaMes.length; j=j+3) {

				if(diaMes[i].equals(diaMes[j]) && diaMes[i+1].equals(diaMes[j+1]) && i != j) {
					cumpleanyos = true;
					return cumpleanyos;
				}
				
			}
		}

		return cumpleanyos;

	}



	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String x = s.nextLine();
		x = x.trim();
		int fechasTotal = Integer.parseInt(x);
		String fecha;
		String[] diaMes;

		while( true ) {

			diaMes = new String[fechasTotal*3];

			fecha  = s.nextLine();
			fecha  = fecha.replace(" ", "/");
			diaMes = fecha.split("/");

			if(comprobarFecha(diaMes)) {
				System.out.println("SI");				
			} else {
				System.out.println("NO");
			}

			x = s.nextLine();
			x = x.trim();
			fechasTotal = Integer.parseInt(x);

			if(fechasTotal == 0) {
				System.exit(0);	
			}

		}

		

	}

}
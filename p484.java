import java.util.Scanner;

public class p484 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String num;
		char [] numC;
		boolean cambio1,cambio2;
		int pos;
		int pos2;
		double numD;
		boolean punto;
		boolean pintar;
		boolean seguir;

		while (sc.hasNext()) {

			num = sc.nextLine();
			numD = Double.parseDouble(num);
			numC = num.toCharArray();
			String cadena2 = null;
			cambio1 = false;
			cambio2 = false;
			pos = 0;
			pos2 = num.length();
			punto  = false; 
			pintar = false;
			seguir = false;


			if (numD > 0) {

				for (int i = 0; i < num.length(); i++) {

					if(numC[i] == '0' && cambio1 == false) {	

						cambio1 = false;

					} else {

						if (num.charAt(i) == '.') {
							pos = i;
							seguir = true;
							break;
						}
						pintar = true;
						
						cambio1 = true;
						System.out.print(numC[i]);

					}	
				}

				
				if (seguir) {
					
					if (pintar == false) {
						System.out.print("0");
					}
					
					for (int i = numC.length-1; i > pos; i--) {

						// si el char no es igual a 0 sabemos que tenemos que imprimir 0 
						if	(numC[i] != '0') {
							pos2 = i+1;
							punto = true;
							break;
						}
						
					}

					// si punto esta a true significa que hay digitos distintos a 0, por ende hay que pintar el punto
					if (punto)  {
						System.out.print(".");
						
						for (int i = pos+1; i < pos2 ; i++) {

							System.out.print(numC[i]);
							
						}
						
					} 
					
					System.out.println("");
					
				} else {
					System.out.println("");
				}
				
			} else {

				System.out.println('0');
			}
			
		}
	}

}


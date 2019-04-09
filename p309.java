import java.util.Scanner;

// 15 + 8 - 7 + 10 - 3
//   23  16  26   23

public class p309 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);


		int casos;
		int resultado = 0;
		int n2;
		String signo;


		casos = s.nextInt(); 


		for(int i=0; i<casos; i++) {

			resultado = s.nextInt();

			signo = s.next();

			n2 = s.nextInt();

			while(!signo.equals(".")) {

				if(signo.equals("+")) {

					resultado += n2;

				} else if(signo.equals("-")) {

					resultado -= n2;

				}

				signo = s.next();

				if(signo.equals(".")) { 
					System.out.print(resultado);
					resultado = 0;
				} else {
					System.out.print(resultado + ", ");
					n2 = s.nextInt();
				}

			}

			
			System.out.println();

			


		}


	}



}
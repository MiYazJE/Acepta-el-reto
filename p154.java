import java.util.Scanner;

public class p154 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String numMatricula;
		String letraMatricula;
		int matriculaNumero;
		char[] matriculaChar = new char[3];
		char letra;
		
		numMatricula = s.next();

		letraMatricula = s.next();

		while(!(numMatricula.equals("9999") && letraMatricula.equals("ZZZ"))) {

			matriculaNumero = Integer.parseInt(numMatricula);
			matriculaNumero++;
			numMatricula = String.valueOf(matriculaNumero);

			if(matriculaNumero > 9999) {
				
				numMatricula = "0000";

				for(int i=0; i<letraMatricula.length(); i++) {

					matriculaChar[i] = letraMatricula.charAt(i);

				}

				matriculaChar[2] = next_char(letraMatricula.charAt(2));

				if(matriculaChar[2] == 'B') {

					matriculaChar[1] = next_char(letraMatricula.charAt(1));

					if(matriculaChar[1] == 'B') {

						matriculaChar[0] = next_char(letraMatricula.charAt(0));

					}

				}


			}

			if(numMatricula.equals("0000")) { 

				System.out.print(numMatricula + " ");

				for (int i=0;i<3;i++) {
					System.out.print(matriculaChar[i]);
				}

				System.out.println();

			} else {

				System.out.printf("%04d %s", matriculaNumero, letraMatricula );
				System.out.println();

			}


			numMatricula = s.next();

			letraMatricula = s.next();

		}


	}

	public static char next_char(char x) {

		char letras[] =  {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'}; 
		int pos = 0;

		for(int i=0; i<21; i++) {

			if(x == letras[i]) {
				pos = i;
			}

		}

		if(letras[pos] == 'Z') {

			return letras[0];

		} else {
			
			return letras[pos+1];
			
		}

	}


}
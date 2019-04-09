import java.util.Scanner;

public class p364 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String frase;
		String fraseEncriptada;

		frase = s.nextLine();

		while(!frase.equals("FIN")) {

			fraseEncriptada = siguienteLetra(frase);

			System.out.println(fraseEncriptada);


			frase = s.nextLine();
		}


		s.close();
	}



	public static String siguienteLetra(String frase) {

		char letras[] =  {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		int pos;
		String encriptado = "";

		for(int i=0; i<frase.length(); i++) {

			pos = 0;

			for(int j=0; j<letras.length; j++) {
				
				if(frase.charAt(i) == letras[j]){
					pos = j;
				}

			}

			if(letras[pos] == 'Z') {
				encriptado += ("" + letras[0]);
			}
			else if(frase.charAt(i) == ' ') {
				encriptado += " ";
			} 
			else {
				encriptado += ("" + letras[pos+1]);
			}


		}

		return encriptado;

	}



}
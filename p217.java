import java.util.Scanner;

public class p217 {

	public static void main(String[] args){

		Scanner s = new Scanner(System.in);

		int numero;

		numero = s.nextInt();

		while(numero != 0){

			if(numero %2 == 0){
				System.out.println("DERECHA");
			} else {
				System.out.println("IZQUIERDA");
			}

			numero = s.nextInt();

		}


	}



}
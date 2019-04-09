import java.util.Scanner;

public class p380 {

	public static void main(String[] args){

		Scanner s = new Scanner(System.in);

		int num;
		int suma;

		do {

			suma = 0;
			num = s.nextInt();

			if(num != 0){
				
				for(int i=1; i<=num; i++){
					suma += s.nextInt();
				}

				System.out.println(suma);
			}

		} while(num != 0);

		


	}



}
import java.math.BigInteger;
import java.util.Scanner;

public class p259 {

	public static void main(String[] args){

		Scanner s = new Scanner(System.in);

		int exp = 0;
		int entrada;
		BigInteger capicuas = BigInteger.valueOf(1);

		entrada = s.nextInt();

		while(entrada != 0) {

			if (entrada == 1) {

				capicuas = BigInteger.valueOf(10); 

			} else if(entrada %2 == 0) {

				exp = (entrada - 1) / 2;
				capicuas = BigInteger.valueOf(10).pow(exp);
				capicuas = BigInteger.valueOf(9).multiply(capicuas);
					
			} else {

				exp = entrada / 2;
				capicuas = BigInteger.valueOf(10).pow(exp);
				capicuas = BigInteger.valueOf(9).multiply(capicuas);

			}

				System.out.println(capicuas);
				entrada = s.nextInt();

		}

		s.close();		

	}
			

}

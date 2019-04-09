import java.util.Scanner;

public class p444 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int mediciones;
		int limite;
		int[] n;

		while (true)  {

			mediciones = s.nextInt();
			limite    = s.nextInt();

			n = new int[mediciones];

			if (mediciones == 0 && limite == 0) {
				System.exit(0);
			}

			for (int i = 0; i < mediciones; i++) n[i] = s.nextInt();

			int sum = 0, aux = 0, salir = 0, maximo = 0;

	        for (int i = 0; i < n.length; i++) {
	            if (n[i] == 1) {
	                for (int j = i; j < n.length; j++) {

	                    sum++; salir=j;

	                    if(n[j] != 0) {
	                    	aux = 0;
	                    	maximo = Math.max(maximo,sum);
	                    }

	                    if( n[j] == 0 ) aux++;
	                    if( aux > limite ) break;

	                }

	                i=salir;
	                sum=0; aux=0;
	            }
	        }

			System.out.println( maximo );

		}

	}

}
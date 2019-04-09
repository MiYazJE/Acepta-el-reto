import java.util.Scanner;

public class p151 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int[][] matriz;
		int n;
		boolean identidad;

		n = s.nextInt();

		while(n != 0) {

			matriz    = new int[n][n];
			identidad = true;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {

					matriz[i][j] = s.nextInt();
					
				}
			}

			// comprobar diagonal de 1
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {

					if(matriz[i][i] != 1) {
						identidad = false;
						break;
					}
					
				}
			}

			// comprobar lado izquierdo de 0
			if( identidad ) {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < i; j++) {

						if(matriz[i][j] != 0) {
							identidad = false;
							break;
						}
						
					}
				}

			}

			//comprobar lado derecho de 1
			if( identidad ) {
				for(int i = 0; i < n; i++) {
					for(int j = n-1; j > i; j--) {

						if(matriz[i][j] != 0) {
							identidad = false;
							break;
						}
						
					}
				}

			}


			if( identidad ) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}



			n = s.nextInt();
		}



		s.close();
	}

}

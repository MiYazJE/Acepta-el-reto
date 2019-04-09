import java.util.Scanner;

public class p431 {


	public static int devolverMayor(int[] vector) {

		int mayor = Integer.MIN_VALUE;

		for (int i = 0; i < vector.length; i++) if (vector[i] > mayor) mayor = vector[i];

		return mayor;

	}


	public static int[] ordenarAscendente(int[] V) {

		int aux = 0;

		for (int i=0; i<V.length-1; i++) {
		   for (int j=i+1; j<V.length; j++) {
		    
		    if(V[i]>V[j]) {

			    aux = V[i];
			    V[i] = V[j];
			    V[j] = aux;

		    }

		  }
		}

		return V;

	}


	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int familias = s.nextInt();
		int numHijos;
		int midiclorianos;
		int influencia;
		int[] midiclorianosFinal;
		int[] midiclorianosFamilia;

		while (familias != 0) {

			midiclorianosFinal = new int[familias];

			for (int i = 0; i < familias; i++) {

				numHijos = s.nextInt();
				midiclorianosFamilia = new int[numHijos];		

				midiclorianos = s.nextInt();

				for (int j = 0; j < numHijos; j++) {

					influencia = s.nextInt();
					midiclorianosFamilia[j] = influencia * midiclorianos; 

				}

				midiclorianosFinal[i] = devolverMayor(midiclorianosFamilia);

			}

			midiclorianosFinal = ordenarAscendente(midiclorianosFinal);

			for(int i = midiclorianosFinal.length; i > 0; i--) {
				
				System.out.print(midiclorianosFinal[i-1]);
				if (i-1 != 0) System.out.print(" ");

			}

			System.out.println();

			familias = s.nextInt();

		}


	}


}

import java.util.Scanner;

public class p365 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos = s.nextInt();
		int ninos;
		int posAitor;
		int[] cola;
		int tiempo;
		boolean aitor;

		for (int j = 0; j < casos; j++) {

			ninos    = s.nextInt();
			posAitor = s.nextInt();
			cola     = new int[ninos];
			tiempo   = 0;
			aitor    = false;

			for (int i = 0; i < ninos; i++) cola[i] = s.nextInt();

			while (aitor == false) {

				for (int i = 0; i < cola.length; i++) {
					
					if (cola[i] != 0) {
						tiempo += 2;
						cola[i]--;
					}
					
					if (cola[posAitor-1] == 0) {
						aitor = true;
						break;
					}
					
				}

			}

			System.out.println(tiempo);

		}

	}

}
import java.util.Scanner;

public class p376 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int casos;
 		int result;

		while (true) {

			casos = s.nextInt();
			if (casos == 0) {
				break;
			}

			result = 0;
			int[] picos = new int[casos];

			for (int i = 0; i < casos; i++) picos[i] = s.nextInt();

			if (picos[0] > picos[1] && picos[0] > picos[casos-1]) {
				result++;
			}
			else if (picos[casos-1] > picos[casos-2] && picos[casos-1] > picos[0]) {
				result++;
			}

			for (int i = 1; i < casos-1; i++) {
				if (picos[i] > picos[i+1] && picos[i] > picos[i-1]) {
					result++;
				}
			}

			System.out.println( result );
		}


	}

}
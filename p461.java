import java.util.*;

class Batalla implements Comparable<Batalla> {

	int s, b, r;
	int beneficios;

	public Batalla(int s, int b, int r) {
		this.s = s;
		this.b = b;
		this.r = r;
		this.beneficios = s - (b + r);
	}

	@Override
	public int compareTo(Batalla o) {
		return o.beneficios - this.beneficios;
	}

}

public class p461 {


	public static void main(String[] args) {


		final Scanner S = new Scanner(System.in);

		int bases, res, s, b, r, temp;
		ArrayList<Batalla> batallas = new ArrayList<>();

		while (true) {


			bases = S.nextInt();
			if (bases == 0) break;

			for (int i = 0; i < bases; i++) {
				s = S.nextInt();
				b = S.nextInt();
				r = S.nextInt();
				batallas.add(new Batalla(s, b, r));					
			}

			Collections.sort(batallas);

			res = temp = 0;
			for (Batalla batalla : batallas) {

				if (temp < batalla.s) {
					res += batalla.s - temp;
					temp = batalla.s;
				}

				if (temp - (batalla.b + batalla.r) < 0) {
					res += Math.abs(temp - (batalla.b + batalla.r));
					temp = 0;
				}
				else {
					temp -= (batalla.b + batalla.r);
				}

			}

			batallas.clear();
			System.out.println( res );
		}


	}


}

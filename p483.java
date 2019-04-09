import java.util.Arrays;
import java.util.Scanner;

public class p483 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt(); 
		sc.nextLine();
		int h,m,s,h1,m1,s1,camp,ne;
		String hora1;
		String hora2;

		for (int i = 0; i < casos; i++) {
			
			hora1 = sc.next();
			hora2 = sc.next();
			String[] separacion = hora1.split(":");

			h  = Integer.parseInt(separacion[0]);
			m  = Integer.parseInt(separacion[1]);
			s  = Integer.parseInt(separacion[2]);

			separacion = hora2.split(":");
			h1 = Integer.parseInt(separacion[0]);
			m1 = Integer.parseInt(separacion[1]);
			s1 = Integer.parseInt(separacion[2]);

			camp = sc.nextInt();
			ne   = sc.nextInt();

			int total = h * 3600 + m * 60 + s;
			int total1 = h1 * 3600 + m1 * 60 + s1;
			if(total > total1) total1 += 24 * 3600;
			int res = Math.abs(total - total1);
			int aux = res/(camp - 1);
			ne--;
			aux *= ne;
			aux += total;
			s = aux %60;
			m = (aux / 60) %60;
			h = (aux / 3600) %24;

			System.out.printf("%02d:%02d:%02d\n", h, m, s);
		}

	}

}
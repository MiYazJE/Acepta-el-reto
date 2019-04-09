import java.util.Scanner;

public class p115 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int num;
		int left;
		int right;
		int decima;
		int suma;
		boolean kapkrekar;
		
		num = s.nextInt();

		while(num != 0) {

			decima = 1;
			left = 0;
			right = 0;
			suma = 0;

			kapkrekar = false;

			left = num * num;

			while(left > 0 && !kapkrekar) {

				right = right + (left % 10) * decima;
				left /= 10;
				decima *= 10;

				suma = left + right;

				if(right > 0 && suma == num) {
					kapkrekar = true;
				}

			}


			if(kapkrekar == true) {

				System.out.println("SI");

			} else if (kapkrekar == false) {

				System.out.println("NO");

			}

			num = s.nextInt();

		}


	}


}

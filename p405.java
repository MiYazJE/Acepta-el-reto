import java.util.Scanner;

public class p405 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int num, num2, aux;
		boolean put;

		while (true) {

			num = s.nextInt();
			if (num == 0) break;
			put  = false;
			aux  = num;

			while (true) {

				num2 = s.nextInt();

				if(aux == num2 - 1) {
					put = true;
				} 
            	else {	
	                if(put) {
	                 	System.out.print(num + "-" + aux);
	                 	num = num2;
	                 	put = false;
	                 	if(num2!=0) System.out.print(",");
	         		}
                	else { 
	            		System.out.print(aux);
	                	num = num2;
	                	if(num2!=0) System.out.print(",");
	                }
	            }
	            aux = num2;
	            if(num2==0) break;

			}

			System.out.println("");

		}


	}

}
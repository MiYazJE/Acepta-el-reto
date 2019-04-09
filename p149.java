import java.util.Scanner;

public class p149 {

	public static void main(String[] args){

		Scanner s = new Scanner(System.in);

		int num = 0;
		int mayor;
		int total;


		while(s.hasNext()) {

			mayor = 0;
			total = s.nextInt();

			if(total >= 1){

				for(int i=0; i<total; i++){

					num = s.nextInt();

					if(num > mayor){
						mayor = num;
					}

				}
				 	
				System.out.println(mayor);
			
			}




		}


	}


}
import java.util.Scanner;

public class p368{

	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);

		int huevos;
		int capacidad;
		int coccion;

		do {

			huevos = s.nextInt();
			capacidad = s.nextInt();
			coccion = 10;

			if(huevos <= capacidad && huevos != 0 && capacidad != 0){
				System.out.println(coccion);
			} else if(huevos != 0 && capacidad != 0) {
				
				do{

					if(huevos > capacidad){
						huevos -= capacidad;
						coccion += 10;
					}

				} while(huevos > capacidad);

				System.out.println(coccion);
			}
			

		} while(huevos != 0 && capacidad != 0);


	}
	
}
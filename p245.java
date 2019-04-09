public class p245 {

	static java.util.Scanner s;

	public static String test(long numPersonas) {

		String son = "DALTON";
		long a;
		long b;

		a   = s.nextLong();
		b   = s.nextLong();

		if(a > b) {

			numPersonas--;
        	a = b;

   			while (numPersonas > 1) {

            	b = s.nextLong();

            	if (a > b) {

            	   numPersonas--;
             	   a = b;

          	  	} else {

                	son = "DESCONOCIDOS";
                	s.nextLine();
               		return son;

            	}

        	}

    	} else if(a < b){

			numPersonas--;
            a = b;

            while (numPersonas > 1) {

                b = s.nextLong();

                if (a < b) {

                    numPersonas--;
                    a = b;

                } else {

                    son = "DESCONOCIDOS";
                    s.nextLine();
                    return son;

                }

            }

		} else {
			
			son = "DESCONOCIDOS";
			s.nextLine();
			return son;
			
		}

		return son;

	}


	public static void main(String[] args) {

		s = new java.util.Scanner(System.in);

		long numPersonas = s.nextLong();

		while(numPersonas != 0) {

			System.out.println(test( numPersonas ));
			numPersonas = s.nextLong();			
			
		}

		s.close();
		System.exit(0);

	}


}
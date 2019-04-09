import java.util.*;

public class regional_F {

    public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
        
        int casos = s.nextInt();
        int equipos;
        int result;

        for (int i = 0; i < casos; i++) {

            equipos = s.nextInt();

            result = 0;
            
            for (int j = 1; j < equipos*3; j++) 
                for (int k = j; k < equipos*3; k++) 
                    result++;

            System.out.println( result );
        }

    }

}


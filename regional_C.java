import java.util.*;

public class regional_C {

    public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
        
        int casos = s.nextInt();
		int N;
		int K;
		
		for (int j = 0; j < casos; j++) {

			N = s.nextInt();
			K = s.nextInt();
			
			ArrayList<Integer> cola = new ArrayList<Integer>();
			
			for (int i = 1; i <= N; i++) cola.add(i);
            
			int pos = 0;
			int i   = 1;
			
			if (cola.size() != 1) {
				
				cola.remove(0);
				
				while (cola.size() != 1) {
					if (i == K) {
						cola.remove(pos);
						i = 0;
					}
					else {
						pos++;
					}
					i++;
					if (pos == cola.size() || pos > cola.size()) {
						pos = 0;
					}
				}
				
			}
			
			System.out.println((cola.size() == 1) ? cola.get(0) : 1);
		}
		
	}

}


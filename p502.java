import java.util.*;

public class p502 {
	
	public static int BB(int[] m,int i,int f,int num){
		int medio, ini=i, fin=f;
		while (ini<fin){
			medio = (fin+ini)/2;
			if (m[medio]>num)fin=medio;
			else ini=medio+1;
		}
		return fin;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n;
		int[] montones;
		int mejillon, busqueda, p;
	
		while (s.hasNext()) {
			
			n = s.nextInt();
			montones = new int[n];
			montones[0] = s.nextInt();
			p = 1;
			
			for (int i = 1; i < n; i++) {
				
				mejillon = s.nextInt();
				
				if (mejillon >= montones[p-1]) {
					montones[p++] = mejillon;
				}
				else {
					busqueda = BB(montones, 0, p, mejillon);
					montones[busqueda] = mejillon;
				}
				
			}
			
			System.out.println( p );
		}
		
	}
	
}

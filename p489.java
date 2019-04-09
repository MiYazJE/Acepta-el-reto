import java.util.*;

public class p489 {

	//Algoritmo ShellSort para ordenar un vector
	public static void ShellSort(int[] data) {
        int inner, outer;
        int temp;
        int len = data.length;
        //find initial value of h
        int h = 1;
        while (h <= len / 3)
          h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)

        while (h > 0) // decreasing h, until h=1
        {
          // h-sort the file
          for (outer = h; outer < len; outer++) {
            temp = data[outer];
            inner = outer;
            // one subpass (eg 0, 4, 8)
            while (inner > h - 1 && data[inner - h] < temp) {
              data[inner] = data[inner - h];
              inner -= h;
            }
            data[inner] = temp;
          }
          h = (h - 1) / 3; // decrease h
        }
  	} 


public static void main(String[] args) {

   Scanner sc = new Scanner(System.in);

   while (sc.hasNext()){

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] colegios = new int [2][M];

		if (N>M){
			 sc.nextLine();
			 sc.nextLine();
			 sc.nextLine();
			 System.out.println("NO"); 
		} 
		else {

			for(int i = 0; i < N; i++) colegios[0][i] = sc.nextInt();
			for(int i = 0; i < M; i++) colegios[1][i] = sc.nextInt();

			ShellSort(colegios[0]);
			ShellSort(colegios[1]);

			boolean fallo = false;
			for(int i = 0; i < N; i++){
				if (colegios[0][i] > colegios[1][i]){
					fallo = true;
					break;
				}
			}

			if (fallo) 
				System.out.println("NO");
			else
				System.out.println("SI");
		}
		
	} //fin while
  } //main
} //class
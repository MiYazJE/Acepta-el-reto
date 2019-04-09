import java.util.*;

public class p477 {

	// public static void ShellSort(int[] data) {
	//     int inner, outer;
	//     int temp;
	//     int len = data.length;
	    
	//     int h = 1;
	//     while (h <= len / 3)
	//     	h = h * 3 + 1;
	
	//     while (h > 0) {
	//     	for (outer = h; outer < len; outer++) {
	//     		temp = data[outer];
	//     		inner = outer;
	//         while (inner > h - 1 && data[inner - h] >= temp) { // >=(ascendente) - <(descendente)
	//         	data[inner] = data[inner - h];
    //     		inner -= h;
	//         }
	//         data[inner] = temp;
	//     	}
	//     	h = (h - 1) / 3;
	//     }
	// }

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int vida;
		int nArmas;
		int[] danyoInocentes;
		int[] danyoVillanos;
		int[] armasUtilizadas;
		int posVillano;
		int menor;
		int mayor;
		int n;

		while (s.hasNext()) {

			vida   = s.nextInt();
			if (vida == 0) break;
			nArmas = s.nextInt();

			danyoInocentes  = new int[nArmas];
			danyoVillanos   = new int[nArmas];
			armasUtilizadas = new int[nArmas];

			for (int i = 0; i < nArmas; i++) {
				danyoInocentes[i] = s.nextInt();
				danyoVillanos[i]  = s.nextInt();
			}

			for (int j = 0; j < nArmas; j++) {
				
				posVillano  = 0;

				menor = danyoInocentes[0];
				mayor = danyoVillanos[0];
				for (int i = 1; i < nArmas; i++) {
					
					if (danyoInocentes[i] != -1) {
						if (danyoInocentes[i] < menor) {
							menor = danyoInocentes[i];
							posVillano = i;
						} 
						else {
							if (danyoInocentes[i] == menor) {
								if (danyoVillanos[i] != -1) {
									if (danyoVillanos[i] > menor) {
										mayor = danyoVillanos[i];
										posVillano = i;
									}
								}
							}
						}
					}

				}

				vida -= danyoVillanos[posVillano];
				danyoVillanos[posVillano]  = -1;
				danyoInocentes[posVillano] = -1;
				armasUtilizadas[j] = posVillano + 1;

				if (vida <= 0) break;
			}

			if (vida > 0) {
				System.out.println("MUERTE ESCAPA");
			}
			else {

				n = armasUtilizadas.length;
				for (int i = 0; i < n; i++) {
					if (i+1 < n && armasUtilizadas[i+1] != 0) {
						System.out.print(armasUtilizadas[i] + " ");
					}	
					else if (armasUtilizadas[i] != 0) {
						System.out.println(armasUtilizadas[i]);
					}
				}

			}

		} // while (true)

	} // main

} // class
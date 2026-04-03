import java.util.*;

public class p109 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        
        String categoria;
		String equipo1;
		String equipo2;
		int puntos1;
		int puntos2;
		int partidos;
		int sumar1;
		int sumar2;

        while (true) {

            categoria = s.next();

            if (categoria.trim().equals("FIN")) {
            	break;
            }

			partidos = 0;
			HashMap<String, Integer> puntuaciones = new HashMap<>();
			while (true) {
				equipo1 = s.next();
				if (equipo1.equals("FIN")) {
					break;
				}
				puntos1 = s.nextInt();
				equipo2 = s.next();
				puntos2 = s.nextInt();

				partidos++;

				sumar1 = (puntuaciones.get(equipo1) != null) ? puntuaciones.get(equipo1) : 0;
				sumar2 = (puntuaciones.get(equipo2) != null) ? puntuaciones.get(equipo2) : 0;

				if (puntos1 > puntos2) {
					puntuaciones.put(equipo1, sumar1+2);
					puntuaciones.put(equipo2, sumar2+1);
				}
				else if (puntos2 > puntos1) {
					puntuaciones.put(equipo2, sumar2+2);
					puntuaciones.put(equipo1, sumar1+1);
				}
				else {
					puntuaciones.put(equipo1, sumar1+1);
					puntuaciones.put(equipo2, sumar2+1);
				}
				
			}

			int max = 0;
			String ganador = "";
			for (Map.Entry<String, Integer> entry : puntuaciones.entrySet()) {
				int valor = entry.getValue(); 
				if (valor > max) {
					max     = valor;
					ganador = entry.getKey(); 
				}
				else if(valor == max && max != 0) {
					max = valor;
					ganador = "EMPATE";
				}
			}

			if (max == 0) {
				ganador = "EMPATE";
			}

			System.out.println(ganador + " " + ((puntuaciones.size() * (puntuaciones.size()-1))-partidos));

        }


    }


}

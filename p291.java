import java.util.*;

public class p291 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int lineas;
        String[] palabras;
        TreeMap<String, TreeSet<Integer>> cruzadas;

        while (true) {

            lineas = s.nextInt();
            if (lineas == 0) break;
            s.nextLine();
            cruzadas = new TreeMap<>();

            for (int i = 1; i <= lineas; i++) {
                palabras = s.nextLine().split(" ");
                for (int j = 0; j < palabras.length; j++) {
                    if (palabras[j].length() > 2) {
                        palabras[j] = palabras[j].toLowerCase();
                        if (!cruzadas.containsKey(palabras[j])) {
                            cruzadas.put(palabras[j], new TreeSet<>(Arrays.asList(i)));
                        }
                        else {
                            TreeSet<Integer> aux = cruzadas.get(palabras[j]);
                            aux.add(i);
                            cruzadas.put(palabras[j], aux);
                        }
                    }
                }
            }

            for (Map.Entry<String, TreeSet<Integer>> entry : cruzadas.entrySet()) {
                System.out.print(entry.getKey());
                for (Integer n : entry.getValue()) {
                    System.out.print(" " + n);
                }
                System.out.println();
            }

            System.out.println("----");
        }

    }

}

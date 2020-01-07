import java.util.*;

/**
 * @author Rubén Saiz
 */

public class p546 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        HashMap<Integer, Integer> alejandro = new HashMap<>();
        HashMap<Integer, Integer> mateo = new HashMap<>();
        ArrayList<Integer> resAlejandro = new ArrayList<>();
        ArrayList<Integer> resMateo = new ArrayList<>();

        int n, cromo;
        int casos = s.nextInt();

        while (casos-- != 0) {
        
            n = s.nextInt();
            for (int i = 0; i < n; i++) {
                cromo = s.nextInt();
                if (alejandro.containsKey(cromo)) {
                    alejandro.put(cromo, alejandro.get(cromo) + 1);
                }
                else alejandro.put(cromo, 1);
            }
            
            n = s.nextInt();
            for (int i = 0; i < n; i++) {
                cromo = s.nextInt();
                if (mateo.containsKey(cromo)) {
                    mateo.put(cromo, mateo.get(cromo) + 1);
                }
                else mateo.put(cromo, 1);
            }
            
            for (Map.Entry<Integer, Integer> entry : alejandro.entrySet()) {
                if (entry.getValue() > 1 && !mateo.containsKey(entry.getKey())) {
                    resAlejandro.add(entry.getKey());
                }
            }
            
            for (Map.Entry<Integer, Integer> entry : mateo.entrySet()) {
                if (entry.getValue() > 1 && !alejandro.containsKey(entry.getKey())) {
                    resMateo.add(entry.getKey());
                }
            }
            
            Collections.sort(resAlejandro);
            Collections.sort(resMateo);
            
            for (int i = 0; i < resAlejandro.size(); i++) {
                System.out.print(resAlejandro.get(i));
                if (i < resAlejandro.size() - 1) System.out.print(" ");
            }
            
            if (resAlejandro.isEmpty()) System.out.println("Nada que intercambiar");
            else System.out.println();
            
            for (int i = 0; i < resMateo.size(); i++) {
                System.out.print(resMateo.get(i));
                if (i < resMateo.size() - 1) System.out.print(" ");
            }
            
            if (resMateo.isEmpty()) System.out.println("Nada que intercambiar");
            else System.out.println();
            
            resMateo.clear();
            resAlejandro.clear();
            alejandro.clear();
            mateo.clear();
            
        }

    }

}

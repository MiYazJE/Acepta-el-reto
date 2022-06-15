import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class p633 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        HashMap<String, Integer> femaleAnimals = new HashMap();
        HashMap<String, Integer> maleAnimals = new HashMap();
        HashSet<String> animals = new HashSet<>();
        int cases, animalsPairsCount, animalsWithoutPairCount ,animalsLeftOverCount;

        while (true) {
            cases = s.nextInt();
            if (cases == 0) break;

            s.nextLine();
            String[] input = s.nextLine().split(" ");

            for (String str : input) {
                String animal = str.substring(0, str.length() - 1);
                Boolean isMale = str.endsWith("o");
                animals.add(animal);

                if (isMale) {
                    Integer malesCount = maleAnimals.containsKey(animal) ? (maleAnimals.get(animal) + 1) : 1;
                    maleAnimals.put(animal, malesCount);
                }
                else {
                    Integer femalesCount = femaleAnimals.containsKey(animal) ? (femaleAnimals.get(animal) + 1) : 1;
                    femaleAnimals.put(animal, femalesCount);
                }
            }

            animalsPairsCount = animalsLeftOverCount = animalsWithoutPairCount = 0;
            
            for (String animal : animals) {
              int malesCount = maleAnimals.containsKey(animal) ? maleAnimals.get(animal) : 0;
              int femalesCount = femaleAnimals.containsKey(animal) ? femaleAnimals.get(animal) : 0;
              if ((femalesCount == 0 || malesCount == 0) && (malesCount != femalesCount)) {
                animalsLeftOverCount++;
              }
              if (femalesCount != 0 && malesCount != 0) {
                animalsPairsCount++;
              }
              if (femalesCount > 1) animalsWithoutPairCount += femalesCount - 1;
              if (malesCount > 1) animalsWithoutPairCount += malesCount - 1;
            }

            System.out.println(
                animalsPairsCount + " " +
                animalsLeftOverCount + " " +
                animalsWithoutPairCount
            );

            femaleAnimals.clear();
            maleAnimals.clear();
            animals.clear();
        }

    }

}

import java.util.Scanner;

public class H {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int year, closestYear;
        Boolean every;
        String firstWork;

        while (s.hasNext()) {
            year = s.nextInt(); s.nextLine();

            closestYear = Integer.MAX_VALUE;
            every = true;
            firstWork = null;

            for (int i = s.nextInt(); i > 0; i--) {
                int currentYear = s.nextInt();
                String currentWork = s.nextLine();
                boolean biggerThanFirstWork = currentYear >= year;
                if (biggerThanFirstWork && (currentYear - year < closestYear)) {
                    firstWork = currentWork;
                    closestYear = currentYear - year;
                }
                every = every && biggerThanFirstWork;
            }

            if (every) System.out.println("TODAS");
            else if (firstWork == null) System.out.println("NINGUNA");
            else System.out.println(firstWork.trim());
        }

    }

}

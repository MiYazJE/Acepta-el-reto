import java.util.Scanner;

public class p112 {

    static int ONE_HOUR = 3600;
    static int ONE_KILOMETTER = 1000;

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        double metters, maxTime, timeSeconds, medianTime, km, timeHours;

        while (true) {

            metters = s.nextInt();
            maxTime   = s.nextInt();
            timeSeconds  = s.nextInt();

            if (metters == 0 && maxTime == 0 && timeSeconds == 0)
                break;

            km = metters / ONE_KILOMETTER;
            timeHours = timeSeconds / ONE_HOUR;
            medianTime = km / timeHours;

            if (metters <= 0 || maxTime <= 0 || timeSeconds <= 0)
                System.out.println("ERROR");
            else if (medianTime < maxTime)
                System.out.println("OK");
            else
                System.out.println(
                        ((medianTime - maxTime) < (0.2 * maxTime))
                            ? "MULTA"
                            : "PUNTOS"
                );

        }

    }

}

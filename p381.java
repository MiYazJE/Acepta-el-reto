import java.util.Scanner;

public class p381 {

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int numPlanetas;
        int[] planetas;
        int dias;

        while (true) {
            numPlanetas = s.nextInt();
            if (numPlanetas == 0) return;
            planetas = new int[numPlanetas];
            for (int i = 0; i < numPlanetas; i++) planetas[i] = s.nextInt();
            dias = lcm(planetas[0], planetas[1]);
            for (int i = 2; i < numPlanetas; i++) dias = lcm(dias, planetas[i]);
            System.out.println( dias );
        }

    }

}

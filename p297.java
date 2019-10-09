import java.util.Scanner;

public class p297 {

    static long calculate(long num, String m) {
        switch (m) {
            case "o":  return num;
            case "da": return num * 10;
            case "h":  return num * 100;
            case "k":  return num * 1_000;
            case "M":  return num * 1_000_000;
            case "G":  return num * 1_000_000_000;
        }
        return 0;
    }

    static String calculateM(long num) {
        if (num % 1_000_000_000 == 0) return (num / 1_000_000_000) + " G";
        if (num % 1_000_000 == 0) return (num / 1_000_000) + " M";
        if (num % 1_000 == 0) return (num / 1_000) + " k";
        if (num % 100 == 0) return (num / 100) + " h";
        if (num % 10 == 0) return (num / 10) + " da";
        return num + " o";
    }

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        long num, res;
        String m, output;
        int casos = s.nextInt();

        while (casos-- != 0) {
            res = 0L;
            while (true) {
                num = s.nextLong();
                if (num == 0) break;
                m = s.next();
                res += calculate(num, m);
            }
            output = calculateM(res);
            System.out.println( output );
        }

    }

}

import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

public class p519 {

    public static void ini(String[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = "";
    }
    
    public static boolean contieneVertical(String[][] arr, int f) {
        for (int c = 0; c < arr[0].length; c++) {
            if (arr[f][c].contains("1") || arr[f][c].contains("3") || arr[f][c].contains("2"))
                return true;
            if (arr[f+1][c].contains("8") || arr[f+1][c].contains("7") || arr[f+1][c].contains("9"))
                return true;
        }

        return false;
    }

    public static boolean contieneDiagonalArriba(String[][] arr, int f, int c) {
        return (c < arr[0].length-1 && (arr[f+1][c].contains("7") || arr[f][c+1].contains("3")));
    }

    public static boolean contieneDiagonalAbajo(String[][] arr, int f, int c) {
        return (c < arr[0].length-1 && (arr[f][c].contains("1") || arr[f+1][c+1].contains("9")));
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int f, c, posF, posC, num, pos;
        String[][] arr;
        String numeros;

        while (true) {

            f = s.nextInt();
            c = s.nextInt();
            if (f == 0 && c == 0) break;

            posF = s.nextInt(); posF--;
            posC = s.nextInt(); posC--;
            arr = new String[f][c];
            ini(arr);
            arr[posF][posC] = "O";

            numeros = s.next(); pos = 0;
            num = Integer.parseInt(""+numeros.charAt(pos++));
            while (num != 5) {

                switch (num) {
                    case 1: arr[--posF][--posC] += "1 "; break;
                    case 2: arr[--posF][posC]   += "2 "; break;
                    case 3: arr[--posF][++posC] += "3 "; break;
                    case 4: arr[posF][--posC]   += "4 "; break;
                    case 6: arr[posF][++posC]   += "6 "; break;
                    case 7: arr[++posF][--posC] += "7 "; break;
                    case 8: arr[++posF][posC]   += "8 "; break;
                    case 9: arr[++posF][++posC] += "9 ";
                }

                num = Integer.parseInt(""+numeros.charAt(pos++));
            }

            for (int i = 0; i < f; i++) {

                if (i == 0) {
                    for (int j = 0; j < c * 2 + 1; j++) {
                        if (j == 0 || j == c * 2) System.out.print("+");
                        else System.out.print("-");
                    }
                    System.out.println();
                }

                for (int j = 0; j < c; j++) {
                    if (j == 0) System.out.print("|");
                    System.out.print( (arr[i][j].isEmpty()) ? "." : "O" );
                    if (arr[i][j].contains("4") || (j + 1 < c && arr[i][j+1].contains("6"))) System.out.print("-");
                    else if (j < c - 1) System.out.print(" ");
                    if (j == c - 1) System.out.print("|");
                }

                if (i < f - 1 && contieneVertical(arr, i)) {
                    System.out.println();
                    for (int j = 0; j < c; j++) {
                        if (j == 0) System.out.print("|");
                        if (arr[i+1][j].contains("8") || arr[i][j].contains("2")) System.out.print("|");
                        else System.out.print(" ");
                        if (j < c - 1) {
                            if (contieneDiagonalArriba(arr, i, j) && contieneDiagonalAbajo(arr, i, j)) System.out.print("X");
                            else if (contieneDiagonalAbajo(arr, i, j)) System.out.print("\\");
                            else if (contieneDiagonalArriba(arr, i, j)) System.out.print("/");
                            else System.out.print(" ");
                        }
                        if (j == c - 1) System.out.print("|");
                    }
                }
                else if (i < f - 1) {
                    for (int j = 0; j < c + (c-1); j++) {
                        if (j == 0) System.out.print("\n|");
                        System.out.print(" ");
                        if (j == (c + c - 2)) System.out.print("|");
                    }
                }

                if (i == f - 1) {
                    System.out.println();
                    for (int j = 0; j < c * 2 + 1; j++) {
                        if (j == 0 || j == c * 2) System.out.print("+");
                        else System.out.print("-");
                    }
                    System.out.println();
                }
                else System.out.println();
            }

        }

    }

}

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String a = scanner.next();
            String b = scanner.next();
            String c = scanner.next();


            if (rim(a) != rim(c)) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                break;
            }

            boolean rim= rim(a);


            int a1 = toInt(a);
            int c1 = toInt(c);


            if (a1 > 10 || c1 > 10 || a1 < 1 || c1 < 1) {
                System.out.println("throws Exception //цифры только от 1 до 10");
                break;
            }

            int s = 0;
            switch (b) {
                case "+":
                    s = a1 + c1;
                    break;
                case "-":
                    s = a1 - c1;
                    break;
                case "*":
                    s = a1 * c1;
                    break;
                case "/":
                    s = a1 / c1;
                    break;
                default:
                    System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    return;
            }

            if (rim) {
                if (s <= 0) {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                } else {
                    System.out.println(rim(s));
                }
            } else {
                System.out.println(s);
            }
        }
    }

    private static int toInt(String q) {
        switch (q) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return Integer.parseInt(q);
        }
    }

    private static String rim(int q) {
        String[] q1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] q2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] q3 = {"", "C"};

        return q3[q / 100] + q2[(q % 100) / 10] + q1[q % 10];
    }

    private static boolean rim(String q) {
        switch (q) {
            case "I":
            case "II":
            case "III":
            case "IV":
            case "V":
            case "VI":
            case "VII":
            case "VIII":
            case "IX":
            case "X":
                return true;
            default:
                return false;
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            try {
                System.out.println(calc(input));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        String a = parts[0];
        String b = parts[1];
        String c = parts[2];

        if (rim(a) != rim(c)) {
            throw new Exception("т.к. используются одновременно разные системы счисления");
        }

        boolean rim = rim(a);

        int a1 = toInt(a);
        int c1 = toInt(c);

        if (a1 > 10 || c1 > 10 || a1 < 1 || c1 < 1) {
            throw new Exception("цифры только от 1 до 10");
        }

        int s = calculate(a1, b, c1);

        if (rim) {
            if (s <= 0) {
                throw new Exception("т.к. в римской системе нет отрицательных чисел");
            }
            return rim(s);
        } else {
            return String.valueOf(s;
        }
    }

    private static int toInt(String str) {
        switch (str) {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: return Integer.parseInt(str);
        }
    }

    private static String rim(int num) {
        String[] q1= {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] q2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] q3 = {"", "C"};

        return q3[num / 100] + q2[(num % 100) / 10] + q1[num % 10];
    }

    private static boolean rim(String str) {
        switch (str) {
            case "I": case "II": case "III": case "IV": case "V":
            case "VI": case "VII": case "VIII": case "IX": case "X":
                return true;
            default:
                return false;
        }
    }

    private static int calculate(int a, String operator, int b) throws Exception {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("деление на ноль нельзя");
                }
                return a / b;
            default:
                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
}

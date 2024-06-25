import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                String input = scanner.nextLine();
                String[] parts = input.split(" ");

                if (parts.length != 3) {
                    throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }

                String a = parts[0];
                String b = parts[1];
                String c = parts[2];

                if (isRoman(a) != isRoman(c)) {
                    throw new Exception("т.к. используются одновременно разные системы счисления");
                }

                boolean isRoman = isRoman(a);

                int a1 = toInt(a);
                int c1 = toInt(c);

                if (a1 > 10 || c1 > 10 || a1 < 1 || c1 < 1) {
                    throw new Exception("цифры только от 1 до 10");
                }

                int result = calculate(a1, b, c1);

                if (isRoman) {
                    if (result <= 0) {
                        throw new Exception("т.к. в римской системе нет отрицательных чисел");
                    }
                    System.out.println(toRoman(result));
                } else {
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    private static String toRoman(int num) {
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C"};

        return hundreds[num / 100] + tens[(num % 100) / 10] + units[num % 10];
    }

    private static boolean isRoman(String str) {
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
                    throw new ArithmeticException("деление на ноль");
                }
                return a / b;
            default:
                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
}

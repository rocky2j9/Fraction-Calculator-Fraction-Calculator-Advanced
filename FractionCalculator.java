import java.util.*;

public class FractionCalculator {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        introduction();
        calculator();

    }

    public static String getOperation() {
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operand = input.nextLine();

        while ((!operand.equals("+")) && !operand.equals("-") && !operand.equals("/") && !operand.equals("*") && !operand.equals("=") && (!operand.equalsIgnoreCase("q"))) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            operand = input.nextLine();
        }
        if (operand.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        return operand;
    }

    public static boolean isNumber(String input) {
        if (input.matches("-?\\d+")) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean validFraction(String input) {
        input = input.trim();
        if (input.contains("/")) {
            String[] fracParts = input.split("/");
            String numerator = fracParts[0];
            String denominator = fracParts[1];
            if ((isNumber(numerator) && isNumber(denominator)) && (Integer.parseInt(denominator) != 0) && ((Integer.parseInt(denominator) > 0))) {
                return true;
            }else {
                return false;
            }
        }else {
            return isNumber(input);
        }
    }

    public static Fraction getFraction() {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String frac = input.nextLine();

        while (!validFraction(frac)) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            frac = input.nextLine();
        }

        if (frac.contains("/")) {
            String[] fracParts = frac.split("/");
            int numerator = Integer.parseInt(fracParts[0]);
            int denominator = Integer.parseInt(fracParts[1]);
            return new Fraction(numerator, denominator);
        }else {
            return new Fraction(Integer.parseInt(frac));
        }
    }

    public static void introduction() {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter  your fractions in the form a/b, where a and b are integers.");
    }


    public static void calculator() {
        while(true) {
            System.out.println("------------------------------------------------------------------------------");
            String operand = getOperation();
            Fraction frac1 = getFraction();
            Fraction frac2 = getFraction();
            Fraction result;

            if (!operand.equals("=")) {
                System.out.print(frac1 + " " + operand + " " + frac2 + " " + "= ");
                if (operand.equals("+")) {
                    result = frac1.add(frac2);
                    if (result.getDenominator() == 1) {
                        System.out.println(result.getNumerator());
                    }else {
                        System.out.println(result);
                    }
                }else if (operand.equals("-")) {
                    result = frac1.subtract(frac2);
                    if (result.getDenominator() == 1) {
                        System.out.println(result.getNumerator());
                    }else {
                        System.out.println(result);
                    }
                }else if (operand.equals("*")) {
                    result = frac1.multiply(frac2);
                    if (result.getDenominator() == 1) {
                        System.out.println(result.getNumerator());
                    }else {
                        System.out.println(result);
                    }
                }else if (operand.equals("/")) {
                    result = frac1.divide(frac2);
                    if (result.getDenominator() == 1) {
                        System.out.println(result.getNumerator());
                    }else {
                        System.out.println(result);
                    }
                }
            }else {
                System.out.print(frac1 + " " + operand + " " + frac2 + " " + "is ");
                System.out.println(frac1.equals(frac2));
            }
        }

    }

































}

import java.util.*;

public class  FractionCalculatorAdvanced {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        introduction();
        calculator();
    }

    public static boolean validOperand(String operand) {
        if ( (!operand.equals("+")) && (!operand.equals("-")) && (!operand.equals("/")) &&
                (!operand.equals("*")) && (!operand.equals("=")) ) {
            return false;
        }
        return true;
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

    public static Fraction getFraction(String fracInput) {

        String[] fracStr = fracInput.split("/",2);
        if (fracStr.length == 1) {
            return new Fraction(Integer.parseInt(fracStr[0]));
        } else {
            return new Fraction(Integer.parseInt(fracStr[0]), Integer.parseInt(fracStr[1]));
        }
    }

    public static void introduction() {
        System.out.println("This program is fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit");
        System.out.println("Valid operations are of the form \"[FRAC] [OPERATION] [FRAC]\"");
        System.out.println("[FRAC] can be either a single integer or two integers separately");
        System.out.println("[OPERATION] can be +, -, *, / or =");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static boolean isQuit(String[] singleLine) {
        if (singleLine[0].equalsIgnoreCase("q")) {
            return true;
        }
        return false;
    }


    public static void calculator() {
        while (true) {
            System.out.print("Enter an operation (q to quit): ");
            String single = input.nextLine();

            String[] singleLine = single.split("\\s+", 3);

            if (isQuit(singleLine)) {
                System.exit(0);
            }

            if (singleLine.length == 3) {

                String fracA = singleLine[0];
                String operand = singleLine[1];
                String fracB = singleLine[2];

                if (validFraction(fracA) && validOperand(operand) && validFraction(fracB)) {
                    Fraction frac1 = getFraction(fracA);
                    Fraction frac2 = getFraction(fracB);
                    Fraction result;

                    if (!operand.equals("=")) {
                        System.out.print(frac1 + " " + operand + " " + frac2 + " " + "= ");
                        if (operand.equals("+")) {
                            result = frac1.add(frac2);
                            if (result.getDenominator() == 1) {
                                System.out.println(result.getNumerator());
                            } else {
                                System.out.println(result);
                            }
                        } else if (operand.equals("-")) {
                            result = frac1.subtract(frac2);
                            if (result.getDenominator() == 1) {
                                System.out.println(result.getNumerator());
                            } else {
                                System.out.println(result);
                            }
                        } else if (operand.equals("*")) {
                            result = frac1.multiply(frac2);
                            if (result.getDenominator() == 1) {
                                System.out.println(result.getNumerator());
                            } else {
                                System.out.println(result);
                            }
                        } else if (operand.equals("/")) {
                            result = frac1.divide(frac2);
                            if (result.getDenominator() == 1) {
                                System.out.println(result.getNumerator());
                            } else {
                                System.out.println(result);
                            }
                        }
                    } else {
                        System.out.print(frac1 + " " + operand + " " + frac2 + " " + "is ");
                        System.out.println(frac1.equals(frac2));
                    }
                } else {
                    System.out.println("Invalid operation. Must be [FRAC] [OPERATION] [FRAC] :");
                }
            }else {
                System.out.println("Invalid operation. Must be [FRAC] [OPERATION] [FRAC] :");
            }
        }
    }

































}

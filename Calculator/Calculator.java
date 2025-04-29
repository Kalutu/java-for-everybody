import java.util.Scanner;

class Calculator {
    public static void RunCalculator(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        String firstInput = input.next();
        
        System.out.print("Enter the second number: ");
        String secondInput = input.next();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = input.next().charAt(0);

        Number num1 = parseNumber(firstInput);
        Number num2 = parseNumber(secondInput);

        if (num1 == null || num2 == null) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        double result;

        switch (operator) {
            case '+':
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case '-':
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case '*':
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case '/':
                if (num2.doubleValue() == 0) {
                    System.out.println("Error: Division by zero");
                    return;
                }
                result = num1.doubleValue() / num2.doubleValue();
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }

    public static Number parseNumber(String input) {
        try {
            if (input.contains(".")) {
                return Double.parseDouble(input);
            } else {
                return Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

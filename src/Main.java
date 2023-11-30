import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static String calc(String input) {
        String[] mathActions = {"+", "-", "/", "*"};
        String chosenAction = "";

        for (String mathAction : mathActions) {
            if (input.contains(mathAction)) {
                chosenAction = mathAction;
                break;
            }
        }

        if (chosenAction.isEmpty()) {
            throw new IllegalArgumentException();
        }

        input = input.replaceAll("\\s+", "");
        String[] splittedInput = input.split(Pattern.quote(chosenAction));

        if (splittedInput.length != 2) {
            throw new IllegalArgumentException();
        }

        String firstNumberS = splittedInput[0];
        String secondNumberS = splittedInput[1];

        Converter converter = new Converter();

        if (converter.isRoman(firstNumberS) != converter.isRoman(secondNumberS)) {
            throw new IllegalArgumentException();
        }

        boolean isRoman = converter.isRoman(firstNumberS);
        int firstNumber;
        int secondNumber;

        if (isRoman) {
            firstNumber = converter.romanToInt(firstNumberS);
            secondNumber = converter.romanToInt(secondNumberS);
        } else {
            firstNumber = Integer.parseInt(firstNumberS);
            secondNumber = Integer.parseInt(secondNumberS);
        }

        if (firstNumber < 1 || secondNumber < 1 || firstNumber > 10 || secondNumber > 10) {
            throw new IllegalArgumentException();
        }

        int result_arabic = switch (chosenAction) {
            case ("+") -> firstNumber + secondNumber;
            case ("-") -> firstNumber - secondNumber;
            case ("*") -> firstNumber * secondNumber;
            case ("/") -> firstNumber / secondNumber;
            default -> throw new IllegalArgumentException();
        };

        String result;

        if (isRoman) {
            if (result_arabic < 1) {
                throw new IllegalArgumentException();
            }
            result = converter.intToRoman(result_arabic);
        } else {
            result = Integer.toString(result_arabic);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.print(result);
    }
}
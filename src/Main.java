import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (true) {
            conversionToNumber(userInput);
        } else System.out.println("Ошибка!!!");
    }


    public static void conversionToNumber(String userInput) {
        String numberUser1 = "";
        String numberUser2 = "";
        boolean check = true;
        char operation = '@';

        if (romanCheck(userInput) == true) {
            for (int i = 0; i <= userInput.length() - 1; i++) {
                if (userInput.charAt(i) == '+' || userInput.charAt(i) == '-' || userInput.charAt(i) == '*' || userInput.charAt(i) == '/') {
                    operation = userInput.charAt(i);
                } else if (operation == '@') {
                    numberUser1 = numberUser1 + userInput.charAt(i);
                } else if (operation != '@') {
                    numberUser2 = numberUser2 + userInput.charAt(i);
                }
            }
            check = true;
        } else if (romanCheck(userInput) == false) {
            for (int i = 0; i <= (userInput.length() - 1); i++) {
                if (isNumber(String.valueOf(userInput.charAt(i))) == true && operation == '@') {
                    numberUser1 = numberUser1 + userInput.charAt(i);
                }
                if (userInput.charAt(i) == '+' || userInput.charAt(i) == '-' || userInput.charAt(i) == '*' || userInput.charAt(i) == '/') {
                    operation = userInput.charAt(i);
                }
                if (isNumber(String.valueOf(userInput.charAt(i))) == true && operation != '@') {
                    numberUser2 = numberUser2 + userInput.charAt(i);
                }
            }
            check = false;
        }

        if (romanCheck(numberUser1) == isNumber(numberUser2) || romanCheck(numberUser2) == isNumber(numberUser1)) {
            System.out.println("Ошибка!!!");
        } else {
            if (check == true) {
                System.out.println(convertNumToRoman(calc(romanToNumber(numberUser1), romanToNumber(numberUser2), operation)));
            } else {
                if (numberCheck(stringToNumber(numberUser1)) == true && numberCheck(stringToNumber(numberUser2)) == true) {
                    System.out.println(calc(stringToNumber(numberUser1), stringToNumber(numberUser2), operation));
                } else {
                    System.out.println("Числа не должны превышать 10!!!");
                }
            }
        }


    }

    public static int calc(int number1, int number2, char operation) {
        int result = 0;

        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                System.out.println("Такого оператора нет!!!");
        }
        return result;
    }

    public static String convertNumToRoman(int numArabian) {
        if (numArabian > 0) {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                    "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                    "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            final String s = roman[numArabian];
            return s;
        } else {
            System.out.println();
            return "Отрицательных чисел нету в римских цифрах";
        }
    }

    public static int romanToNumber(String roman) {

        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        return 0;
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int stringToNumber(String str) {
        Integer number = new Integer(str);
        return number;
    }

    public static boolean numberCheck(int num) {
        if (0 <= num && num <= 10)
            return true;
        else return false;
    }

    public static boolean romanCheck(String userInput) {
        boolean checToRoman = false;
        char[] roman = {'I', 'V', 'X'};

        for (int i = 0; i <= (userInput.length() - 1); i++) {
            for (int j = 0; j <= roman.length - 1; j++) {
                if (userInput.charAt(i) == roman[j]) {
                    checToRoman = true;
                    break;
                }
            }
        }
        return checToRoman;
    }
}
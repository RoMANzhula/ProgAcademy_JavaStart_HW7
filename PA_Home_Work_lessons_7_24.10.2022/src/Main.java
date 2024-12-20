public class Main {
    public static void main(String[] args) {
        System.out.println("Factorial for your number is: " + getFactorial(0));// task 0
        System.out.println("-----------------------------------------------");
        System.out.println("Factorial for your number is: " + getFactorialRecursion(5));// task 0.5
        System.out.println("-----------------------------------------------");
        System.out.println(returnAnswer('n', "Scanner is nice", "ScaNNer is Nice"));// task 1
        System.out.println("-----------------------------------------------");
        int[] array = {2, 2, 3, 4, 5};
        System.out.println(returnArithmeticMean(array));// task 2
        System.out.println("-----------------------------------------------");
        System.out.println(returnNumber("boo1.24a12312312"));// task 3
        System.out.println("-----------------------------------------------");
        System.out.println(returnNumberWithStar("only text1. 8"));// task 3
        System.out.println("-----------------------------------------------");
        System.out.println(findNumber("boo1.24a12312312"));// task 3
        System.out.println("-----------------------------------------------");
        System.out.println(nextNumber("only text"));// task 3

    }

    public static long getFactorial(int numberForFactorial) {
        long result = 1;
        for (int i = 1; i <= numberForFactorial; i++) {
            result = result * i;
        }
        return result;
    }

    public static long getFactorialRecursion(int numberForFactorial) {
        if (numberForFactorial <= 1) {
            return 1;
        } else {
            return numberForFactorial * getFactorialRecursion(numberForFactorial - 1);
        }
    }

    public static String returnAnswer(char ch, String str1, String str2) {
        char[] charsFromStr1 = str1.toLowerCase().toCharArray();
        char[] charsFromStr2 = str2.toLowerCase().toCharArray();
        char repeat = 'n';
        int counterStr1 = 0;
        int counterStr2 = 0;
        for (char elementCharsFromString : charsFromStr1) {
            if (elementCharsFromString == repeat) {
                counterStr1++;
            }
        }
        for (char elementCharsFromString : charsFromStr2) {
            if (elementCharsFromString == repeat) {
                counterStr2++;
            }
        }
        if (counterStr1 == counterStr2) {
            return "Yes, char 'n' in two strings have the same number of entries.";
        } else {
            return "No, char 'n' in two strings haven't the same number of entries.";
        }
    }

    public static double returnArithmeticMean(int[] array) {
        double arithmeticMean = 0;
        for (int i = 0; i < array.length; i++) {
            arithmeticMean += array[i];
        }
        return arithmeticMean / array.length;
    }

    public static String returnNumber(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String zero = "0";

        for (char chNum = '0'; chNum <= (int) '9'; chNum++) {
            if (str.contains(Character.toString(chNum))) {
                for (char sym : str.toCharArray()) {
                    if (sym == '.') {
                        break;
                    } else if (sym == chNum) {
                        stringBuilder.append(sym);
                    }
                }
            }
        }
        if (stringBuilder.isEmpty()) {
            stringBuilder.append(zero);
        }
        return String.valueOf(stringBuilder);
    }

    public static String returnNumberWithStar(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charsStr = str.toCharArray();
        String result;
        for (char symbol : charsStr) {
            if (symbol >= '0' && symbol <= '9') {
                stringBuilder.append(symbol);
            } else if (stringBuilder.length() > 0 && symbol == '.' && stringBuilder.indexOf(".") == -1) {
                stringBuilder.append(symbol);
            } else if (!stringBuilder.isEmpty()) {
                result = "" + Double.parseDouble(stringBuilder.toString());
                if (result.endsWith("0")) {
                    return result.substring(0, result.length() - 2);
                } else {
                    return result;
                }
            }
        }
        return "0";
    }

    //solution of a groupmate
    private static double findNumber(String text) {
        char[] chars = text.toCharArray();
        StringBuilder number = new StringBuilder();
        for (var c : chars) {
            if (c >= '0' && c <= '9') {
                number.append(c);
            } else if (!number.isEmpty() && c == '.' && number.indexOf(".") == -1) {
                number.append(c);
            } else if (!number.isEmpty()) {
                return Double.parseDouble(number.toString());
            }
        }
        return 0;
    }

    public static String nextNumber(String str) {
        StringBuilder result = new StringBuilder();
        char[] strArray = str.toCharArray();
        boolean numberIsFound = false;
        boolean decimalPointIsFound = false;
        int decimalPointPos = 0;
        for (int i = 0; i < strArray.length; ++i) {
            //looking for first digit
            if (!numberIsFound) {
                if ((strArray[i] >= '0') && (strArray[i] <= '9')) {
                    result.append(strArray[i]);
                    numberIsFound = true;
                }
            }
            //looking for first decimal point
            else if (numberIsFound && !decimalPointIsFound && (strArray[i] == '.')) {
                //if first point in the string is in the end, then ignore it
                if (i == (strArray.length - 1)) {
                    //since this is the last symbol in string
                    break;
                } else {
                    result.append(strArray[i]);
                    decimalPointPos = i;
                    decimalPointIsFound = true;
                }
            }
            //looking for the end of given number
            else if ((decimalPointIsFound || numberIsFound)
                    && ((strArray[i] < '0') || (strArray[i] > '9'))) {
                //if any non-number symbol is write after decimal point --> ignore it, delete point
                if ((i - decimalPointPos) == 1) {
                    result.deleteCharAt(result.length() - 1);
                    break;
                }
                //if not --> ignore the symbol
                else {
                    break;
                }
            }
            //processing digits
            else if (numberIsFound && (strArray[i] >= '0') && (strArray[i] <= '9')) {
                result.append(strArray[i]);
            }
        }
        if (result.length() == 0) {
            return "No digits found";
        } else {
            return result.toString();
        }
    }
}
//0. Написати ітеративний метод, який повертає факториал заданого числа.
//0,5. Написати рекурсивний метод, який повертає факториал заданого числа.
//1. Написати метод, який приймає на вхід дві строки і символ n і повертає відповідь на запитання, містить чи обе строки одинакове кол-во входження символу n.
//2. Написати метод, який приймає на вхід числовий масив і повертає середньо арифметичне по нему.
//3. Написати метод, який приймає на вхід рядок з числом(і не тільки), і повертає користувачеві число, що зберігається в рядку.
// Наприклад:
// "boo123 adf " -> 123
// " 12 .1231" -> 12
// "only text" -> 0

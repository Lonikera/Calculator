import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    private static final Range RANGE = new Range(1, 10);
    private static final List<String> SINGS = Arrays.asList("+", "-", "/", "*");
    private static final Predicate<String> IS_SING = SINGS::contains;
    private static final Predicate<Integer> IS_DIGIT_IN_RANGE = digit -> digit > RANGE.getMin() && digit <= RANGE.getMax();

    public static String calc(String input) throws IllegalAccessException {
        var arrayOfExpression = input.split(" ");

        checkExpression(arrayOfExpression);
        var sign = checkAndGetSing(arrayOfExpression[1]);
        var first = arrayOfExpression[0];
        var second = arrayOfExpression[2];

        int firstNumber;
        int secondNumber;
        boolean isArabDigit;
        try {
            firstNumber = Integer.parseInt(first);
            secondNumber = Integer.parseInt(second);
            isArabDigit = true;
        } catch (Exception e) {
            firstNumber = Converter.toArab(first);
            secondNumber = Converter.toArab(second);
            isArabDigit = false;
        }

        checkDigitRange(firstNumber, secondNumber);

        var result = Expression.count(firstNumber, secondNumber, sign);
        return isArabDigit
                ? String.valueOf(result)
                : Converter.toRome(result);
    }

    private static void checkDigitRange(int firstNumber, int secondNumber) {
        if (!IS_DIGIT_IN_RANGE.test(firstNumber) && !IS_DIGIT_IN_RANGE.test(secondNumber)) {
            throw new IllegalArgumentException("Диапазон чисел должен быть в " + RANGE.getRange());
        }
    }

    private static String checkAndGetSing(String s) {
        if (IS_SING.test(s)) {
            return s;
        }
        throw new IllegalArgumentException("Введен неверный знак");
    }

    private static void checkExpression(String[] arrayOfExpression) {
        if (arrayOfExpression.length != 3) {
            throw new IllegalArgumentException("Неправильно введено выражение");
        }
    }

}
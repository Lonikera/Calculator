public class Converter {

    private static final String[] strings = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static Integer toArab(String s) throws IllegalAccessException {
        for (int i = 0; i < strings.length; i++) {
            if (s.equals(strings[i])) {
                return i + 1;
            }
        }
        throw new IllegalAccessException("Некорректное введение римских цифр");
    }
    public static String toRome(int a) {
        String result = "";
        while (a >= 100) {
            result += "C";
            a -= 100;
        }
        if (a >= 90) {
            result += "XC";
            a -= 90;
        }
        while (a >= 50) {
            result += "L";
            a -= 50;
        }
        if (a >= 40) {
            result += "XL";
            a -= 40;
        }
        while (a >= 10) {
            result += "X";
            a -= 10;
        }
        if (a == 9) {
            result += "IX";
            a -= 9;
        }
        while (a >= 5) {
            result += "V";
            a -= 5;
        }
        if (a == 4) {
            result += "IV";
            a -= 4;
        }
        while (a > 0) {
            result += "I";
            a -= 1;
        }
        return result;
    }
}
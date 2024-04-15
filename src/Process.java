import java.util.Scanner;

public class Process {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        var result = Main.calc(scanner.nextLine());
        System.out.println("Результат равен: " + result);
    }
}
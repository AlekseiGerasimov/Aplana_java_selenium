package Pack_calculate;

/**
 * Подключение библиотек
 */
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Герасимов А.А.
 * @since 1.0
 * Точка входа в приложение
 * @param choice позволяет динамически выбирать необходимое действие
 */
public class OperationClass {
    public static void main(String args[]){
        int choice;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        while(Boolean.TRUE) {
        System.out.println("Click for use function of calculator - 1");
        System.out.println("Click for use function of array - 2");
        System.out.println("Click for close app - 3");
            choice = scanner.nextInt();
            while (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Insert correct number");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println("Insert two number:");
                    Calculator calc = new Calculator(scanner.nextDouble(), scanner.nextDouble());
                    calc.operations();
                    break;
                case 2:
                    System.out.println("Enter the amount of words");
                    choice = scanner.nextInt();
                    String[] str = new String[choice];
                    System.out.println("Enter words:");
                    for (int i = 0; i < choice; ++i) {
                        str[i] = scanner.next();
                    }
                    Array arr = new Array(str);
                    arr.findElements();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}

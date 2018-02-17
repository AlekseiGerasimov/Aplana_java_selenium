package Pack_calculate;

import java.util.Scanner;


/**
 * @author Герасимов А.А.
 * @since 1.0
 * Класс для выполнения арифмитических действий
 */
public class Calculator {
    /**
     * Конструкторы
     */
    Calculator(){
        this(0,0);
    }
    Calculator(double a,double b){
        this.a = a;
        this.b = b;
    }
    /**
     * Метод выполняющий арифмитические действия в зависимости от выбора пользователя
     */
    public void operations(){
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert operation:");
            System.out.println("press 1 for +");
            System.out.println("press 2 for -");
            System.out.println("press 3 for /");
            System.out.println("press 4 for *");
            int choice = scanner.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4)
                System.out.println("Insert correct number");
            switch (choice) {
                case 1:
                    System.out.println("Result: " + String.format("%.4f", a + b));
                    break;
                case 2:
                    System.out.println("Result: " + String.format("%.4f", a - b));
                    break;
                case 3:
                    System.out.println("Result: " + String.format("%.4f", a / b));
                    break;
                case 4:
                    System.out.println("Result: " + String.format("%.4f", a * b));
                    break;
            }
        }
    }
    private double a;
    private double b;
}

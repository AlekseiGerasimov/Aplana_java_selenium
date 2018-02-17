package Array;

import java.util.Scanner;

public class ArrayClass {
    public static void main(String []args){
        System.out.println("Insert x and y");
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextInt();
        double y = scanner.nextInt();
        System.out.println("3(x+2x-y)/2x = "+ (3 * (x + 2*x - y)) / (2*y));

        StringBuffer str = new StringBuffer("Я хороший разработчик автотестов");
        str.replace(2,9,"пока не хороший");
        System.out.println(str);
        System.out.println(str.substring(18,29));


    }
}

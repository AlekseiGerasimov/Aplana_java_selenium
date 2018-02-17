package Pack_calculate;

/**
 * @author Герасимов А.А.
 * @since 1.0
 * Класс для нахождения самого длинного числа
 */
public class Array {
    /**
     * Конструкторы
     */
    Array(){
        str = null;
    }
    Array(String []str){
        this.str = str;
    }
    /**
     * Метод выполняющий поиск и вывод на экран самого длинного слова
     */
    void findElements(){
        System.out.print("Result is: ");
        if(str.length == 0) {
            System.out.println("You insert 0 words");
            return;
        }
        int length = 0;
        for(String s : str){
            if(length < s.length())
                length = s.length();
        }
        for(String s : str){
            if(length == s.length())
                System.out.print(s + " ");
        }
        System.out.println();
    }
    private String str[];
}

package Pack_calculate;

public class Array {
    Array(){
        str = null;
    }
    Array(String []str){
        this.str = str;
    }
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

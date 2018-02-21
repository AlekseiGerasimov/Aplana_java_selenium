package Mypackage;

public class MainClass {

    public static void main(String []args){
        Iparent[] y = new Iparent[2];
        y[0] = new Candy(100,100,"gdgd");
        y[1] = new Jellybean(200,300,"fwqfqwf");
        GiftClass gif = new GiftClass(y);
        gif.info();
        System.out.println();
        gif.remove_by_name("Candy");
        gif.info();
        System.out.println();
        gif.add("Candy",10000,20000,"jol");
        System.out.println(gif.get_sum_price());
        System.out.println(gif.get_sum_weight());
    }

}

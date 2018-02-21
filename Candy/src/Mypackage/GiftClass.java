package Mypackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class GiftClass {

    public GiftClass(Iparent sw[]) {
        this.sw = new ArrayList<>(sw.length);
        for(Iparent i : sw){
            this.sw.add(i);
        }
    }

    double getWeight(){
        double sumweight = 0;
        for(Iparent i : sw){
            sumweight+=i.getWeight();
        }
        return sumweight;
    }
    double getPrice(){
        double price = 0;
        for(Iparent i : sw){
            price+=i.getPrice();
        }
        return price;
    }
    GiftClass info(){
        for(Iparent i : sw){
            System.out.println(i.getName() + " " + i.getPrice() + " " + i.getWeight() + " " + i.getId());
        }
        return this;
    }
    void add(Iparent obj){
        sw.add(obj);
    }
    void add(String name,double price,double weight,String id){
        try {
            if(weight <= 0 || price <=0)
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException  ex){
            System.err.println("Weight or price can't be less or equal 0");
            System.exit(-100);
        }
        if(name == "Candy") {
            Iparent candy = new Candy(weight, price, id);
            sw.add(candy);
            return;
        }
        else if(name == "Jellybean") {
            Iparent jellybean = new Jellybean(weight, price, id);
            sw.add(jellybean);
            return;
        }
        else
            System.out.println("Продукта " + name + " у нас нет в продаже");
    }

    double get_sum_weight(){
        double sum = 0;
        for(Iparent i : sw){
            sum+=i.getWeight();
        }
        return sum;
    }

    double get_sum_price(){
        double sum = 0;
        for(Iparent i : sw){
            sum+=i.getPrice();
        }
        return sum;
    }

    void remove_by_name(String name){
        if(name!="Candy" && name!="Jellybean")
            return;
        if(name == "Candy"){
            for(Iparent i : sw){
                if(i instanceof Candy)
                    sw.remove(i);
            }
            return;
        }
        if(name == "Lellybean"){
            for(Iparent i : sw){
                if(i instanceof Jellybean)
                    sw.remove(i);
            }
            return;
        }
    }

    void remove_by_parameters(String name,double price){
        for(Iparent i : sw){
            if(i.getName() == name && i.getPrice() == price)
                sw.remove(i);
        }
    }

    @Override
    public String toString() {
        return "Это подарок вашей мечты, для получения информации о содержании вызовите info()";
    }




    private ArrayList<Iparent> sw;
}

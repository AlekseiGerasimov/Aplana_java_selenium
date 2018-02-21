package Mypackage;

interface Iparent{
    double getWeight();
    double getPrice();
    String getId();
    String getName();
    void setWeight(double weight);
    void setPrice(double price);
}

class Candy implements Iparent{
    public Candy() {
        this(0,0,null);
    }
    public Candy(double weight, double price, String id) {
        try {
            if (weight <= 0 ||  price <= 0)
                throw new IllegalArgumentException();
            this.weight = weight;
            this.price = price;
            this.id = id;
        }
        catch (IllegalArgumentException  ex){
            System.err.println("Wrong arguments Candy");
            System.exit(-100);
        }
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setWeight(double weight) {
        try {
            if(weight <= 0)
                throw new IllegalArgumentException();
            this.weight = weight;
        }
        catch (IllegalArgumentException  ex){
            System.err.println("Weight can't be less or equal 0");
            System.exit(-100);
        }
    }
    @Override
    public void setPrice(double price) {
        try {
            if(price <= 0)
                throw new IllegalArgumentException();
            this.price = price;
        }
        catch (IllegalArgumentException  ex) {
            System.err.println("Weight can't be less or equal 0");
            System.exit(-100);
        }
    }
    private double weight;
    private double price;
    private String id;
    private final String name = "Candy";
}

class Jellybean implements Iparent{
    public Jellybean() {
        this(0,0,null);
    }
    public Jellybean(double weight, double price, String id) {
        try {
            if (weight <= 0 ||  price <= 0)
                throw new IllegalArgumentException();
            this.weight = weight;
            this.price = price;
            this.id = id;
        }
        catch (IllegalArgumentException  ex){
            System.err.println("Wrong arguments Jellybean");
            System.exit(-100);
        }
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setWeight(double weight) {
        try {
            if(weight <= 0)
                throw new IllegalArgumentException();
            this.weight = weight;
        }
        catch (IllegalArgumentException  ex){
            System.err.println("Weight can't be less or equal 0");
            System.exit(-100);
        }
    }
    @Override
    public void setPrice(double price) {
        try {
            if(weight <= 0)
                throw new IllegalArgumentException();
            this.price = price;
        }
        catch (IllegalArgumentException  ex){
            System.err.println("Price can't be less or equal 0");
            System.exit(-100);
        }
    }
    private double weight;
    private double price;
    private String id;
    private final String name = "Jellybean";
}
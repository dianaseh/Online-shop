

public class Clothes  extends Product {
    private String brand  ;
    private String type ;
    private String size ;
    private String color ;
    private String gender ;

    public Clothes(String name, int price, int quantity, String brand, String type, String size, String color, String gender,Seller seller) {
        super(name, price, quantity,seller);
        this.brand = brand;
        this.type = type;
        this.size = size;
        this.color = color;
        this.gender = gender;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

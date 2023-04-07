public class Bag extends Product {
    private String brand ;
    private int size ;
    private String color ;
    private String gender ;
    private int volume ;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Bag(String name, int price, int quantity, String brand, int size, String color, String gender, int volume,Seller seller) {
        super(name, price, quantity,seller);
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.gender = gender;
        this.volume = volume;
    }
}

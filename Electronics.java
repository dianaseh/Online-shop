import java.util.*;

public class Electronics extends Product  {
    private String brand;
    private String type;
    private String size ;
    private String color ;
    private String batteryLife ;
    private boolean hasGuarantee ;

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

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

    public void setHasGuarantee(boolean hasGuarantee) {
        this.hasGuarantee = hasGuarantee;
    }

    public Electronics(String name, int price, int quantity, String brand, String type, String size, String color, String batteryLife, boolean hasGuarantee,Seller seller) {
        super(name, price, quantity,seller);
        this.brand = brand;
        this.type = type;
        this.size = size;
        this.color = color;
        this.batteryLife = batteryLife;
        this.hasGuarantee = hasGuarantee;
    }
}

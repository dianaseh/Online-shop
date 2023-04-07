import java.time.LocalDate;

public class Grocery  extends Product {
    private String type ;
    private String brand ;
    private double weight;

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    private LocalDate productionDate ;
    private LocalDate expirationDate ;

    public Grocery(String name, int price, int quantity, String type, String brand, double weight, LocalDate productionDate, LocalDate expirationDate,Seller seller) {
        super(name, price, quantity,seller);
        this.type = type;
        this.brand = brand;
        this.weight = weight;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }
}

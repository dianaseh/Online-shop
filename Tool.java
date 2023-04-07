public class Tool extends Product  {
    private String brand ;
    private String size ;
    private String material;
    private double weight ;
    private boolean isElectric ;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public Tool(String name, int price, int quantity, String brand, String size, String material, double weight, boolean isElectric,Seller seller) {
        super(name, price, quantity,seller);
        this.brand = brand;
        this.size = size;
        this.material = material;
        this.weight = weight;
        this.isElectric = isElectric;
    }
}

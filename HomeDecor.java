
public class HomeDecor extends Product  {
    private int weight ;
    private int height ;
    private int width ;
    private String color ;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public HomeDecor(String name,int price , int quantity ,int weight, int height, int width, String color,Seller seller) {
        super(name,price,quantity,seller);
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.color = color;
    }
}

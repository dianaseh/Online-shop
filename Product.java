import java.util.*;

public class Product {
    private String name ;
    private int price ;
    private int quantity ;
    List<String> comments = new ArrayList<>();
    private Seller Seller ;


    Seller seller = new Seller();

    public Product() {
    }
    public Product(String name, int price, int quantity, Seller seller) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        Seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int qntity) {
        if(qntity>=0)
            this.quantity = qntity;
        else
            System.out.println("not enough in stock");
    }

    public void changeQuantity(int quantity){
        if((getQuantity()+quantity) >= 0 )
        setQuantity(getQuantity()+quantity);
        else
            System.out.println("enter positive amount");
    }

    public void updateBook(String name) {
        seller.removeproduct(name);
        seller.addBooks();
    }
    public void updateBag(String name) {
        seller.removeproduct(name);
        seller.addBags();
    }
    public void updateHomeDecor(String name) {
        seller.removeproduct(name);
        seller.addHomeDecor();
    }
    public void updateCars(String name) {
        seller.removeproduct(name);
        seller.addCars();
    }
    public void updateClothes(String name) {
        seller.removeproduct(name);
        seller.addClothes();
    }
    public void updateElectronics(String name) {
        seller.removeproduct(name);
        seller.addElectronics();
    }
    public void updateGrocery(String name) {
        seller.removeproduct(name);
        seller.addGroceries();
    }
    public void updateShoe(String name) {
        seller.removeproduct(name);
        seller.addShoes();
    }
    public void updateToy(String name) {
        seller.removeproduct(name);
        seller.addToys();
    }
    public void updateTool(String name) {
        seller.removeproduct(name);
        seller.addTools();
    }

    public void setComments(String cmment) {
        comments.add(cmment);
    }
    public void getComments() {
        for(String i : comments)
            System.out.println(i);
    }
}

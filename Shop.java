import java.util.*;

public class Shop {
    private List<Account> accounts = new ArrayList<Account>();
    private List<Product> products = new ArrayList<Product>();
    private List<Product> orders = new ArrayList<Product>();
    private double profit =0 ;

    public Shop() {
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public void setOrders(List<Product> orders) {
        this.orders = orders;
    }
    public void setQuantity(String name , int quantity) {
        findProduct(name).changeQuantity(quantity);
    }
    public void setProducts(Product product) {
        products.add(product);
    }
    public void setProfit(double profit) {
        this.profit += Math.abs(profit);
    }
    public double getProfit() {
        return profit;
    }
    public boolean doesProductExist (String name){
        for(Product i : products){
            if(i.getName().equals(name))
                return true;
        }
        return false;
    }
    public Product findProduct(String name) {
        for(Product i : products){
            if(i.getName().equals(name))
                return i ;
        }
        return null;
    }
    public void viewBag(){
        for(Product i : products){
            if(i instanceof Bag)
                ((Bag)i).toString();
        }
    }
    public void viewBooks(){
        for(Product i : products){
            if(i instanceof Book)
                ((Book)i).toString();
        }
    }
    public void viewCars(){
        for(Product i : products){
            if(i instanceof Cars)
                ((Cars)i).toString();
        }
    }
    public void viewTool(){
        for(Product i : products){
            if(i instanceof Tool)
                ((Tool)i).toString();
        }
    }
    public void viewToy(){
        for(Product i : products){
            if(i instanceof Toy)
                ((Toy)i).toString();
        }
    }
    public void viewShoe(){
        for(Product i : products){
            if(i instanceof Shoe)
                ((Shoe)i).toString();
        }
    }
    public void viewHomeDecor(){
        for(Product i : products){
            if(i instanceof HomeDecor)
                ((HomeDecor)i).toString();
        }
    }
    public void viewGrocery(){
        for(Product i : products){
            if(i instanceof Grocery)
                ((Grocery)i).toString();
        }
    }
    public void viewClothes(){
        for(Product i : products){
            if(i instanceof Clothes)
                ((Clothes)i).toString();
        }
    }
    public void viewElectronics(){
        for(Product i : products){
            if(i instanceof Electronics)
                ((Electronics)i).toString();
        }
    }


}

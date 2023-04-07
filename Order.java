import java.util.*;
import java.time.LocalDateTime ;

public class Order {
    private LocalDateTime date ;
    private double totalPrice ;
    private double finalPrice ;
    private String buyerName ;
    private User buyer ;
    private String SellerName ;
    private boolean isConfirmed ;
    private ArrayList<Product> cart = new ArrayList<>();
    private static ArrayList<Order> orderconfirmation = new ArrayList<>();

    public Order(String buyerName, User buyer, ArrayList<Product> cart) {
        this.buyerName = buyerName;
        this.buyer = buyer;
        this.cart = cart;
        date = LocalDateTime.now();
        for(Product i :cart){
            totalPrice=+i.getPrice();
        }
        finalPrice = totalPrice * 1.1 ;
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public User getBuyer() {
        return buyer;
    }
    public boolean isConfirmed() {
        return isConfirmed;
    }
    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
    public void doTransactions(){
        Shop shop = new Shop();
        shop.setProfit(totalPrice*0.1);
        finalPrice = -(Math.abs(finalPrice)) ;
        this.buyer.setWallet(finalPrice);
        for(Product i : this.cart){
            i.getSeller().setWallet(i.getPrice());
        }
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}

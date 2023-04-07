import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public class Admin extends Account {
    private String email ;
    private List<Order> orderConfirmationReq = new ArrayList<>();
    private HashMap <User , Integer> userfundReq = new HashMap<>();
    private List<Admin> admins = new ArrayList<>();


    public Admin() {
    }
    public Admin(String username, String password, String email) {
        super(username,password);
        this.email = email;
    }

    public boolean adminlogin (String username ,String pass){
        for(Admin i : admins){
            if(i.getUsername().equals(username)){
                if(i.getPassword().equals(pass)){
                    System.out.print("admin successfully signed in.");
                    return true ;
                }
                else{
                    System.out.print("password incorrect.");
                    return false ;
                }
            }
            else{
                System.out.format("admin with username %s not found." , username);
                return false ;
            }
        }
        return false ;
    }
    public void addAdmin (String username, String password, String email){
        Admin admin  = new Admin(username,password,email);
        admins.add(admin);
    }

    public String getUsername() {
        return super.getUsername();
    }
    public String getPassword() {
        return super.getPassword();
    }
    public List<Order> getOrderConfirmationReq() {
        return orderConfirmationReq;
    }

    public void addfund(Map<User,Integer> funds){
        for(Map.Entry<User,Integer> i : funds.entrySet()){
            i.getKey().setWallet(i.getValue());
            funds.remove(i);
        }
        userfundReq.clear();
    }
    public void declinefunds(Map<User,Integer> funds){
        funds.clear();
        userfundReq.clear();
    }
    public void confirmOrder (List<Order> orderConfirmationReq){
        for(Order i : orderConfirmationReq){

            if(i.getFinalPrice()>= (i.getBuyer().getWallet())) {
                i.setConfirmed(true);
                i.doTransactions();
                orderConfirmationReq.remove(i);
            }
            else
                System.out.println("not enough balance in wallet!");
        }
    }
    public void addToOrderConfirmationReq (Order order){
        orderConfirmationReq.add(order);
    }
    public void declindeOrders(List<Order> orderConfirmationReq) {
        orderConfirmationReq.clear();
    }
}

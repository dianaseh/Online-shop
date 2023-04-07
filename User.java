import com.sun.javafx.geom.ShapePair;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public class User extends Account{

    private String email ;
    private String phoneNumber ;
    private String address ;
    private double wallet ;
    private List<User> users = new ArrayList<>();
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private List<Order> listOfOrders = new ArrayList<Order>();
    private List<Product> purchased = new ArrayList<Product>();
    private static Map<User,Integer> funds = new HashMap<>();


    public User() {
        super();
    }
    public User(String username , String pass , String email, String phoneNumber, String address) {
        super(username , pass);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.wallet = 0;
    }

    public double getWallet() {
        return wallet;
    }
    public void setWallet (double fund){
        this.wallet+=fund;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Map<User, Integer> getFunds() {
        return funds;
    }
    public List<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void userRegister (String username ,String pass ,String email, String phoneNumber, String address){
        User user = new User(username,pass,email,phoneNumber,address);
        users.add(user);
        System.out.println("registration complete !");
    }
    public boolean userLogin(String username , String pass){
        for(User i : users){
            if(i.getUsername().equals(username)){
                if(i.getPassword().equals(pass)){
                    System.out.print("user successfully signed in.");
                    return true ;
                }
                else{
                    System.out.print("password incorrect.");
                    return false ;
                }
            }
            else{
                System.out.format("user with username %s not found." , username);
                return false ;
            }
        }
        return false ;

    }
    public void editUserAccount ( String newpass , String newusername,String phone,String add,String email){
        setUsername(newusername);
        setPassword(newpass);
        setAddress(add);
        setEmail(email);
        setPhoneNumber(phone);
    }
    public Product searchProduct (String name){
        for(Product i : shoppingCart){
            if(i.getName().equals(name))
                return i;
        }
        return null ;

    }
    public void addToCart(String name , int quantity){
        Shop shop = new Shop();
        if(shop.doesProductExist(name)){
            if(shop.findProduct(name).getQuantity()  >=  quantity){
                quantity = -(Math.abs(quantity));
                shop.findProduct(name).setQuantity(quantity)  ;
            }
            else
                System.out.print("not enough quantity of product in storage!.");
        }
        else
            System.out.print("product not found.");


    }
    public void removeFromCart(String name){
        boolean flag = true;
        for(Product i : shoppingCart){
            if (i.getName().equals(name)) {
                shoppingCart.remove(i);
                flag = false;
            }
        }
        if(flag)
            System.out.print("product not found.");
    }
    @Override
    public String toString() {
        return "User : " + super.getUsername() + "user's password : " +super.getPassword() +
                "email = '" + email + '\'' +
                ", phoneNumber= '" + phoneNumber + '\'' +
                ", address = '" + address + '\'' +
                ", balance = " + wallet +
                ", shoppingCart = " + shoppingCart +
                ", listOfOrders=" + listOfOrders +
                ", list of purchased products = " + purchased +
                '}';
    }
    public User finduser(String username , String pass){
        for(User i : users){
            if(i.getUsername().equals(username)){
                if(i.getPassword().equals(pass)){
                    return i ;
                }
                else{
                    System.out.print("password incorrect.");
                    return null ;
                }
            }
            else{
                System.out.format("user with username %s not found." , username);
                return null ;
            }
        }
        return null ;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void viewproduct(Product i){
        if(i instanceof Book){
            ((Book)i).toString();
        }
        else if (i instanceof Bag){
            ((Bag)i).toString();
        }
        else if (i instanceof HomeDecor){
            ((HomeDecor)i).toString();
        }
        else if (i instanceof Clothes){
            ((Clothes)i).toString();
        }
        else if (i instanceof Cars){
            ((Cars)i).toString();
        }
        else if (i instanceof Electronics){
            ((Electronics)i).toString();
        }
        else if (i instanceof Grocery){
            ((Grocery)i).toString();
        }
        else if (i instanceof Shoe){
            ((Shoe)i).toString();
        }
        else if (i instanceof Toy){
            ((Toy)i).toString();
        }
        else if (i instanceof Tool){
            ((Tool)i).toString();
        }
    }
    public void viewshoppingcart(){
        for(Product i : shoppingCart){
            if(i instanceof Book){
                ((Book)i).toString();
            }
            else if (i instanceof Bag){
                ((Bag)i).toString();
            }
            else if (i instanceof HomeDecor){
                ((HomeDecor)i).toString();
            }
            else if (i instanceof Clothes){
                ((Clothes)i).toString();
            }
            else if (i instanceof Cars){
                ((Cars)i).toString();
            }
            else if (i instanceof Electronics){
                ((Electronics)i).toString();
            }
            else if (i instanceof Grocery){
                ((Grocery)i).toString();
            }
            else if (i instanceof Shoe){
                ((Shoe)i).toString();
            }
            else if (i instanceof Toy){
                ((Toy)i).toString();
            }
            else if (i instanceof Tool){
                ((Tool)i).toString();
            }
        }
    }
    public void userfundReq(int fund, User user) {
        this.funds.put(user,fund);
    }
    public void viewfunds (){
        System.out.print(funds);
    }
    public void clearCart() {
        shoppingCart.clear();
    }
    public void submitOrder(){
        Order order = new Order(getUsername(),this,shoppingCart);
        Admin admin = new Admin();
            admin.addToOrderConfirmationReq(order);
            listOfOrders.add(order);
    }
    public void removeOrder (){
        System.out.println("Which order do you wish to remove ?");
        Scanner input = new Scanner(System.in);
        for(int i=0 ; i<listOfOrders.size() ; i++){
            System.out.format("%d- order at date %s " , i+1 , listOfOrders.get(i).getDate());
        }
        int op = input.nextInt();
        listOfOrders.remove(listOfOrders.get(op-1));
        System.out.println("order successfully removed!");
    }
}

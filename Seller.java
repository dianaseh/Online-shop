import java.time.LocalDate;
import java.util.*;

public class Seller extends Account{
    private List<Product> availableProducts = new ArrayList<Product>();
    private double wallet  =0 ;
    private boolean isAuthorized = false ;
    private List<Seller> sellerAuthorizationReq = new ArrayList<>() ;
    private List<Seller> sellers = new ArrayList<>();

    Shop shop = new Shop() ;
    Scanner input = new Scanner(System.in);

    public Seller() {
    }
    public Seller(String username, String password ) {
        super(username, password);
    }

    public List<Seller> getSellerAuthorizationReq() {
        return sellerAuthorizationReq;
    }
    public double getWallet() {
        return wallet;
    }
    public void setWallet(double wallet) {
        this.wallet += wallet;
    }
    private boolean isAuthorized(Seller seller) {
        return this.isAuthorized;
    }
    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }
    public List<Product> getAvailableProducts() {
        return availableProducts;
    }
    public  boolean isSellerauthorized (String username ,String pass){
        for(Seller i : sellers){
            if(i.getUsername().equals(username)){
                if(i.getPassword().equals(pass))
                    return isAuthorized(i);

                else
                    return false ;

            }
            else
                return false ;
        }
        return false ;
    }

    public boolean sellerlogin (String username ,String pass){
        for(Seller i : sellers){
            if(i.getUsername().equals(username)){
                if(i.getPassword().equals(pass)){
                    System.out.print("seller successfully signed in.");
                    return true ;
                }
                else{
                    System.out.print("password incorrect.");
                    return false ;
                }
            }
            else{
                System.out.format("seller with username %s not found." , username);
                return false ;
            }
        }
        return false ;
    }
    public void sellerRegister(String username, String pass, double balance){
        Seller seller = new Seller(username,pass);
        sellers.add(seller);
        System.out.println("registration complete !");
    }
    public void viewsellerAuthorizationReq (){
        sellerAuthorizationReq.toString();
    }
    public void sellerauthorization (List<Seller> Asellers){
        for(Seller i : Asellers){
            i.setAuthorized(true);
            Asellers.remove(i);
        }
    }
    public void sellerDEauthorization ( List<Seller> Asellers){
        for(Seller i : Asellers){
            i.setAuthorized(false);
            Asellers.remove(i);
        }
    }
    public void addProduct(){
        System.out.print("choose products category : \n1-Cars\n2-Clothes\n3-Shoes\n4-Bags\n5-Electronics\n6-Tools\n7-Toys\n8-Groceries\n9-Home Decor\n10-Books");
         Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch(n){
            case 1:
                addCars();
                break;
            case 2:
                addClothes();
                break;
            case 3:
                addShoes();
                break;
            case 4:
                addBags();
                break;
            case 5:
                addElectronics();
                break;
            case 6:
                addTools();
                break;
            case 7:
                addToys();
                break;
            case 8:
                addGroceries();
                break;
            case 9:
                addHomeDecor();
                break;
            case 10:
                addBooks();
                break;

        }
    }
    public void updateProduct (String name){
        for(Product i : availableProducts){
            if(i.getName().equals(name)){
                if(i instanceof Book){
                    i.updateBook(name);
                }
                else if (i instanceof Bag){
                    i.updateBag(name);
                }
                else if (i instanceof HomeDecor){
                    i.updateHomeDecor(name);
                }
                else if (i instanceof Clothes){
                    i.updateClothes(name);
                }
                else if (i instanceof Cars){
                    i.updateCars(name);
                }
                else if (i instanceof Electronics){
                    i.updateElectronics(name);
                }
                else if (i instanceof Grocery){
                    i.updateGrocery(name);
                }
                else if (i instanceof Shoe){
                    i.updateShoe(name);
                }
                else if (i instanceof Toy){
                    i.updateToy(name);
                }
                else if (i instanceof Tool){
                    i.updateTool(name);
                }
            }
        }
    }
    public void removeproduct(String name){
        boolean flag = false ;
        for(Product i : availableProducts){
            if(i.getName().equals(name)){
                availableProducts.remove(i);
                flag = true ;
                i=null ;

            }
        }
        if(flag)
            System.out.format("product with name %s successfully removed from shop" , name);
        else
            System.out.format("product with name %s was not found" , name);
    }
    public Seller findseller(String username, String pass) {
        for(Seller i : sellers){
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
                System.out.format("seller with username %s not found." , username);
                return null ;
            }
        }
        return null ;

    }

    public void addBooks() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter author :");
         String author= input.next();
        System.out.println("enter year of publication :");
         int pubYear = input.nextInt();
        System.out.println("enter book's ISBN :");
         int isbn = input.nextInt() ;
         Book book = new Book(name,price,quantity,author,pubYear,isbn,this);
        availableProducts.add(book);
        shop.setProducts(book);
    }
    public void addHomeDecor() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter weight :");
         int weight= input.nextInt()  ;
        System.out.println("enter height :");
         int height= input.nextInt()  ;
        System.out.println("enter width :");
         int width= input.nextInt()  ;
        System.out.println("enter color :");
         String color = input.next() ;
         HomeDecor hd = new HomeDecor(name,price,quantity,weight,height,width,color,this);
        availableProducts.add(hd);
        shop.setProducts(hd);
    }
    public void addGroceries() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter brands name :");
        String brand= input.next()  ;
        System.out.println("enter type :");
        String type = input.next();
        System.out.println("enter weight :");
        double weight = input.nextDouble();
         LocalDate productionDate = LocalDate.now();
         LocalDate expirationDate =  LocalDate.now();
         Grocery gro = new Grocery(name,price,quantity,type,brand,weight,productionDate,expirationDate,this);
        availableProducts.add(gro);
        shop.setProducts(gro);
    }
    public void addToys() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter brands name :");
        String brand= input.next()  ;
        System.out.println("enter size :");
        int size = input.nextInt();
        System.out.println("enter color :");
        String color = input.next();
        System.out.println("enter gender :");
        String gender = input.next();
        System.out.println("enter appropriate age for the toy :");
        int age = input.nextInt();
        Toy toy = new Toy(name,price,quantity,brand,size,color,gender,age,this);
        availableProducts.add(toy);
        shop.setProducts(toy);
    }
    public void addTools() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter brands name :");
        String brand= input.next()  ;
        System.out.println("enter size :");
        String size = input.next();
        System.out.println("enter material :");
        String material= input.next() ;
        System.out.println("enter weight :");
         double weight = input.nextDouble() ;
        System.out.println("is it electric? :");
         boolean isElectric = input.nextBoolean() ;
         Tool tool = new Tool(name,price,quantity,brand,size,material,weight,isElectric,this);
        availableProducts.add(tool);
        shop.setProducts(tool);
    }
    public void addElectronics() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter brands name :");
        String brand= input.next()  ;
        System.out.println("enter type :");
        String type = input.next();
        System.out.println("enter size :");
        String size = input.next();
        System.out.println("enter color :");
        String color = input.next();
        System.out.println("enter battery life :");
         String batteryLife = input.next() ;
        System.out.println("does is have guarantee? :");
         boolean hasGuarantee = input.nextBoolean();
         Electronics electronics = new Electronics(name,price,quantity,brand,type,size,color,batteryLife,hasGuarantee,this);
        availableProducts.add(electronics);
        shop.setProducts(electronics);
    }
    public void addBags() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter brands name :");
        String brand= input.next()  ;
        System.out.println("enter size :");
        int size = input.nextInt();
        System.out.println("enter color :");
        String color = input.next();
        System.out.println("enter gender :");
        String gender = input.next();
        System.out.println("enter volume :");
        int volume = input.nextInt();
        Bag bag = new Bag(name,price,quantity,brand,size,color,gender,volume,this);
        availableProducts.add(bag);
        shop.setProducts(bag);
    }
    public void addShoes() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter brands name :");
        String brand= input.next()  ;
        System.out.println("enter type :");
        String type = input.next();
        System.out.println("enter size :");
        int size = input.nextInt();
        System.out.println("enter color :");
        String color = input.next();
        System.out.println("enter gender :");
        String gender = input.next();
        Shoe shoe = new Shoe(name,price,quantity,brand,size,color,gender,type,this);
        availableProducts.add(shoe);
        shop.setProducts(shoe);
    }
    public void addClothes() {
        System.out.println("enter name :");
        String name = input.next();
        System.out.println("enter price :");
        int price = input.nextInt();
        System.out.println("enter quantity :");
        int quantity= input.nextInt() ;
        System.out.println("enter brands name :");
         String brand= input.next()  ;
        System.out.println("enter type :");
         String type = input.next();
        System.out.println("enter size :");
         String size = input.next();
        System.out.println("enter color :");
         String color = input.next();
        System.out.println("enter gender :");
         String gender = input.next();
         Clothes clothes = new Clothes(name,price,quantity,brand,type,size,color,gender,this);
         availableProducts.add(clothes);
         shop.setProducts(clothes);

    }
    public void addCars() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter car's name :");
         String name = input.next();
        System.out.println("enter car's price :");
         int price = input.nextInt();
        System.out.println("enter car's quantity :");
         int quantity= input.nextInt() ;
        System.out.println("enter car's type :");
        String type= input.next();
        System.out.println("enter car's number of wheels  :");
        int numberOfWheels= input.nextInt();
        System.out.println("enter car's color :");
         String color= input.next();
        System.out.println("enter car's trunk volume :");
         int trunkVolume = input.nextInt();
        System.out.println("enter car's company's name :");
         String company = input.next();
        System.out.println("enter car's horse power :");
         String horsePower= input.next();
        System.out.println("is the car manual? :");
         boolean isManual = input.nextBoolean();
        System.out.println("enter car's acceleration :");
         String acceleration= input.next();
        System.out.println("enter car's kilometer :");
         int kilometer = input.nextInt();
         Cars car = new Cars(name,price,quantity,type,numberOfWheels,color,trunkVolume,company,horsePower,isManual,acceleration,kilometer,this);
         availableProducts.add(car);
         shop.setProducts(car);

    }


    public void athorizationReq (Seller seller){
        sellerAuthorizationReq.add(seller);
    }

}

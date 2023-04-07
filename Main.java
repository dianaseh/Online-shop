import java.util.*;


public class Main {
    private static String[] menu = {"1-log in as admin","2-log in as user","3-log in as seller","4-register new user","5-register new seller","6-about our shop"};
    private static String[] adminMenu ={"1-add new admin","2-view user profile","3-view seller profile","4-view shop profit","5-view authorization requests" ,"6-View order confirmation requests","7-View  user fund addition requests","8-log out"};
    private static String[] usermenu = {"1-shop","2-edit profile","3-add fund","4-view wallet","5-view shopping cart","6-view order","7-log out"};
    private static String[] shopmenu = {"1-view categories","2-search product","3-view product detail","4-add product to cart","5-add comment on product","6-view shopping cart","7-go back to user menu"};
    private static String[] asellermenu = {"1-add product","2-remove product","3-update product","4-view product list","5-view wallet","6-log out"};
    private static String[] sellermenu = {"1-send authorization request","2-log out"};
    private static String[] cartmenu = { "1-edit item", "2-clear shopping cart","3-submit order and checkout","4-remove order","go back"};
    public static void main(String[] args) {
        System.out.println("WELCOME TO OUR SHOP!");
        runmenu(menu);
        Admin a1 = new Admin();
        a1.addAdmin("Admin1", "123","admin@gmail.com");
    }

    private static void runmenu(String[] menu) {
        printMenu(menu);
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch(op){
            case 1: 
                adminlogin();
                break;
            case 2:
                userlogin();
                break;
            case 3:
                sellerlogin();
                break;
            case 4:
                userRegister();
                break;
            case 5:
                sellerRegister();
                break;
            case 6:
                about();
                break;
            default:
                break ; 
                
                
        }
    }
    private static void adminlogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your username : ");
        String username = input.next();
        System.out.print("enter your password : ");
        String pass = input.next();
        Admin admin = new Admin();
        if(admin.adminlogin(username,pass))
             runadminMenu(adminMenu);
        else
            runmenu(menu);
    }
    private static void userlogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your username : ");
        String username = input.next();
        System.out.print("enter your password : ");
        String pass = input.next();
        User user = new User();
        if(user.userLogin(username,pass))
            runuserMenu(usermenu,username,pass);
        else
            runmenu(menu);
    }
    private static void sellerlogin() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your username : ");
        String username = input.next();
        System.out.print("\nenter your password : ");
        String pass = input.next();
        Seller seller  = new Seller();
        if(seller.sellerlogin(username,pass)) {
            if (seller.isSellerauthorized(username, pass))
                runAsellerMenu(asellermenu , username , pass);
            else
                runsellerMenu(sellermenu , username , pass);
        }
    }
    private static void userRegister() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your username : ");
        String username = input.next();
        System.out.print("\nenter your password : ");
        String pass = input.next();
        System.out.print("\nenter your email : ");
        String email = input.next();
        System.out.print("\nenter your phoneNumber : ");
        String phone = input.next();
        System.out.print("\nenter your address : ");
        String address = input.next();
        User user = new User();
        user.userRegister(username,pass,email,phone,address);
        runmenu(menu);
    }
    private static void sellerRegister() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your username : ");
        String username = input.next();
        System.out.print("\nenter your password : ");
        String pass = input.next();
        System.out.print("\nenter your initial balance : ");
        double balance = input.nextDouble();
        Seller seller = new Seller();
        seller.sellerRegister(username,pass,balance);
        runmenu(menu);
    }
    private static void about() {
        System.out.print("\nOUR SHOP \n PHONE : \n WEB ADDRESS : \n  ENTER 1 TO GO BACK TO MAIN MENU");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n==1)
            runmenu(menu);
        else
            about();
    }

    private static void runadminMenu(String[] adminmenu) {
        printMenu(adminmenu);
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch (op) {
            case 1:
                addNewAdmin();
                break;
            case 2:
                viewUserAcc();
                break;
            case 3:
                viewSellerAcc();
                break;
            case 4:
                viewShopProfit();
                break;
            case 5:
                viewSellerAuthorizationReq();
                break;
            case 6:
                viewOrderconfirmationReq();
                break;
            case 7:
                viewUserfundReq();
                break;
            case 8:
                runmenu(menu);
                break;
            default:
                break;
        }

    }
    private static void addNewAdmin() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter admins username : ");
        String username = input.next();
        System.out.print("enter admins password : ");
        String pass = input.next();
        System.out.print("enter admins email : ");
        String email = input.next();
        Admin admin = new Admin();
        admin.addAdmin(username,pass,email);
        System.out.print("New admin added!");
        runadminMenu(adminMenu);
    }
    private static void viewUserAcc() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter users username : ");
        String username = input.next();
        System.out.print("enter users password : ");
        String pass = input.next();
        User user = new User() ;
        user.finduser(username, pass).toString();
        System.out.print("ENTER 1 TO GO BACK TO ADMIN MENU");
        int n = input.nextInt();
        runadminMenu(adminMenu);
    }
    private static void viewSellerAcc() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter sellers username : ");
        String username = input.next();
        System.out.print("Enter sellers password : ");
        String pass = input.next();
        Seller seller = new Seller();
        seller.findseller(username,pass).toString();
        System.out.print("Enter 1 to go back to admin menu");
        int n = input.nextInt();
        runadminMenu(adminMenu);
    }
    private static void viewShopProfit() {
        Scanner input = new Scanner(System.in);
        Shop shop = new Shop();
        System.out.println(shop.getProfit());
        System.out.print("Enter 1 to go back to admin menu");
        int n = input.nextInt();
        runadminMenu(adminMenu);
    }
    private static void viewSellerAuthorizationReq() {
        Seller seller = new Seller();
        seller.viewsellerAuthorizationReq();
        Scanner input = new Scanner(System.in);
        System.out.print("1-confirm order requests \n 2-decline order authorization requests");
        int op = input.nextInt();
        if(op==1){
            seller.sellerauthorization(seller.getSellerAuthorizationReq());
        }
        else if(op==2){
            seller.sellerDEauthorization(seller.getSellerAuthorizationReq());
        }
    }
    private static void viewOrderconfirmationReq() {
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        admin.getOrderConfirmationReq().toString();
        System.out.print("1-confirm order requests \n 2-decline seller authorization requests");
        int op = input.nextInt();
        if(op==1)
            admin.confirmOrder(admin.getOrderConfirmationReq());
        else if(op==2)
            admin.declindeOrders(admin.getOrderConfirmationReq());
    }
    private static void viewUserfundReq() {
        User user = new User();
        user.viewfunds();
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.print("1-confirm fund requests \n 2-decline fund requests");
        int op = input.nextInt();
        if(op==1){
            admin.addfund(user.getFunds());
        }
        else if(op==2){
            admin.declinefunds(user.getFunds());
        }

    }

    private static void runuserMenu(String[] usermenu , String username , String pass) {
        printMenu(usermenu);
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch (op) {
            case 1:
                runshopMenu(shopmenu,username,pass);
                break;
            case 2:
                editUserProfile(username,pass);
                break;
            case 3:
                addFund(username,pass);
                break;
            case 4:
                viewuserWallet(username,pass);
                break;
            case 5:
                viewshoppingCart(username,pass);
                break;
            case 6:
                vieworder(username,pass);
                break;
            case 7:
                runmenu(menu);
                break;
            default:
                break ;
        }
    }
    private static void editUserProfile(String username, String pass) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your new username : ");
        String Nusername = input.next();
        System.out.print("enter your new password : ");
        String Npass = input.next();
        System.out.print("enter your new phone number : ");
        String phone = input.next();
        System.out.print("enter your new address : ");
        String add = input.next();
        System.out.print("enter your new email : ");
        String email = input.next();
        User user = new User();
        user.finduser(username,pass).editUserAccount(Nusername,Npass,phone,add,email);
        runuserMenu(usermenu,Nusername,Npass);
    }
    private static void addFund(String username , String pass) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter fund amount : ");
        int fund = input.nextInt();
        User user = new User();
        user.userfundReq(fund ,user.finduser(username,pass));
        System.out.println("request sent to admin, please wait for confirmation");
    }
    private static void viewuserWallet(String username , String pass) {
        User user = new User();
        System.out.format("your wallet's balance is : %f" ,user.finduser(username,pass).getWallet() );
    }
    private static void viewshoppingCart(String username, String pass) {
        User user = new User();
        user.finduser(username, pass).viewshoppingcart();
        System.out.println(" press 1 for more actions on your cart :");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        runCartMenu(cartmenu,username,pass ,1 );
    }
    private static void vieworder(String username, String pass) {
        User user = new User() ;
        for(Order i : user.finduser(username,pass).getListOfOrders()){
            System.out.format("order at date %s , confirmation status : %s" ,i.getDate() , i.isConfirmed());
        }

    }

    private static void runshopMenu(String[] shopmenu ,  String username , String pass) {
        printMenu(shopmenu);
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch (op){
            case 1:
                viewCategories(username, pass);
                break;
            case 2:
                searchProduct(username, pass);
                break;
            case 3:
                viewProductDetail(username, pass);
                break;
            case 4:
                addProductToCart(username,pass,1);
                break;
            case 5:
                addCommentOnProduct(username, pass);
                break;
            case 6:
                viewshoppingCart(username, pass);
                break;
            case 7:
                runuserMenu(usermenu,username,pass);
                break;
            default:
                break;

        }
    }
    private static void viewCategories(String username , String pass) {
        System.out.print("choose products category : \n1-Cars\n2-Clothes\n3-Shoes\n4-Bags\n5-Electronics\n6-Tools\n7-Toys\n8-Groceries\n9-Home Decor\n10-Books");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Shop shop = new Shop();
        switch (n) {
            case 1:
                shop.viewCars();
                break;
            case 2:
                shop.viewClothes();
                break;
            case 3:
                shop.viewShoe();
                break;
            case 4:
                shop.viewBag();
                break;
            case 5:
                shop.viewElectronics();
                break;
            case 6:
                shop.viewTool();
                break;
            case 7:
                shop.viewToy();
                break;
            case 8:
                shop.viewGrocery();
                break;
            case 9:
                shop.viewHomeDecor();
                break;
            case 10:
                shop.viewBooks();
                break;
            default:
                break;
        }
        System.out.println("Enter 1 to go back to shopping menu");
        int o = input.nextInt();
        runshopMenu(shopmenu,username, pass);
    }
    private static void searchProduct(String username,String pass) {
        Scanner input = new Scanner(System.in);
        Shop shop = new Shop();
        User user = new User();
        System.out.println("Enter products name : ");
        String name = input.next();
        if(shop.findProduct(name) != null){
            user.viewproduct(shop.findProduct(name));
        }
        System.out.println("Enter 1 to go back to shopping menu");
        int o = input.nextInt();
        runshopMenu(shopmenu,username, pass);
    }
    private static void viewProductDetail(String username,String pass) {
        Scanner input = new Scanner(System.in);
        Shop shop = new Shop();
        User user = new User();
        System.out.println("enter products name : ");
        String name = input.next();
        if(shop.findProduct(name) != null){
            user.viewproduct(shop.findProduct(name));
            shop.findProduct(name).getComments();
        }
        System.out.println("Enter 1 to go back to shopping menu");
        int o = input.nextInt();
        runshopMenu(shopmenu,username, pass);
    }
    private static void addProductToCart(String username, String pass , int i) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        System.out.println("enter products name : ");
        String proname = input.next();
        System.out.println("enter the quantity you want to purchase");
        int n = input.nextInt();
        user.finduser(username,pass).addToCart(proname, n);
        if(i==1)
            runshopMenu(shopmenu,username,pass);
        else if(i==2)
            runCartMenu(cartmenu, username,pass ,1);
    }
    private static void addCommentOnProduct( String username,String pass) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter products name : ");
        String proname = input.next();
        Shop shop = new Shop();
        if(shop.doesProductExist(proname)){
            System.out.print("enter your comment : ");
            String commnt = input.next();
            String comment = "comment from " + username + " on product [" + proname + "] : " + commnt;
            shop.findProduct(proname).setComments(comment);
        }
        else {
            System.out.println("product not found !");
            System.out.println("ENTER 1 TO GO BACK TO SHOPPING MENU");
            int n = input.nextInt();
            runshopMenu(shopmenu,username, pass);
        }
    }

    private static void runsellerMenu(String[] sellerenu , String username,String pass) {
        printMenu(sellermenu);
        Scanner input = new Scanner(System.in);
        Seller seller = new Seller();
        int op = input.nextInt();
        if(op == 1){
            seller.athorizationReq(seller.findseller(username,pass));
            System.out.println("request successfully sent! \n log in later to enter your account.");
            System.out.print("ENTER 1 TO GO BACK TO MAIN MENU");
            int n = input.nextInt();
            runmenu(menu);
        }
        else if(op == 2){
            runmenu(menu);
        }
        else
            runsellerMenu(sellermenu , username , pass);
    }
    private static void runAsellerMenu(String[] asellermenu ,String username , String pass) {
        printMenu(asellermenu);
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch (op) {
            case 1:
                addProduct(username,pass);
                break;
            case 2:
                removeProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                viewsellerWallet(username,pass);
                break;
            case 5:
                viewproductList(username,pass);
                break;
            case 6:
                runmenu(menu);
                break;

        }

    }
    private static void addProduct(String username, String pass) {
        Seller seller = new Seller();
        seller.findseller(username,pass).addProduct();
    }
    private static void removeProduct() {
        Seller seller = new Seller();
        Scanner input = new Scanner(System.in);
        System.out.println("enter items name : ");
        String name = input.next();
        seller.removeproduct(name);
    }
    private static void updateProduct() {
        Scanner input = new Scanner(System.in);
        Seller seller = new Seller();
        System.out.println("enter items name : ");
        String name = input.next();
        seller.updateProduct(name);
    }
    private static void viewproductList(String username, String pass) {
        Seller seller = new Seller();
        seller.findseller(username,pass).getAvailableProducts().toString();
    }
    private static void viewsellerWallet(String username, String pass) {
        Seller seller = new Seller();
        double wallet = seller.findseller(username,pass).getWallet();
        System.out.format("seller %s's wallet balance is %f",username, wallet);
    }

    private static void runCartMenu(String[] cartmenu, String username, String pass , int i) {
        printMenu(cartmenu);
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n) {
            case 1:
                int op = input.nextInt();
                if (op == 1) addProductToCart(username, pass, 2);
                else if (op == 2) removeItem(username,pass , i);
                else if (op == 3) changeItemQuantity(username,pass,i);
                break;
            case 2:
                clearShoppingCart(username,pass,i);
                break;
            case 3:
                sumbitOrder(username,pass,i);
                break;
            case 4:
                removeOrder(username,pass,i);
            case 5:
                if(i==1)
                    runshopMenu(shopmenu, username, pass);
                else if(i==2)
                    runshopMenu(shopmenu,username,pass);
                break;
            default:
                break;
        }

    }
    private static void removeItem(String username, String pass , int i) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        System.out.println("enter products name : ");
        String proname = input.next();
        user.finduser(username,pass).removeFromCart(proname);
        System.out.println("press 1 to go back to cart menu ");
        int n = input.nextInt();
        runCartMenu(cartmenu,username,pass , i);
    }
    private static void changeItemQuantity(String username, String pass, int i) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        System.out.println("enter products name : ");
        String proname = input.next();
        System.out.println("enter new quantity ");
        int amount = input.nextInt();
        user.finduser(username,pass).searchProduct(proname).setQuantity(amount);
        System.out.println("press 1 to go back to cart menu ");
        int n = input.nextInt();
        runCartMenu(cartmenu,username,pass , i);
    }
    private static void clearShoppingCart(String username, String pass, int i) {
        User user = new User();
        Scanner input = new Scanner(System.in);
        user.finduser(username,pass).clearCart();
        System.out.println("press 1 to go back to cart menu ");
        int n = input.nextInt();
        runCartMenu(cartmenu,username,pass , i);
    }
    private static void sumbitOrder(String username, String pass, int i) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        user.finduser(username,pass).submitOrder();
        System.out.println("Order successfully submitted ");
        System.out.println("press 1 to go back to cart menu ");
        int n = input.nextInt();
        runCartMenu(cartmenu,username,pass , i);
    }
    private static void removeOrder(String username, String pass, int i) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        user.finduser(username, pass).removeOrder();
        System.out.println("press 1 to go back to cart menu ");
        int n = input.nextInt();
        runCartMenu(cartmenu,username,pass , i);
    }

    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("CHOOSE YOUR OPTION : ");
    }

}

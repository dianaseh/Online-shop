import java.util.*;

public class Account {
    private String username ;
    private String password ;
    private List<User> userlist = new ArrayList<>();
    private List<Admin> adminlist = new ArrayList<>();
    private List<Seller> sellerlist = new ArrayList<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

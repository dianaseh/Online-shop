import java.util.ArrayList;
import java.util.List;

public class Cars extends Product  {
    private String type;
    private int numberOfWheels;
    private String color;
    private int trunkVolume ;
    private String company ;
    private String horsePower;
    private boolean isManual;
    private String acceleration;
    private int kilometer ;

    public void setType(String type) {
        this.type = type;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTrunkVolume(int trunkVolume) {
        this.trunkVolume = trunkVolume;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public Cars(String name, int price, int quantity, String type, int numberOfWheels, String color, int trunkVolume, String company, String horsePower, boolean isManual, String acceleration, int kilometer,Seller seller) {
        super(name, price, quantity,seller);
        this.type = type;
        this.numberOfWheels = numberOfWheels;
        this.color = color;
        this.trunkVolume = trunkVolume;
        this.company = company;
        this.horsePower = horsePower;
        this.isManual = isManual;
        this.acceleration = acceleration;
        this.kilometer = kilometer;
    }
}

package Model;

public class DriverClass {
    public static String driverType,price;

   public DriverClass()
   {

   }

    public DriverClass(String driverType, String price) {
        this.driverType = driverType;
        this.price = price;
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

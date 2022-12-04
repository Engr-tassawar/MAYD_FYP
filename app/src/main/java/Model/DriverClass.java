package Model;

import java.io.Serializable;

import Utils.Services;

public class DriverClass extends Services implements Serializable {
    public  String driverType,price;

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

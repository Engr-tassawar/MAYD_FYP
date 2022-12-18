package Model;

import java.io.Serializable;

import Utils.Services;

public class Order implements Serializable {

    public String price;
    public String date;
    public String time;
    public String address;
    public String description;
    public String CustomerId;
    public String ServiceProviderId;
    public String ServiceProviderName;
    public String ServiceProviderType;
}

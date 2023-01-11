package Model;

import java.io.Serializable;

import Utils.Common;
import Utils.Services;

public class Order implements Serializable {

    public String price;
    public String date;
    public String time;
    public String address;
    public String description;
    public String CustomerId;
    public String ServiceProviderContact;
    public String CustomerContact;
    public String ServiceProviderId;
    public String ServiceProviderName;
    public String ServiceProviderType;
    public String ServiceDescription;
    public String status = String.valueOf(Common.OrderStatus.OnGoing);

    public transient String Uid ;

}

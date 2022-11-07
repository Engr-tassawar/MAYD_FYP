package Model;

public class CustomerUser {
    String customerFullName,customerEmail,customerPhone,customerPassword,customerProfile;
public CustomerUser()
{

}
    public CustomerUser(String customerFullName, String customerPhoneNumber, String customerEmail, String customerPassword){

    }

    public CustomerUser(String customerFullName, String customerEmail, String customerPhone, String customerPassword, String customerProfile) {
        this.customerFullName = customerFullName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerPassword = customerPassword;
        this.customerProfile = customerProfile;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(String customerProfile) {
        this.customerProfile = customerProfile;
    }
}

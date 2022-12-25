package Model;

public class serviceProviderRecord {


    String firstName;
    String lastName;
    String city;



    public serviceProviderRecord() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    String uid;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String phone;
    String serviceProviderService;
    String serviceProviderProfile;


    public serviceProviderRecord(String firstName, String lastName, String city, String services, String dateOfBirth, String ppp) {
    }

    public serviceProviderRecord(String firstName, String lastName, String city, String serviceProviderService, String serviceProviderProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderProfile = serviceProviderProfile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getServiceProviderService() {
        return serviceProviderService;
    }

    public void setServiceProviderService(String serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    public String getServiceProviderProfile() {
        return serviceProviderProfile;
    }

    public void setServiceProviderProfile(String serviceProviderProfile) {
        this.serviceProviderProfile = serviceProviderProfile;
    }
}
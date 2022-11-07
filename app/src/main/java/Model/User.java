
package Model;

public class User {
    String fullName;
    String phoneNumber,email,password;
    public User()
    {

    }

    public User(String fullName, String phoneNumber, String email, String password) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User(String city) {

        this.city = city;
    }

    String city;
    String providerProfilePhoto;

    public User(String fullName, String city, String phoneNumber) {

    }

    public User(String fullName, String phoneNumber) {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProviderProfilePhoto() {
        return providerProfilePhoto;
    }

    public void setProviderProfilePhoto(String providerProfilePhoto) {
        this.providerProfilePhoto = providerProfilePhoto;
    }*/
}

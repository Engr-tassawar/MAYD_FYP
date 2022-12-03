package Model;

public class BookingDetail {
    public String packageAmount;
    public String services;
    public String bookingCode;
    public String providerName;
    public String bookingDate;
    public String bookingTime;
    public String yourPackage;
    public String bookingLocation;


    public BookingDetail(String summaryService) {
        this.summaryService = summaryService;
    }

    public String summaryService;

    public BookingDetail(String selectDate, String selectAddress, String address, String selectDescription) {
    }


    public BookingDetail(String packageAmount, String services, String bookingCode, String providerName, String bookingDate, String bookingTime, String yourPackage, String bookingLocation) {
        this.packageAmount = packageAmount;
        this.services = services;
        this.bookingCode = bookingCode;
        this.providerName = providerName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.yourPackage = yourPackage;
        this.bookingLocation = bookingLocation;
    }

    public String getPackageAmount() {
        return packageAmount;
    }

    public void setPackageAmount(String packageAmount) {
        this.packageAmount = packageAmount;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getYourPackage() {
        return yourPackage;
    }

    public void setYourPackage(String yourPackage) {
        this.yourPackage = yourPackage;
    }

    public String getBookingLocation() {
        return bookingLocation;
    }

    public void setBookingLocation(String bookingLocation) {
        this.bookingLocation = bookingLocation;
    }

    public String getSummaryService() {
        return summaryService;
    }

    public void setSummaryService(String summaryService) {
        this.summaryService = summaryService;
    }
}

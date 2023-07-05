package model;

public class MobileContact extends AbstractEntity{
    private UserDetails userDetails;
    private String phoneNumber;

    public MobileContact() {}

    public MobileContact(UserDetails userDetails, String phoneNumber) {
        this.userDetails = userDetails;
        this.phoneNumber = phoneNumber;
    }

    public UserDetails getUserDetails() {return userDetails;}
    public void setUserDetails(UserDetails userDetails) {this.userDetails = userDetails;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileContact that = (MobileContact) o;

        if (!getUserDetails().equals(that.getUserDetails())) return false;

        return getPhoneNumber().equals(that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        int result = userDetails.hashCode();
        result = 31 * result + getPhoneNumber().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MobileContact{" +
                "userDetails=" + userDetails +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

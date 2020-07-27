package az.hrmodule.domain;

public class Locations {
    private String locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private int countryId;

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public int getCountryId() {
        return countryId;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "locationId='" + locationId + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}

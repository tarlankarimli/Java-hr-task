package az.hrmodule.domain;

public class Countries {
    private int countryId;
    private String countryName;
    private int regionId;

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getRegionId() {
        return regionId;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", regionId=" + regionId +
                '}';
    }
}

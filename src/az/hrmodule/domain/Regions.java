package az.hrmodule.domain;

public class Regions {
    private int regionId;
    private String regionName;

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public int getRegionId() {
        return regionId;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}

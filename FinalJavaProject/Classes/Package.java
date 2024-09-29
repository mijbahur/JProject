package Classes;

import java.lang.*;
class Package {
    private String packageName;
    private String packageId;
    private String mbps;
    private String price;


    public Package(String packageName, String packageId, String mbps, String price) {
        this.packageName = packageName;
        this.packageId= packageId;
        this.mbps = mbps;
        this.price = price;

    }

    public String getPackageName() {
        return packageName;
    }

    public String getPackageId() {
        return packageId;
    }
    public String getMbps() {
        return mbps;
    }

    public String getPrice() {
        return price;
    }


}

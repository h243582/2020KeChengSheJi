package Model;

public class BasicInfo {
    private Integer basicId;
    private Integer accountId;
    private String basicInfoName;
    private String basicInfoGender;
    private Integer basicInfoAge;
    private String basicInfoTelephone;
    private String basicInfoQQ;

    public BasicInfo() {
    }
    public BasicInfo(String basicInfoName, String basicInfoGender, Integer basicInfoAge, String basicInfoTelephone, String basicInfoQQ) {
        this.basicInfoName = basicInfoName;
        this.basicInfoGender = basicInfoGender;
        this.basicInfoAge = basicInfoAge;
        this.basicInfoTelephone = basicInfoTelephone;
        this.basicInfoQQ = basicInfoQQ;
    }

    public Integer getBasicId() {
        return basicId;
    }

    public void setBasicId(Integer basicId) {
        this.basicId = basicId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getBasicInfoName() {
        return basicInfoName;
    }

    public void setBasicInfoName(String basicInfoName) {
        this.basicInfoName = basicInfoName;
    }

    public String getBasicInfoGender() {
        return basicInfoGender;
    }

    public void setBasicInfoGender(String basicInfoGender) {
        this.basicInfoGender = basicInfoGender;
    }

    public Integer getBasicInfoAge() {
        return basicInfoAge;
    }

    public void setBasicInfoAge(Integer basicInfoAge) {
        this.basicInfoAge = basicInfoAge;
    }

    public String getBasicInfoTelephone() {
        return basicInfoTelephone;
    }

    public void setBasicInfoTelephone(String basicInfoTelephone) {
        this.basicInfoTelephone = basicInfoTelephone;
    }

    public String getBasicInfoQQ() {
        return basicInfoQQ;
    }

    public void setBasicInfoQQ(String basicInfoQQ) {
        this.basicInfoQQ = basicInfoQQ;
    }
    @Override
    public String toString() {
        return "BasicInfo{" +
                "basicId=" + basicId +
                ", accountId=" + accountId +
                ", basicInfoName='" + basicInfoName + '\'' +
                ", basicInfoGender='" + basicInfoGender + '\'' +
                ", basicInfoAge=" + basicInfoAge +
                ", basicInfoTelephone='" + basicInfoTelephone + '\'' +
                ", basicInfoQQ='" + basicInfoQQ + '\'' +
                '}';
    }
}

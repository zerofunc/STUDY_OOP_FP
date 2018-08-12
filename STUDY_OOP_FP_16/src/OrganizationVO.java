/**
 * Created by user_11 on 2017-08-01.
 */
public class OrganizationVO {
    private Integer memberSn;
    private String orgName;

    public OrganizationVO(Integer memberSn, String orgName) {
        this.memberSn = memberSn;
        this.orgName = orgName;
    }

    public Integer getMemberSn() {
        return memberSn;
    }

    public void setMemberSn(Integer memberSn) {
        this.memberSn = memberSn;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}

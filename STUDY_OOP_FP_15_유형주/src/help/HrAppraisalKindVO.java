package help;

/**
 * 인사평가 종류
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class HrAppraisalKindVO {
    private Integer hrAppraisalKindSn;
    private String appraisalKindName;
    private Integer displayPriority;

    public HrAppraisalKindVO(Integer hrAppraisalKindSn, String appraisalKindName, Integer displayPriority) {
        this.hrAppraisalKindSn = hrAppraisalKindSn;
        this.appraisalKindName = appraisalKindName;
        this.displayPriority = displayPriority;
    }

    public Integer getHrAppraisalKindSn() {
        return hrAppraisalKindSn;
    }

    public void setHrAppraisalKindSn(Integer hrAppraisalKindSn) {
        this.hrAppraisalKindSn = hrAppraisalKindSn;
    }

    public void setAppraisalKindName(String appraisalKindName) {
        this.appraisalKindName = appraisalKindName;
    }

    public Integer getDisplayPriority() {
        return displayPriority;
    }

    public void setDisplayPriority(Integer displayPriority) {
        this.displayPriority = displayPriority;
    }

    public String getAppraisalKindName() {
        return appraisalKindName;
    }
}

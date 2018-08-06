package help;

/**
 * 인사평가 단계 정보
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class HrAppraisalStepVO {
    private Integer hrAppraisalStepSn;     // 인사평가단계순번
    private String stepName;               // 단계명
    private Boolean useYn;                 // 사용여부

    public HrAppraisalStepVO(Integer hrAppraisalStepSn, String stepName, Boolean useYn) {
        this.hrAppraisalStepSn = hrAppraisalStepSn;
        this.stepName = stepName;
        this.useYn = useYn;
    }

    public Integer getHrAppraisalStepSn() {
        return hrAppraisalStepSn;
    }

    public String getStepName() {
        return stepName;
    }

    public Boolean getUseYn() {
        return useYn;
    }
}

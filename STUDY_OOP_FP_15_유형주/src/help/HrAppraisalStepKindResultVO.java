package help;

/**
 * 인사평가 단계 종류별 점수 정보.
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class HrAppraisalStepKindResultVO {
    private Integer hrAppraisalKindSn;
    private Integer memberSubjectSn;
    private Integer hrAppraisalStepSn;
    private double score;

    public HrAppraisalStepKindResultVO(
            Integer memberSubjectSn, Integer hrAppraisalKindSn, Integer hrAppraisalStepSn, double score) {
        this.hrAppraisalKindSn = hrAppraisalKindSn;
        this.memberSubjectSn = memberSubjectSn;
        this.hrAppraisalStepSn = hrAppraisalStepSn;
        this.score = score;
    }

    public Integer getHrAppraisalKindSn() {
        return hrAppraisalKindSn;
    }

    public Integer getMemberSubjectSn() {
        return memberSubjectSn;
    }

    public Integer getHrAppraisalStepSn() {
        return hrAppraisalStepSn;
    }

    public double getScore() {
        return score;
    }
}

package help;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Doohyun on 2017. 7. 30..
 */
public class CompleteDao {

    private static final CompleteDao Instance = new CompleteDao();

    public static CompleteDao GetInstance() {
        return Instance;
    }

    /**
     * 구성원 정보 출력.
     *
     * @return
     */
    public List<MemberVO> getMemberList() {
        return Arrays.asList(
                new MemberVO(1, "강현지")
                , new MemberVO(2, "남두현")
                , new MemberVO(3, "유덕형")
                , new MemberVO(4, "유형주")
        );
    }

    /**
     * 인사평가 단계정보 출력.
     *
     * @return
     */
    public List<HrAppraisalStepVO> getHrAppraisalStepList() {
        return Arrays.asList(
                new HrAppraisalStepVO(1, "본인평가", true)
                , new HrAppraisalStepVO(2, "1차평가", true)
                , new HrAppraisalStepVO(3, "2차평가", false)
                , new HrAppraisalStepVO(4, "3차평가", true)
        );
    }

    /**
     * 인사평가 종류 정보 출력.
     *
     * @return
     */
    public List<HrAppraisalKindVO> getHrAppraisalKindList() {
        return Arrays.asList(
                new HrAppraisalKindVO(1, "공통역량", 3)
                , new HrAppraisalKindVO(2, "리더십역량", 2)
                , new HrAppraisalKindVO(3, "직무역량", 1)
        );
    }

    /**
     * 인사평가 단계별 종류 결과.
     *
     * @return
     */
    public List<HrAppraisalStepKindResultVO> getHrAppraisalStepKindResultVoList() {
        return Arrays.asList(
                new HrAppraisalStepKindResultVO(1, 1, 1, 80),
                new HrAppraisalStepKindResultVO(1, 2, 1, 90),
                new HrAppraisalStepKindResultVO(1, 3, 1, 95),
                new HrAppraisalStepKindResultVO(1, 1, 2, 95),
                new HrAppraisalStepKindResultVO(1, 2, 2, 88),
                new HrAppraisalStepKindResultVO(1, 3, 2, 90),
                new HrAppraisalStepKindResultVO(1, 1, 3, 95),
                new HrAppraisalStepKindResultVO(1, 2, 3, 88),
                new HrAppraisalStepKindResultVO(1, 3, 3, 90),
                new HrAppraisalStepKindResultVO(1, 1, 4, 95),
                new HrAppraisalStepKindResultVO(1, 2, 4, 88),
                new HrAppraisalStepKindResultVO(1, 3, 4, 90),

                new HrAppraisalStepKindResultVO(2, 1, 1, 60),
                new HrAppraisalStepKindResultVO(2, 2, 1, 70),
                new HrAppraisalStepKindResultVO(2, 3, 1, 45),
                new HrAppraisalStepKindResultVO(2, 1, 2, 55),
                new HrAppraisalStepKindResultVO(2, 2, 2, 58),
                new HrAppraisalStepKindResultVO(2, 3, 2, 50),
                new HrAppraisalStepKindResultVO(2, 1, 3, 55),
                new HrAppraisalStepKindResultVO(2, 2, 3, 58),
                new HrAppraisalStepKindResultVO(2, 3, 3, 50),
                new HrAppraisalStepKindResultVO(2, 1, 4, 55),
                new HrAppraisalStepKindResultVO(2, 2, 4, 58),
                new HrAppraisalStepKindResultVO(2, 3, 4, 60),

                new HrAppraisalStepKindResultVO(3, 1, 1, 65),
                new HrAppraisalStepKindResultVO(3, 2, 1, 67),
                new HrAppraisalStepKindResultVO(3, 3, 1, 76),
                new HrAppraisalStepKindResultVO(3, 1, 2, 90),
                new HrAppraisalStepKindResultVO(3, 2, 3, 90),
                new HrAppraisalStepKindResultVO(3, 3, 3, 98),
                new HrAppraisalStepKindResultVO(3, 1, 4, 80),
                new HrAppraisalStepKindResultVO(3, 2, 4, 70),
                new HrAppraisalStepKindResultVO(3, 3, 4, 50),

                new HrAppraisalStepKindResultVO(4, 1, 1, 65),
                new HrAppraisalStepKindResultVO(4, 2, 1, 67),
                new HrAppraisalStepKindResultVO(4, 3, 1, 76),
                new HrAppraisalStepKindResultVO(4, 1, 2, 90),
                new HrAppraisalStepKindResultVO(4, 2, 2, 90),
                new HrAppraisalStepKindResultVO(4, 3, 2, 60),
                new HrAppraisalStepKindResultVO(4, 1, 3, 87),
                new HrAppraisalStepKindResultVO(4, 2, 3, 90),
                new HrAppraisalStepKindResultVO(4, 3, 3, 98),
                new HrAppraisalStepKindResultVO(4, 1, 4, 80),
                new HrAppraisalStepKindResultVO(4, 2, 4, 70),
                new HrAppraisalStepKindResultVO(4, 3, 4, 50)

                );
    }
}

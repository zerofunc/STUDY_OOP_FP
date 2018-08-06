import help.CompleteDao;
import help.HrAppraisalStepKindResultVO;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 깊은 복사
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class Q4 implements IQ{

    @Override
    public void 자바8_이전_행위_열람() {

        // 해당 부분만 JAVA8 문법.
        // 현재 제공한 targetMap 을 깊은복사하고 싶음.
        // 단순하게 맵을 새로 제작하는 것으로는 내부의 맵을 복사할 수 없음. (얕은 복사)
        // 즉 하나씩 맵을 순회하면서 복사해야함을 의미.
        Map<Integer, Map<Integer, Map<Integer, HrAppraisalStepKindResultVO>>> targetMap =
            CompleteDao.GetInstance().getHrAppraisalStepKindResultVoList().
                            stream().collect(
                                    Collectors.groupingBy(HrAppraisalStepKindResultVO::getMemberSubjectSn,
                                            Collectors.groupingBy(HrAppraisalStepKindResultVO::getHrAppraisalStepSn
                                            , Collectors.toMap(HrAppraisalStepKindResultVO::getHrAppraisalKindSn, Function.identity())))
            );

        System.out.println("targetMap");
        System.out.println(targetMap);


        Map<Integer, Map<Integer, Map<Integer, HrAppraisalStepKindResultVO>>> copyMap = new HashMap<>();
        {

            for (Integer memberSubjectSn : targetMap.keySet()) {

                Map<Integer, Map<Integer, HrAppraisalStepKindResultVO>> subMap1 = targetMap.get(memberSubjectSn);

                final Map<Integer, Map<Integer, HrAppraisalStepKindResultVO>> newCopySubMap1 = new HashMap<>();
                {
                    for (Integer hrAppraisalStepSn : subMap1.keySet()) {
                        final HashMap<Integer, HrAppraisalStepKindResultVO> newCopySubMap2 = new HashMap<>(subMap1.get(hrAppraisalStepSn));

                        newCopySubMap1.put(hrAppraisalStepSn, newCopySubMap2);
                    }
                }

                copyMap.put(memberSubjectSn, newCopySubMap1);
            }
        }

        System.out.println("copyMap");
        System.out.println(copyMap);


    }

    /**
     * @Author YooHyeongJu
     */
    @Override
    public void 자바8_행위_열람() {

        // 해당 부분만 JAVA8 문법.
        // 현재 제공한 targetMap 을 깊은복사하고 싶음.
        // 단순하게 맵을 새로 제작하는 것으로는 내부의 맵을 복사할 수 없음. (얕은 복사)
        // 즉 하나씩 맵을 순회하면서 복사해야함을 의미.
        Map<Integer, Map<Integer, Map<Integer, HrAppraisalStepKindResultVO>>> targetMap =
                CompleteDao.GetInstance().getHrAppraisalStepKindResultVoList().
                        stream().collect(
                        Collectors.groupingBy(HrAppraisalStepKindResultVO::getMemberSubjectSn,
                                Collectors.groupingBy(HrAppraisalStepKindResultVO::getHrAppraisalStepSn
                                        , Collectors.toMap(HrAppraisalStepKindResultVO::getHrAppraisalKindSn, Function.identity())))
                );

        System.out.println("targetMap");
        System.out.println(targetMap);

        Map<Integer, Map<Integer, Map<Integer, HrAppraisalStepKindResultVO>>> copyMap = new HashMap<>();
        {

            targetMap.keySet().stream()
                    .forEach((memberSubjectSn) -> {
                        Map<Integer, Map<Integer, HrAppraisalStepKindResultVO>> subMap1 = targetMap.get(memberSubjectSn);
                        Map<Integer, Map<Integer, HrAppraisalStepKindResultVO>> newCopySubMap1 = new HashMap<>();
                        subMap1.keySet()
                                .stream()
                                .forEach(hrAppraisalStepSn -> {
                                    HashMap<Integer, HrAppraisalStepKindResultVO> newCopySubMap2 = new HashMap<>(subMap1.get(hrAppraisalStepSn));
                                    newCopySubMap1.put(hrAppraisalStepSn, newCopySubMap2);
                                });
                        copyMap.put(memberSubjectSn, newCopySubMap1);
                    });
        }

        System.out.println("copyMap");
        System.out.println(copyMap);


    }
}

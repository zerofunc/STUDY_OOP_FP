import help.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import help.StepAverageResultVO.CapabilityAverageVO;

/**
 * 흔히 작성하는 비지니스 로직의 수행과정 리팩토링.
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class Q3 implements IQ{

    /**
     * 해당 로직의 목적 서술.
     *
     * <pre>
     * 구성원의 단계별 종류점수의 평균을 구하는 것이 목적 (모든 종류를 평가받았을 때만, 종류의 평균을 구할 수 있음.)
     *
     * 각 정보 목록 소개
     * - 인사평가 단계 : 단계별 정보를 가지고 있음 (사용여부가 반영되어 있음.)
     * - 인사평가 종류 : 인사평가 종류에 대한 정보를 가지고 있음 (종류의 표시순서가 있음.)
     * - 대상자 정보 : 대상자 정보를 가지고 있음
     * - 인사평가 단계별 종류 결과 : 대상자의 단계에 종류에 대한 점수점보가 들어 있음. (key 기반 정보)
     *
     * - 최종적으로는 StepAverageResultVO 목록이 나와야함.
     * </pre>
     *
     */
    @Override
    public void 자바8_이전_행위_열람() {

        // 인사평가단계 목록
        List<HrAppraisalStepVO> hrAppraisalStepVOList = new ArrayList<>();
        {
            for (HrAppraisalStepVO hrAppraisalStepVO : CompleteDao.GetInstance().getHrAppraisalStepList()) {
                if (hrAppraisalStepVO.getUseYn()) {
                    hrAppraisalStepVOList.add(hrAppraisalStepVO);
                }
            }
        }

        // 인사평가종류 목록
        List<HrAppraisalKindVO> hrAppraisalKindVOList = CompleteDao.GetInstance().getHrAppraisalKindList();

        // 구성원 정보 목록.
        List<MemberVO> memberVOList = CompleteDao.GetInstance().getMemberList();

        // 인사평가단계별 종류 결과.
        List<HrAppraisalStepKindResultVO> hrAppraisalStepKindResultVOList = CompleteDao.GetInstance().getHrAppraisalStepKindResultVoList();


        // 평균결과 목록.
        ArrayList<StepAverageResultVO> stepAverageResultVOList = new ArrayList<>();

        // 결과목록 제작 알고리즘 정의
        for (MemberVO memberVO : memberVOList) {

            // 데이터 삽입
            StepAverageResultVO stepAverageResultVO = new StepAverageResultVO();
            {
                stepAverageResultVO.setName(memberVO.getName());
                stepAverageResultVOList.add(stepAverageResultVO);
            }

            // 구성원의 역량점수 평균 목록.
            final List<CapabilityAverageVO> capabilityAverageVOList = new ArrayList<>();

            for (HrAppraisalKindVO hrAppraisalKindVO : hrAppraisalKindVOList) {

                // 단계별 종류 점수 목록.
                final List<HrAppraisalStepKindResultVO> scoreList = new ArrayList<>();
                {
                    for (HrAppraisalStepVO hrAppraisalStepVO : hrAppraisalStepVOList) {
                        for (HrAppraisalStepKindResultVO hrAppraisalStepKindResultVO : hrAppraisalStepKindResultVOList) {

                            // 평가종류 잡기.
                            if (memberVO.getMemberSubjectSn().intValue() == hrAppraisalStepKindResultVO.getMemberSubjectSn().intValue()
                                    && hrAppraisalStepKindResultVO.getHrAppraisalKindSn().intValue() == hrAppraisalKindVO.getHrAppraisalKindSn().intValue()
                                    && hrAppraisalStepVO.getHrAppraisalStepSn().intValue() == hrAppraisalStepKindResultVO.getHrAppraisalStepSn().intValue()) {
                                scoreList.add(hrAppraisalStepKindResultVO);
                            }
                        }
                    }
                }

                // 특정 종류가 모든 단계의 점수가 있어야함.
                if (scoreList.size() == hrAppraisalStepVOList.size()) {
                    CapabilityAverageVO capabilityAverageVO = new CapabilityAverageVO();
                    capabilityAverageVO.setKindName(hrAppraisalKindVO.getAppraisalKindName());
                    capabilityAverageVO.setDisplayPriority(hrAppraisalKindVO.getDisplayPriority());

                    // 평균점수.
                    Double average = 0.0;
                    {
                        for (HrAppraisalStepKindResultVO resultVO : scoreList) {
                            average += resultVO.getScore();
                        }
                    }

                    average /= scoreList.size();
                    capabilityAverageVO.setAverageScore(average);

                    capabilityAverageVOList.add(capabilityAverageVO);
                }
            }

            // 역량에 따른 정렬 수행.
            Collections.sort(capabilityAverageVOList, new Comparator<CapabilityAverageVO>() {
                @Override
                public int compare(CapabilityAverageVO o1, CapabilityAverageVO o2) {
                    return o1.getDisplayPriority().compareTo(o2.getDisplayPriority());
                }
            });

            stepAverageResultVO.setCapabilityAverageVOList(capabilityAverageVOList);
        }

        // 데이터 프린트.
        {
            for (StepAverageResultVO stepAverageResultVO : stepAverageResultVOList) {

                System.out.println(String.format("%s의 점수 정보", stepAverageResultVO.getName()));

                for (CapabilityAverageVO capabilityAverageVO : stepAverageResultVO.getCapabilityAverageVOList()) {
                    System.out.println(capabilityAverageVO);
                }

                System.out.println();
            }
        }


    }

    /**
     * @Author YooHyeongJu
     */
    @Override
    public void 자바8_행위_열람() {
        // 인사평가단계 목록
        List<HrAppraisalStepVO> hrAppraisalStepVOList = new ArrayList<>();
        {
            CompleteDao.GetInstance().getHrAppraisalStepList()
                    .stream()
                    .filter(hrAppraisalStepVO -> hrAppraisalStepVO.getUseYn())
                    .forEach(hrAppraisalStepVO -> hrAppraisalStepVOList.add(hrAppraisalStepVO));
        }
        /**
         * 인사평가단계 목록 제작
         *
         * key : 인사평가단계 순번
         * value : 인사평가 단계 정보
         */
        final Map<Integer, HrAppraisalStepVO> hrAppraisalStepVOMap;
        {
            hrAppraisalStepVOMap = hrAppraisalStepVOList.stream()
                    .collect(Collectors.toMap(HrAppraisalStepVO::getHrAppraisalStepSn, Function.identity()));
        }

        /**
         * 인사평가종류 목록 제작
         *
         * key : 인사평가종류 순번
         * value : 인사평가 단계 정보
         */
        final Map<Integer, HrAppraisalKindVO> hrAppraisalKindVOMap;
        List<HrAppraisalKindVO> hrAppraisalKindVOList = CompleteDao.GetInstance().getHrAppraisalKindList();
        {
            hrAppraisalKindVOMap = hrAppraisalKindVOList.stream()
                    .collect(Collectors.toMap(HrAppraisalKindVO::getHrAppraisalKindSn, Function.identity()));
        }

        /**
         * 구성원정보 목록 제작
         *
         * key : 멤버순번
         * value : 멤버
         */
        List<MemberVO> memberVOList = CompleteDao.GetInstance().getMemberList();
        final Map<Integer, MemberVO> memberVOMap;
        {
            memberVOMap = memberVOList.stream()
                    .collect(Collectors.toMap(MemberVO::getMemberSubjectSn, Function.identity()));
        }


        /**
         * 인사평가단계별 종류 결과 제작
         *
         * key : 멤번순번
         * value : 인사평가단계별 종류
         */
        List<HrAppraisalStepKindResultVO> hrAppraisalStepKindResultVOList = CompleteDao.GetInstance().getHrAppraisalStepKindResultVoList();


        // 평균결과 목록.
        ArrayList<StepAverageResultVO> stepAverageResultVOList = new ArrayList<>();

        memberVOMap.keySet()
                .stream()
                .map(memberSn -> {
                    MemberVO memberVO = memberVOMap.get(memberSn);
                    // 데이터 삽입
                    StepAverageResultVO stepAverageResultVO = new StepAverageResultVO();
                    {
                        stepAverageResultVO.setName(memberVO.getName());
                        stepAverageResultVOList.add(stepAverageResultVO);
                    }

                    // 구성원의 역량점수 평균 목록.
                    final List<CapabilityAverageVO> capabilityAverageVOList = new ArrayList<>();

                    hrAppraisalKindVOMap.keySet()
                            .stream()
                            .forEach(hrAppraisalKindSn -> {
                                HrAppraisalKindVO hrAppraisalKindVO = hrAppraisalKindVOMap.get(hrAppraisalKindSn);
                                // 단계별 종류 점수 목록.
                                final List<HrAppraisalStepKindResultVO> scoreList =  hrAppraisalStepKindResultVOList.stream()
                                            .filter(hrAppraisalStepKindResultVO -> {
                                                HrAppraisalStepVO hrAppraisalStepVO = hrAppraisalStepVOMap.get(hrAppraisalStepKindResultVO.getHrAppraisalStepSn());

                                                // 평가종류 잡기.
                                                return (hrAppraisalStepVO != null &&memberVO.getMemberSubjectSn().intValue() == hrAppraisalStepKindResultVO.getMemberSubjectSn().intValue()
                                                        && hrAppraisalStepKindResultVO.getHrAppraisalKindSn().intValue() == hrAppraisalKindVO.getHrAppraisalKindSn().intValue()
                                                        && hrAppraisalStepVO.getHrAppraisalStepSn().intValue() == hrAppraisalStepKindResultVO.getHrAppraisalStepSn().intValue());
                                            }).collect(Collectors.toList());


                                // 특정 종류가 모든 단계의 점수가 있어야함.
                                if (scoreList.size() == hrAppraisalStepVOList.size()) {
                                    CapabilityAverageVO capabilityAverageVO = new CapabilityAverageVO();
                                    capabilityAverageVO.setKindName(hrAppraisalKindVO.getAppraisalKindName());
                                    capabilityAverageVO.setDisplayPriority(hrAppraisalKindVO.getDisplayPriority());

                                    // 평균점수.
                                    Double average = 0.0;
                                    {
                                        double sum = scoreList.stream()
                                                .mapToDouble(HrAppraisalStepKindResultVO::getScore)
                                                .sum();
                                        average += sum;
                                    }

                                    average /= scoreList.size();
                                    capabilityAverageVO.setAverageScore(average);

                                    capabilityAverageVOList.add(capabilityAverageVO);
                                }
                            });
                    // 역량에 따른 정렬 수행.
                    List<CapabilityAverageVO> capabilityAverageOrderedList = capabilityAverageVOList.stream()
                            .sorted(Comparator.comparing(CapabilityAverageVO::getDisplayPriority))
                            .collect(Collectors.toList());

                    stepAverageResultVO.setCapabilityAverageVOList(capabilityAverageOrderedList);
                    return stepAverageResultVO;
                }).forEach(stepAverageResultVO -> {
                    System.out.println(String.format("%s의 점수 정보", stepAverageResultVO.getName()));
                    stepAverageResultVO.getCapabilityAverageVOList().stream()
                            .forEach(capabilityAverageVO -> {
                                System.out.println(capabilityAverageVO);
                            });
                    System.out.println();
        });



    }
}

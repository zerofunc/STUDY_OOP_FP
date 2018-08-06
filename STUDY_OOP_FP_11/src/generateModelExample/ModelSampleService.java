package generateModelExample;

import generateModelExample.dao.Model1Dao;
import generateModelExample.dao.Model2Dao;
import generateModelExample.vo.GenerateModel1;
import generateModelExample.vo.GenerateModel2;

import java.util.*;
import java.util.function.*;

/**
 * 모델에 대한 샘플 서비스.
 * <p>
 * Created by Doohyun on 2017. 7. 10..
 */
public class ModelSampleService {




    /**
     * 싱글톤을 위한 매니저 홀더.
     */
    private static final class ManagerHolder {
        private static final ModelSampleService unique = new ModelSampleService();
    }

    private ModelSampleService() {
    }

    public static ModelSampleService GetInstance() {
        return ManagerHolder.unique;
    }

    /**
     * 비슷한 모듈의 switch 문제.
     * @Author YooHyeongJu
     */
    public void switchAndSwitch() {

        // 이 기능에서는 switch 를 이용한 반복적 모듈이 자주 등장하고 있음.
        // 보통은 이런 기능은 메소드로 캡슐화하는 것도 괜찮은 생각.
        // 하지만, 느낌있는 프로그래머인 당신은 해당 switch 의 블럭이 이 메소드에서만 사용할 것이란 직감을 받음.
        // - 굳이 한번쓰고 버릴 메소드를 만드는 것은 좋을까?.........
        // - 이를 고민한 당신은 괜찮은 방법을 생각해내는데?...
        // - 설마, 형변환 같은 짓을 하진 않겠지.....  비교하고자 하는 다른 조건이 추가되면......

        List<GenerateModel1> generateModel1List = Model1Dao.GetInstance().selectList(Arrays.asList(1,2,3));
        Consumer<String> stringConsumer = (String name) -> {
            switch (name) {
                case "강현지":
                    System.out.println("IF 란 사치임을 증명한 " + name);
                    break;

                case "유덕형":
                    System.out.println("한 수에 버그를 말살하는 " + name);
                    break;

                case "유형주":
                    System.out.println("한 메소드에 5줄 이면 충분한 " + name);
                    break;
            }
        };

        // something work1
        {
            for (GenerateModel1 model1 : generateModel1List) {
                String name = model1.getName();
                stringConsumer.accept(model1.getName());
            }
        }

        // something work2
        {
            List<String> filterNameList = Arrays.asList("강현지", "유덕형");

            for (GenerateModel1 model1 : generateModel1List) {
                String name = model1.getName();

                if (filterNameList.contains(name)) {
                    stringConsumer.accept(name);
                }
            }
        }

        // something work3
        {
            List<Integer> memberSnList = Arrays.asList(2,3);

            for (GenerateModel1 model1 : generateModel1List) {

                if (memberSnList.contains(model1.getMemberSubjectSn())) {
                    String name = model1.getName();
                    stringConsumer.accept(model1.getName());
                }
            }
        }
    }

    /**
     * 제너레이트 된 모델에 대한 비지니스 로직 정의.
     *
     * @param addTargetMemberSnList
     * @param excludeTargetMemberSnList
     * @Author YooHyeongJu
     */
    public void createByGenerateModel(
            List<Integer> addTargetMemberSnList
            , List<Integer> excludeTargetMemberSnList){

        // Q2. ORM interface 가 달라 비슷한 로직을 중복코드로 작성하는 경우가 대부분..
        // 이 것을 리팩토링 할 수 있을까?

        // 동일한 알고리즘이지만, ORM 모델의 서명이 다르기 때문에 공통모듈을 사용하지 못하는 것처럼 보임.
        // 기존 코드에서는 별다른 처리를 할 수 없기 때문에, C&P 를 통해 모듈을 작성.
        // 하지만, 비슷한 GenerateModel 은 더 늘어날 수도 있음!!!!!!

        // 또한, 단지 이 메소드 때문에 TemplateMethod 패턴 처럼 굳이 인터페이스를 또 만들어 클래스 파편화를 두고 싶지 않음..
        // -> 코드 파편화는 디버깅의 주적.....
        // -> Too much 하게 복잡해지면, 그 때 TemplateMethod 리팩토링해도 늦지 않음.

        // [경험없는 개발자]의 요구사항을 당신은 해결할 수 있을 것이라 믿음.
        // 또한, 당신은 [OCP] 를 지킬 수 있는 보다 유연한 구조를 짤 수 있을 것이라 믿음.

     /*   createByGenerateModel1(addTargetMemberSnList, excludeTargetMemberSnList);
        createByGenerateModel2(addTargetMemberSnList, excludeTargetMemberSnList);*/

        Model1Dao model1Dao = Model1Dao.GetInstance();

        Function<Integer, GenerateModel1> toGegnerateModel1 = (Integer memberSn)->{
            GenerateModel1 generateModel1 = new GenerateModel1();
            generateModel1.setMemberSubjectSn(memberSn);
            return generateModel1;
        };
        Function<HashMap, Object> selectList1 = (HashMap hashMap) -> {
            return model1Dao.selectList(hashMap.keySet());
        };
        Function<GenerateModel1, Object> toMemberSubjectSn1 = (GenerateModel1 model) -> {
            return model.getMemberSubjectSn();
        };

        Consumer<GenerateModel1> insertData1 = (GenerateModel1 model) -> {
            model1Dao.create(model);
        };

        Runnable deleteByMemberSnList = () -> {
            model1Dao.deleteByMemberSnList(excludeTargetMemberSnList);
        };
        BiConsumer<Set, HashSet<Integer>> have1 = (Set set, HashSet<Integer> excludeTargetMemberSnSet) -> {
            List<GenerateModel1> existList = model1Dao.selectList(set);
            for (GenerateModel1 generateModel1 : existList) {
                excludeTargetMemberSnSet.add(generateModel1.getMemberSubjectSn());
            }
        };
        // model1 generate
        createByGenerateModelUseFunctionInterface(addTargetMemberSnList
        ,excludeTargetMemberSnList
        ,toGegnerateModel1
        ,have1
        ,insertData1
        ,deleteByMemberSnList);

        Model2Dao model2Dao = Model2Dao.GetInstance();

        Function<Integer, GenerateModel2> toGegnerateModel2 = (Integer memberSn)->{
            GenerateModel2 generateModel2 = new GenerateModel2();
            generateModel2.setMemberSubjectSn(memberSn);
            return generateModel2;
        };
        Function<HashMap, Object> selectList2 = (HashMap hashMap) -> {
            return model2Dao.selectList(hashMap.keySet());
        };
        Function<GenerateModel2, Object> toMemberSubjectSn2 = (GenerateModel2 model) -> {
            return model.getMemberSubjectSn();
        };

        Consumer<GenerateModel2> insertData2 = (GenerateModel2 model) -> {
            model2Dao.create(model);
        };

        Runnable deleteByMemberSnList2 = () -> {
            model2Dao.deleteByMemberSnList(excludeTargetMemberSnList);
        };
        BiConsumer<Set, HashSet<Integer>> have2 = (Set keySet, HashSet<Integer> excludeTargetMemberSnSet) -> {
            List<GenerateModel2> existList = model2Dao.selectList(keySet);
            for (GenerateModel2 generateModel2 : existList) {
                excludeTargetMemberSnSet.add(generateModel2.getMemberSubjectSn());
            }
        };

        // model1 generate
        createByGenerateModelUseFunctionInterface(addTargetMemberSnList
                ,excludeTargetMemberSnList
                ,toGegnerateModel2
                ,have2
                ,insertData2
                ,deleteByMemberSnList2);
    }

    /**
     * 함수형 인터페이스를 인자로 받아 비즈니스 로직 정의.
     * @param addTargetMemberSnList
     * @param excludeTargetMemberSnList
     * @param toGenerateModel
     * @param have
     * @param insertData
     * @param deleteByMemberSnList
     * @Author YooHyeongJu
     */
    private void createByGenerateModelUseFunctionInterface(
            List<Integer> addTargetMemberSnList
            , List<Integer> excludeTargetMemberSnList
            , Function toGenerateModel
            , BiConsumer have
            , Consumer insertData
            , Runnable deleteByMemberSnList){

        /**
         * 새로 저장할 구성원을 순번으로 그룹핑한다
         *
         * key : 구성원순번
         * value : 모델 객체
         */
        final HashMap<Integer, Object> groupByMemberSnMemberMap = new HashMap<>();
        {
            for (Integer memberSn : addTargetMemberSnList) {
                // 일단은 MemberSn 만 넣는다고 가정.
                Object apply = toGenerateModel.apply(memberSn);
                groupByMemberSnMemberMap.put(memberSn, apply);
            }
        }

        // 이미 존재하는 구성원이거나 제외대상자는 입력 대상에서 제외.
        {
            // 이미 존재하는 구성원순번 또는 제외 타겟 순번 집합.
            HashSet<Integer> excludeTargetMemberSnSet = new HashSet<>();
            {
                // 이미 존재하는 구성원 순번 목록 삽입.
                have.accept(groupByMemberSnMemberMap.keySet(), excludeTargetMemberSnSet);
                // 제외 대상 파라미터도 추가.
                excludeTargetMemberSnSet.addAll(excludeTargetMemberSnList);
            }

            // 추가대상 그룹에서 제외 대상 집합을 삭제한다.
            groupByMemberSnMemberMap.keySet().removeAll(excludeTargetMemberSnSet);
        }


        // 데이터 트랜잭션
        {
            // 데이터 삽입.
            Collection<Object> values = groupByMemberSnMemberMap.values();
            for (Object model : groupByMemberSnMemberMap.values()) {
                insertData.accept(model);
            }

            // 제외대상 삭제.
            deleteByMemberSnList.run();
        }
    }

}

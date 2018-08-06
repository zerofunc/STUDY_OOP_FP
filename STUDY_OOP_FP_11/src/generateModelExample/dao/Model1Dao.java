package generateModelExample.dao;

import generateModelExample.vo.GenerateModel1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 모델1 에 대한 저장 컴포넌트 명세.
 *
 * Created by Doohyun on 2017. 7. 10..
 */
public class Model1Dao {

    /**
     * 싱글톤을 위한 매니저 홀더.
     */
    private static final class ManagerHolder {
        private static final Model1Dao unique = new Model1Dao();
    }

    private Model1Dao(){}

    /**
     * Instance 출력.
     *
     * @return
     */
    public static final Model1Dao GetInstance() {
        return ManagerHolder.unique;
    }

    /**
     * 모델1 데이터 삽입에 대한 STUB 메소드.
     *
     * @param generateModel1
     */
    public void create(GenerateModel1 generateModel1){
        System.out.println("Model1 데이터 저장" + generateModel1);
    }

    /**
     * 데이터 조회 샘플 목록 출력.
     *
     * @param memberSnList
     * @return
     */
    public List<GenerateModel1> selectList(Collection<Integer> memberSnList) {
        ArrayList<GenerateModel1> list = new ArrayList<>();

        // 데이터 샘플1
        {
            GenerateModel1 model1 = new GenerateModel1();
            model1.setMemberSubjectSn(1);
            model1.setName("강현지");

            list.add(model1);
        }

        // 데이터 샘플2
        {
            GenerateModel1 model1 = new GenerateModel1();
            model1.setMemberSubjectSn(2);
            model1.setName("유덕형");

            list.add(model1);
        }

        // 데이터 샘플3
        {
            GenerateModel1 model1 = new GenerateModel1();
            model1.setMemberSubjectSn(3);
            model1.setName("유형주");

            list.add(model1);
        }


        return list;
    }

    /**
     * 삭제대상 구성원목록으로 데이터 삭제하는 STUB 제공.
     *
     * @param targetMemberSnList
     */
    public void deleteByMemberSnList(List<Integer> targetMemberSnList) {
        System.out.println("Model1 데이터 삭제" + targetMemberSnList);
    }
}

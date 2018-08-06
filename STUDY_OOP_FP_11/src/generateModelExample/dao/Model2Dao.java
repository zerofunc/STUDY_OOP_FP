package generateModelExample.dao;

import generateModelExample.vo.GenerateModel2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 모델2 에 대한 저장 컴포넌트 명세.
 *
 * Created by Doohyun on 2017. 7. 10..
 */
public class Model2Dao {

    /**
     * 싱글톤을 위한 매니저 홀더.
     */
    private static final class ManagerHolder {
        private static final Model2Dao unique = new Model2Dao();
    }

    private Model2Dao(){}

    /**
     * Instance 출력.
     *
     * @return
     */
    public static final Model2Dao GetInstance() {
        return Model2Dao.ManagerHolder.unique;
    }

    /**
     * 모델1 데이터 삽입에 대한 STUB 메소드.
     *
     * @param generateModel2
     */
    public void create(GenerateModel2 generateModel2){
        System.out.println("Model2 데이터 저장" + generateModel2);
    }

    /**
     * 데이터 조회 샘플 목록 출력.
     *
     * @param memberSnList
     * @return
     */
    public List<GenerateModel2> selectList(Collection<Integer> memberSnList) {
        ArrayList<GenerateModel2> list = new ArrayList<>();

        // 데이터 샘플1
        {
            GenerateModel2 model2 = new GenerateModel2();
            model2.setMemberSubjectSn(1);
            model2.setName("강현지");

            list.add(model2);
        }

        // 데이터 샘플2
        {
            GenerateModel2 model2 = new GenerateModel2();
            model2.setMemberSubjectSn(2);
            model2.setName("유덕형");

            list.add(model2);
        }

        // 데이터 샘플3
        {
            GenerateModel2 model2 = new GenerateModel2();
            model2.setMemberSubjectSn(3);
            model2.setName("유형주");

            list.add(model2);
        }


        return list;
    }

    /**
     * 삭제대상 구성원목록으로 데이터 삭제하는 STUB 제공.
     *
     * @param targetMemberSnList
     */
    public void deleteByMemberSnList(List<Integer> targetMemberSnList) {
        System.out.println("Model2 데이터 삭제" + targetMemberSnList);
    }

}

package model;

import java.util.Arrays;
import java.util.List;

/**
 * 구성원 정보를 출력하는 서비스
 *
 * Created by Doohyun on 2017. 7. 24..
 */
public class MemberService {

    private static final MemberService Instance = new MemberService();

    private MemberService() {}

    public static MemberService GetInstance() {
        return Instance;
    }

    /**
     * 구성원 정보를 출력하는 메소드.
     *
     * @return
     */
    public List<MemberVo> selectMemberList() {
        return Arrays.asList(
                    new MemberVo(1, "강현지", 25, "경기도")
                    , new MemberVo(2, "남두현", 18, "경기도")
                    , new MemberVo(3, "유덕형", 27,"서울")
                    , new MemberVo(4, "유형주", 21, "인천")
                );
    }

    public List<CommentVo> selectMemberCommentList() {
        return Arrays.asList(
                new CommentVo(1, "공부는 열심히 하고 있나용?")
                , new CommentVo(1, "Java8 은 정말 편리한 듯?")
                , new CommentVo(3, "블로그 조회수가 장난이 아니넹..")
                , new CommentVo(2, "빌더 패턴은 정말 잘했어용. 형오리님!")
                , new CommentVo(4, "OOP 는 잘 쓰고 있나요?"));
    }

}

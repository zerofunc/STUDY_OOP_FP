package help;

/**
 * 구성원 정보
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class MemberVO {
    private String name;
    private Integer memberSubjectSn;

    public MemberVO(Integer memberSubjectSn, String name) {
        this.name = name;
        this.memberSubjectSn = memberSubjectSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMemberSubjectSn() {
        return memberSubjectSn;
    }

    public void setMemberSubjectSn(Integer memberSubjectSn) {
        this.memberSubjectSn = memberSubjectSn;
    }
}

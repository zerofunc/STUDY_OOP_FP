/**
 * Created by user_11 on 2017-08-01.
 */
public class MemberVO {
    private Integer age;
    private String name;
    private Integer memberSn;

    public MemberVO(Integer memberSn, Integer age, String name) {
        this.age = age;
        this.name = name;
        this.memberSn = memberSn;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMemberSn() {
        return memberSn;
    }

    public void setMemberSn(Integer memberSn) {
        this.memberSn = memberSn;
    }
}

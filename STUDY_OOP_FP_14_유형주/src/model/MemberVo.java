package model;

/**
 * 구성원 정보 VO
 *
 * Created by Doohyun on 2017. 7. 24..
 */
public class MemberVo {

    private Integer memberSubjectSn;
    private String name;
    private Integer age;
    private String location;

    /**
     * 구성원 정보 생성.
     *
     * @param memberSubjectSn
     * @param name
     * @param age
     * @param location
     */
    public MemberVo(Integer memberSubjectSn, String name, Integer age, String location) {
        this.memberSubjectSn = memberSubjectSn;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public Integer getMemberSubjectSn() {
        return memberSubjectSn;
    }

    public void setMemberSubjectSn(Integer memberSubjectSn) {
        this.memberSubjectSn = memberSubjectSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

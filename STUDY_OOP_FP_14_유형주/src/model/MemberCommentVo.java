package model;

/**
 * Created by Doohyun on 2017. 7. 24..
 */
public class MemberCommentVo {
    private Integer memberSubjectSn;
    private String name;
    private String comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

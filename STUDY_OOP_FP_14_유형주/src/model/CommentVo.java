package model;

/**
 * 코멘트 정보를 담은 VO
 *
 * Created by Doohyun on 2017. 7. 24..
 */
public class CommentVo {

    private Integer memberSubjectSn;
    private String comment;

    public CommentVo(Integer memberSubjectSn, String comment) {
        this.memberSubjectSn = memberSubjectSn;
        this.comment = comment;
    }

    public Integer getMemberSubjectSn() {
        return memberSubjectSn;
    }

    public void setMemberSubjectSn(Integer memberSubjectSn) {
        this.memberSubjectSn = memberSubjectSn;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

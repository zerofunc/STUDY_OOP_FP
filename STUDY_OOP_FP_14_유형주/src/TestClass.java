import model.CommentVo;
import model.MemberCommentVo;
import model.MemberService;
import model.MemberVo;

import java.util.*;

/**
 * 테스트 클래스.
 *
 * Created by Doohyun on 2017. 7. 24..
 */
public class TestClass {

    /**
     * Java8 in Action 에 따르면, 모든 컬렉션을 이용한 로직은 이론적으로 Stream 으로 변경해야한다고 언급합니다.
     * (꼭 이 것이 옳다고는 보장할 순 없지만 ㅡㅡ^)
     *
     * 어쨌든, 실습으로써, 다음 코드를 리팩토링해봅시다.
     *
     * @param args
     */
    public static void main (String[] args) {
        CollectionProcessingUsingJava8();
    }


    /**
     * Java7 시절 처리했던 컬렉션 처리.
     */
    public static void CollectionProcessingUsingJava7() {

        // 실습 1
        {
            System.out.println("실습 (1)");


            // 구성원 정보 출력.
            List<MemberVo> memberVoList = MemberService.GetInstance().selectMemberList();

            for (MemberVo memberVo : memberVoList) {
                // 구성원 순번이 3 이하인 정보만 출력.
                if (memberVo.getMemberSubjectSn() < 3) {
                    System.out.println(String.format("이름 : %s, 나이 : %d", memberVo.getName(), memberVo.getAge()));
                }
            }
            System.out.println();
        }

        // 실습 2
        {
            System.out.println("실습 (2)");


            // 구성원 정보 출력.
            List<MemberVo> memberVoList = MemberService.GetInstance().selectMemberList();

            // 나이 순으로 내림차순 정렬,
            Collections.sort(memberVoList, new Comparator<MemberVo>() {
                @Override
                public int compare(MemberVo o1, MemberVo o2) {
                    return o2.getAge().compareTo(o1.getAge());
                }
            });

            // 구성원 목록이 존재할 경우, 나이가 가장 많은 사람의 이름을 출력.
            if (!memberVoList.isEmpty()) {
                MemberVo memberVo = memberVoList.get(0);

                System.out.println(String.format("나이가 가장 많은 사람은 ? %s", memberVo.getName()));
            }
            System.out.println();
        }

        // 실습 3
        {
            // 구성원들이 살고 있는 지역을 오름차순으로 정렬하고, 중복 없게 출력
            System.out.println("실습 (3)");

            // 구성원 정보 출력.
            List<MemberVo> memberVoList = MemberService.GetInstance().selectMemberList();

            // red-black tree 알고리즘 따라, 이 곳에 넣은 정보는 자동으로 정렬이 됨.
            final TreeSet<String> treeSet = new TreeSet<>();
            {
                for (MemberVo memberVo : memberVoList) {
                    treeSet.add(memberVo.getLocation());
                }
            }

            for (String location : treeSet) {
                System.out.println(location);
            }
            System.out.println();
        }

        // 실습 4
        {
            // 구성원들이 살고 있는 지역을 오름차순으로 정렬하고, 중복 없게 출력
            System.out.println("실습 (4)");

            // 구성원 정보 출력.
            List<MemberVo> memberVoList = MemberService.GetInstance().selectMemberList();

            // 코멘트 정보 출력.
            List<CommentVo> commentVoList = MemberService.GetInstance().selectMemberCommentList();

            final ArrayList<MemberCommentVo> memberCommentVoList = new ArrayList<>();
            {
                // 구성원 정보와 코멘트 정보를 엮는다.
                for (MemberVo memberVo : memberVoList) {
                    for (CommentVo commentVo : commentVoList) {
                        if (memberVo.getMemberSubjectSn().intValue() == commentVo.getMemberSubjectSn().intValue()) {
                            MemberCommentVo memberCommentVo = new MemberCommentVo();
                            memberCommentVo.setMemberSubjectSn(memberVo.getMemberSubjectSn());
                            memberCommentVo.setComment(commentVo.getComment());
                            memberCommentVo.setName(memberVo.getName());

                            memberCommentVoList.add(memberCommentVo);
                        }
                    }
                }

                // 이름으로 정렬.
                Collections.sort(memberCommentVoList, new Comparator<MemberCommentVo>() {
                    @Override
                    public int compare(MemberCommentVo o1, MemberCommentVo o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
            }

            // 오직 세개까지만 처리.
            for (int i = 0, size = memberCommentVoList.size(); i < 3; ++i) {
                MemberCommentVo memberCommentVo = memberCommentVoList.get(i);

                System.out.println(String.format("%s : %s", memberCommentVo.getName(), memberCommentVo.getComment()));
            }

        }
    }

    /**
     * Java8 Stream 을 이용한 컬렉션 처리
     * @Author YooHyeongJu
     */
    public static void CollectionProcessingUsingJava8() {
        // TODO CollectionProcessingUsingJava7 의 로직을 Stream API 를 이용하여, 리팩토링 해보자!
        // 실습 1
        {
            System.out.println("실습 (1)");


            // 구성원 정보 출력.
            List<MemberVo> memberVoList = MemberService.GetInstance().selectMemberList();

            // 구성원 순번이 2 이하인 정보만 출력.
            memberVoList.stream()
                    .filter(memberVo -> memberVo.getMemberSubjectSn().intValue() <= 2)
                    .forEach(memberVo -> System.out.println(String.format("이름 : %s, 나이 : %d", memberVo.getName(), memberVo.getAge())));
            System.out.println();
        }

        // 실습 2
        {
            System.out.println("실습 (2)");

            // 구성원 정보 출력.
            List<MemberVo> memberVoList = MemberService.GetInstance().selectMemberList();

            // 나이 순으로 내림차순 정렬해서 기장 나이많은 멤버를 출력,
            memberVoList.stream()
                    .sorted(Comparator.comparing(MemberVo::getAge).reversed())
                    .limit(1)
                    .forEach(memberVo -> System.out.println(String.format("나이가 가장 많은 사람은 ? %s", memberVo.getName())));

            System.out.println();
        }

        // 실습 3
        {
            // 구성원들이 살고 있는 지역을 오름차순으로 정렬하고, 중복 없게 출력
            System.out.println("실습 (3)");

            // 구성원 정보 출력.
            List<MemberVo> memberVoList = MemberService.GetInstance().selectMemberList();


            memberVoList.stream()
                    .sorted(Comparator.comparing(MemberVo::getLocation))
                    .map(MemberVo::getLocation)
                    .distinct()
                    .forEach(System.out::println);

            System.out.println();
        }

        // 실습 4
        {
            // 구성원들이 살고 있는 지역을 오름차순으로 정렬하고, 중복 없게 출력
            System.out.println("실습 (4)");

            // 구성원 정보 출력.
            List<MemberVo> memberVoList = MemberService.GetInstance().selectMemberList();

            // 코멘트 정보 출력.
            List<CommentVo> commentVoList = MemberService.GetInstance().selectMemberCommentList();

            memberVoList.stream().flatMap(memberVO ->
                    commentVoList.stream()
                    .filter(commentVO-> commentVO.getMemberSubjectSn().intValue() == memberVO.getMemberSubjectSn().intValue())
                    .map(commentVO -> {
                        // 구성원 정보와 코멘트 정보를 엮는다.
                        MemberCommentVo memberCommentVo = new MemberCommentVo();
                        memberCommentVo.setComment(commentVO.getComment());
                        memberCommentVo.setMemberSubjectSn(memberVO.getMemberSubjectSn());
                        memberCommentVo.setName(memberVO.getName());
                        return memberCommentVo;
                    }))
                    .sorted(Comparator.comparing(MemberCommentVo::getName))
                    .limit(3)
                    .forEach(memberCommentVo -> {
                            System.out.println(String.format("%s : %s", memberCommentVo.getName(), memberCommentVo.getComment()));
                    });
        }
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by user_11 on 2017-08-01.
 */
public class TestClass {
    public static void main(String[] args) {

        /**
         * 구성원 그룹 제작.
         *
         * key : 구성원 순번
         * value : 구성원 정보
         */
        final Map<Integer, MemberVO> memberVOMap;
        {
            List<MemberVO> memberVOList = Arrays.asList(new MemberVO(1, 25, "강현지")
                    , new MemberVO(2, 21, "유형주"), new MemberVO(3, 28, "남두현"));


            memberVOMap = memberVOList.stream()
                    .collect(Collectors.toMap(MemberVO::getMemberSn, Function.identity()));
        }

        /**
         * 구성원 순번에 따른, 조직 VO 그룹
         *
         * key : 구성원 순번
         * value : 조직 VO
         */
        final Map<Integer, OrganizationVO> organizationVOMap;
        {
            List<OrganizationVO> organizationVOList = Arrays.asList(
                    new OrganizationVO(1, "행복개발팀")
                    , new OrganizationVO(2, "망한팀")
                    , new OrganizationVO(3, "집밥팀")
            );

            organizationVOMap = organizationVOList.stream().collect(Collectors.toMap(OrganizationVO::getMemberSn,
                    Function.identity()));

        }

        final List<MemberOrgVO> resultList;
        {
            List<MemberOrgVO> collect = memberVOMap.keySet()
                    .stream()
                    .map(memberSn -> {
                        MemberOrgVO result = new MemberOrgVO();
                        OrganizationVO organizationVO = organizationVOMap.get(memberSn);
                        MemberVO memberVO = memberVOMap.get(memberSn);

                        Optional.ofNullable(organizationVOMap.get(memberSn))
                                .map(OrganizationVO::getOrgName)
                                .ifPresent(result::setOrgName);
                        result.setMemberSn(memberVO.getMemberSn());
                        result.setName(memberVO.getName());

                        return result;
                    }).collect(Collectors.toList());

        }


    }
}

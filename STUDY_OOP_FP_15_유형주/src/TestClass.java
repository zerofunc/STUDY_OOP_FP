/**
 * 언제나 기본은 이 곳에서 시작하지!
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class TestClass {

    public static void main(String[] args) {
        // 이번 숙제 역시, 기존 Java8 이전의 행위를 열람합니다.
        // 이를 Java8 버전으로 리팩토링 하는 것을 목표로 합니다.
        // 지난번과 달리, 꼭 한태스크일 필요는 없습니다.
        // 또한, 구현된 로직과 달라도 결과만 같으면 상관없습니다. (꼭, Java7 을 Java8 으로 컨버팅만 하는 것을 생각하지 마세요.)
        // 답은 존재하지 않으며, 최대한 본인이 좋은 코드라고 생각되는 방향을 제시해서 작성해보세요. :-)

        // Test 는 다음과 같이 실행.
        RunIQ(new Q4());
    }

    public static void RunIQ(IQ iq) {
        System.out.println("java8 이전 메소드 실행");
        iq.자바8_이전_행위_열람();

        System.out.println("\n\njava8 메소드 실행");
        iq.자바8_행위_열람();
    }
}

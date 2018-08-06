import java.util.stream.IntStream;

/**
 * break 문 리팩토링.
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class Q2 implements IQ {

    /**
     * 50 보다 큰 첫 홀수 출력.
     */
    @Override
    public void 자바8_이전_행위_열람() {

        for (int i = 0; i < 100; ++i) {
            if (i > 50 && i % 2 == 1) {
                System.out.println(i);
                break;
            }
        }

    }

    /**
     * @Author YooHyeongJu
     */
    @Override
    public void 자바8_행위_열람() {
        IntStream.range(1, 100)
                .filter( i -> (i > 50 && i % 2== 1))
                .findFirst().ifPresent(i-> System.out.println(i));
    }
}

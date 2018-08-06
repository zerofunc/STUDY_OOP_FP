import java.util.stream.IntStream;

/**
 * 1~1000 사이의 짝수합 구하기.
 *
 * Created by Doohyun on 2017. 7. 30..
 */
public class Q1 implements IQ{

    @Override
    public void 자바8_이전_행위_열람() {
        int sum = 0;

        for (int i = 1; i <= 1000; ++i) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    /**
     * @Author YooHyeongJu
     */
    @Override
    public void 자바8_행위_열람() {
        int sum = IntStream.rangeClosed(1, 1000)
                .filter(n -> n % 2 == 0)
                .sum();

        System.out.println(sum);
    }
}

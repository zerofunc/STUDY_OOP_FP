import command.ICommand;
import command.TextWatcherController;
import command.TextWatcherDemo;
import generateModelExample.ModelSampleService;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * 테스트 클래스 정의.
 *
 * Created by Doohyun on 2017. 7. 10..
 */
public class TestClass {

    public static void main(String[] args) {
        TestForUndoRedo();
    }

    /**
     * Generate Model 테스팅.
     *
     * <pre>
     *     관련 URL : http://doohyun.tistory.com/67
     * </pre>
     *
     */
    public static void TestForModelGenerate() {
        // 리팩토링 대상 메소드1
        ModelSampleService.GetInstance().switchAndSwitch();

        // 리팩토링 대상 메소드2.
        ModelSampleService.GetInstance().createByGenerateModel(Arrays.asList(1, 2,4), Arrays.asList(3));
    }

    /**
     * undo/redo 를 수행하기 위한 기능.
     *
     * <pre>
     *     관련 URL : http://doohyun.tistory.com/91
     * </pre>
     *
     */
    public static void TestForUndoRedo() {
        // UNDO, REDO 기능을 만들어볼 것.
        // 명령패턴은 명령자체를 캡슐화하는 것을 목적으로, 캡슐화한 명령 객체들을 관리/실행함.
        // 모든 명령을 굳이 클래스화 시킬 필요있을까 ??
        TextWatcherDemo textWatcherDemo = new TextWatcherDemo();

        TextWatcherController textWatcherController = new TextWatcherController();
        BiFunction<TextWatcherDemo, String, ICommand> textWatcherFunction = (TextWatcherDemo t, String str) -> {
            return new ICommand() {
                @Override
                public void undo() {
                    t.deleteText();
                }

                @Override
                public void execute() {
                    t.addText(str);
                }

            };

        };

        textWatcherController.setCommand(textWatcherFunction.apply(textWatcherDemo, "a"));
        textWatcherController.execute();
        textWatcherController.setCommand(textWatcherFunction.apply(textWatcherDemo, "b"));
        textWatcherController.execute();
        textWatcherController.setCommand(textWatcherFunction.apply(textWatcherDemo, "c"));
        textWatcherController.execute();
        textWatcherController.undo();
        textWatcherController.undo();
        textWatcherController.setCommand(textWatcherFunction.apply(textWatcherDemo, "d"));
        textWatcherController.execute();
        textWatcherController.undo();

    }
}

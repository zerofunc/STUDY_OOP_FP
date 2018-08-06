package command;

/**
 * 커맨드 인터페이스 정의.
 *
 * Created by Doohyun on 2017. 7. 10..
 */
public interface ICommand {

    /**
     * 어떤기능이든 undo 구현.
     */
    void undo();

    /**
     * 어떤기능이든 실행 구현.
     */
    void execute();
}

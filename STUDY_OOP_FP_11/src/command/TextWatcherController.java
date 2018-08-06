package command;

import java.util.Stack;

/**
 * Created by YooHyeongJu on 2017-07-15.
 */
public class TextWatcherController {
    // 명령 스택
    private Stack<ICommand> commandStack = new Stack<ICommand>();
    // UNDO 명령 스택
    private Stack<ICommand> undoStack = new Stack<ICommand>();

    /**
     * 명령 스택에 넣기
     * @param commandWithUndoable
     * @Author YooHyeongJu
     */
    public void setCommand(ICommand commandWithUndoable) {
        commandStack.push(commandWithUndoable);
    }

    /**
     * 명령 실행
     * @Author YooHyeongJu
     */
    public void execute() {
        if(!commandStack.isEmpty()) {
            // 스택 가장 마지막 객체 추출 후 실행
            ICommand command = commandStack.pop();
            command.execute();

            // 명령을 undo Stack에 넣음
            undoStack.push(command);
        }
    }

    /**
     * 실행 취소
     * @Author YooHyeongJu
     */
    public void undo() {
        if(!undoStack.isEmpty()) {
            // UNDO스택 가장 마지막 객체 추출 후 UNDO 실행
            ICommand command = undoStack.pop();
            command.undo();

            // 명령 스택에 데이터 삽입입
           commandStack.push(command);
        }
    }

}

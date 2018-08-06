package command;

/**
 * 글씨를 입력하는 데모 클래스.
 *
 * Created by Doohyun on 2017. 7. 10..
 */
public class TextWatcherDemo {

    private StringBuilder builder = new StringBuilder("");

    /**
     * 텍스트 입력.
     *
     * <pre>
     *     텍스트를 입력하고, 현재 상태를 표시한다.
     * </pre>
     *
     * @param text
     */
    public void addText(String text) {
        builder.append(text);
        System.out.println(builder.toString());
    }

    /**
     * 텍스트 삭제.
     *
     * <pre>
     *     텍스트를 삭제하고, 현재 상태를 표시한다.
     * </pre>
     */
    public void deleteText() {
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }
}

package CourseWork2code;

public class IncorrectArgumentException extends Exception {
    private final String title;


    public IncorrectArgumentException(String message, String title) {
        super(message);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "*** IncorrectArgumentException - некорректный титул задачи ***";
    }
}

package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

//    public DailyTask(String title, Type type, String description, LocalDateTime dateTime) {
//        super(title, type, description, dateTime);

//    }
    public DailyTask(String title, Type type, String description) {
        super(title, type, description);

    }
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return true;
    }

    @Override
    public String toString() {
        return "Ежедневная задача № " + getId() +
                " : " + getTitle() + " (" + getType() + "), время создания = " + getDateTime() +
                "\n краткое описание: " + getDescription();
    }
}

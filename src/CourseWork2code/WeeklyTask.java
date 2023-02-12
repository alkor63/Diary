package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        if (inputDate.getDayOfWeek() == taskDate.getDayOfWeek())
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Еженедельная задача № " + getId() +
                " : " + getTitle() + " (" + getType() + "), время создания = " + getDateTime() +
                "\n краткое описание: " + getDescription();
    }
}

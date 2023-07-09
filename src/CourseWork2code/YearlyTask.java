package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;
// Ежегодная задача
public class YearlyTask extends Task {

    public YearlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getMonth() == taskDate.getMonth() && inputDate.getDayOfMonth() == taskDate.getDayOfMonth();
    }

    @Override
    public String toString() {
        return "Ежегодная задача № " + getId() +
                " : " + getTitle() + " (" + getType() + "), время создания = " + getDateTime() +
                "\n краткое описание: " + getDescription();
    }
}

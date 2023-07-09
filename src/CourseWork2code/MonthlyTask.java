package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;
// Ежемесячные задачи
public class MonthlyTask extends Task {

    public MonthlyTask(String title, Type type, String description) {
        super(title, type, description);

    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return inputDate.getDayOfMonth() == taskDate.getDayOfMonth();
    }


    @Override
    public String toString() {
        return "Ежемесячная задача № " + getId() +
                " : " + getTitle() + " (" + getType() + "), время создания = " + getDateTime() +
                "\n краткое описание: " + getDescription();
    }
}

package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;
// Одноразовая задача
public class OneTimeTask extends Task {

    public OneTimeTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return false;
    }

    @Override
    public String toString() {
        return "Одноразовая задача № " + getId() +
                " : " + getTitle() + " (" + getType() + "), время создания = " + getDateTime() +
                "\n краткое описание: " + getDescription();
    }
}

package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    private final LocalDateTime dateTime;
    private final Integer id;

    public OneTimeTask(String title, Type type, String description) {
        super(title, type, description);
        this.id = idGenerator;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return false;
    }

    @Override
    public String toString() {
        return "Одноразовая задача № " + id +
                " : " + getTitle() + " (" + getType() + "), время создания = " + dateTime +
                "\n краткое описание: " + getDescription();
    }
}

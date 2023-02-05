package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    //        implements Comparable
    private final LocalDateTime dateTime;
    private final Integer id;

    public YearlyTask(String title, Type type, String description) {
        super(title, type, description);
        this.id = idGenerator;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        if (inputDate.getMonth() == taskDate.getMonth() && inputDate.getDayOfMonth() == taskDate.getDayOfMonth())
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Ежегодная задача № " + id +
                " : " + getTitle() + " (" + getType() + "), время создания = " + dateTime +
                "\n краткое описание: " + getDescription();
    }
}

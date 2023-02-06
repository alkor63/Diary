package CourseWork2code;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    //        implements Comparable
    private final Integer id;
    private final LocalDateTime dateTime;

//    public DailyTask(String title, Type type, String description, LocalDateTime dateTime) {
//        super(title, type, description, dateTime);
//        this.id = idGenerator;
//        this.dateTime = LocalDateTime.now();
//    }
    public DailyTask(String title, Type type, String description) {
        super(title, type, description);
        this.id = idGenerator;
        this.dateTime = LocalDateTime.now();
    }
    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskDate) {
        return true;
    }

    @Override
    public String toString() {
        return "Ежедневная задача № " + id +
                " : " + getTitle() + " (" + getType() + "), время создания = " + dateTime +
                "\n краткое описание: " + getDescription();
    }
}

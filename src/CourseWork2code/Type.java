package CourseWork2code;

public enum Type {
    WORK("РАБОЧАЯ"),
    PERSONAL("ЛИЧНАЯ");

    private final String taskType;

    Type(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        return " тип задачи - " + taskType;
    }
}

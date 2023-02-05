import CourseWork2code.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static CourseWork2code.TaskService.*;

public class Main {
    public static void main(String[] args) {
        OneTimeTask task1 = new OneTimeTask("Task #1 oneTime", Type.WORK, null);
        OneTimeTask task2 = new OneTimeTask("Task #2 oneTime", Type.PERSONAL, "Barbershop");
        OneTimeTask task3 = new OneTimeTask("Task #3 oneTime", Type.WORK, " ");
        DailyTask task4 = new DailyTask("Task #4 daily", Type.WORK, "Проверить почту");
        DailyTask task5 = new DailyTask("Task #5 daily", Type.PERSONAL, "почистить зубы");
        WeeklyTask task6 = new WeeklyTask("Task #6 weekly", Type.PERSONAL, "cleaning");
        MonthlyTask task7 = new MonthlyTask("Task #7 monthly", Type.WORK, "monthly report");
        YearlyTask task8 = new YearlyTask("Task #8 yearly", Type.WORK, "чей-то день рождения");

// вместо списка используем мапу
        Map<Integer, Task> tasks = new HashMap<>();
        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
        tasks.put(task3.getId(), task3);
        tasks.put(task4.getId(), task4);
        tasks.put(task5.getId(), task5);
        tasks.put(task6.getId(), task6);
        tasks.put(task7.getId(), task7);
        tasks.put(task8.getId(), task8);
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu1();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, tasks);
                            break;
                        case 2:
                            removeId(tasks);
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3 (Получить задачу на указанный день)
                            LocalDate date = inputDate();
                            System.out.println("Задачи на дату " + date);
                            getAllByDate(tasks, date);
                            break;
                        case 4:
                            getRemovedTasks();
                            break;
                        case 5:
                            updateTitle(tasks);
                            break;
                        case 6:
                            updateDescription(tasks);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("+++++ Выберите пункт меню из списка (введите ЦИФРУ от 0 до 6) ! +++++");
                }
            }
        }
        System.out.println(" *** итоговый список задач ежедневника: ***");
        for (Map.Entry<Integer, Task> tasK : tasks.entrySet())
            System.out.println("id = " + tasK.getKey() + " task = " + tasK.getValue());
    }

    private static void printMenu1() {
        System.out.println("\n1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n" +
                "4. Показать архив удаленных задач\n5. Отредактировать титул задачи\n" +
                "6. Добавить/изменить описание задачи\n0. Выход");
    }
}
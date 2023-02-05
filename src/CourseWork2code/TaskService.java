package CourseWork2code;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    static Set<Task> taskSet = new HashSet<>();

    public static void inputTask(Scanner scanner, Map<Integer, Task> tasks) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        try {
            Task.checkTitle(taskName);
        } catch (IncorrectArgumentException e) {
            System.out.println("title = " + taskName + "\n" + e.getMessage());
            throw new IllegalArgumentException();
        }
        System.out.print("Введите краткое описание задачи: ");
        String taskDescription = scanner1.next();
        System.out.print("\n *** Выберите тип задачи:\n 1 - рабочая (Work)\n 2 - личная (Personal)\n ваш выбор? :");
        Type taskTyp;

        int menu2 = scanner2.nextInt();

        switch (menu2) {
            case 1:
                taskTyp = Type.WORK;
                break;
            case 2:
                taskTyp = Type.PERSONAL;
                break;
            default: {
                System.out.println("ТИП задачи указан невнрно, ты всё сломал !");
                taskTyp = Type.valueOf("ЛИЧНАЯ");
            }
        }

        System.out.print("\n *** Выберите повторяемость задачи:\n 1 - однократная\n" +
                " 2 - ежедневная\n 3 - еженедельная\n" +
                " 4 - ежемесячная\n 5 - ежегодная\n" +
                "ваш выбор? :");
        Task task9;
        int menu = scanner2.nextInt();
        switch (menu) {
            case 1:
                task9 = new OneTimeTask(taskName, taskTyp, taskDescription);
                break;
            case 2:
                task9 = new DailyTask(taskName, taskTyp, taskDescription);
                break;
            case 3:
                task9 = new WeeklyTask(taskName, taskTyp, taskDescription);
                break;
            case 4:
                task9 = new MonthlyTask(taskName, taskTyp, taskDescription);
                break;
            case 5:
                task9 = new YearlyTask(taskName, taskTyp, taskDescription);
                break;
            default: {
                System.out.println("ПОВТОРЯЕМОСТЬ задачи указана невнрно, ты всё сломал !");
                task9 = new OneTimeTask(taskName, taskTyp, taskDescription);
            }
        }
//        if (!tasks.contains(task9)) tasks.add(task9);
        tasks.put(task9.getId(), task9);
        System.out.println("Вот что вы навводили:\n" + task9);
    }

    public static void updateDescription(Map<Integer, Task> tasks) {
        Scanner scannerId = new Scanner(System.in);
        System.out.print("Введите номер (int id) задачи, описание которой нужно изменить: ");
        Integer id = scannerId.nextInt();
        try {
            checkId(tasks, id);
            Scanner scannerD = new Scanner(System.in);
            System.out.print("Введите новое описание задачи: ");
            String description = scannerD.nextLine();
            tasks.get(id).setDescription(description);
            System.out.println("*** У задачи с id= " + id + " новое описание: " + tasks.get(id).getDescription());
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage() + id + " ***");
        }
    }

    public static void getRemovedTasks() {
        if (taskSet.size() > 0) {
            System.out.println("+++      в нашем архиве " + taskSet.size() + " удаленных задач     +++");
            System.out.println("   выводим их список через Итератор :");
            Iterator<Task> iter = taskSet.iterator();
            while (iter.hasNext()) {
                Task next = iter.next();
                System.out.println(next);
            }
        } else System.out.println("+++      в нашем архиве нет удаленных задач     +++");
    }

    public static void removeId(Map<Integer, Task> tasks) {
        Scanner scannerId = new Scanner(System.in);
        System.out.print("Введите номер (int id) задачи, которую нужно удалить: ");
        Integer id = scannerId.nextInt();
        try {
            checkId(tasks, id);
            Task task = tasks.get(id);
            taskSet.add(task);
            tasks.remove(id);
            System.out.println("*** Задача с id= " + id + " удаленна из списка и перемещена в архив");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage() + id + " ***");
        }
    }


    public static void updateTitle(Map<Integer, Task> tasks) {
        Scanner scannerId = new Scanner(System.in);
        System.out.print("Введите номер (int id) задачи, титул которой нужно изменить: ");
        Integer id = scannerId.nextInt();
        try {
            checkId(tasks, id);
            Scanner scannerT = new Scanner(System.in);
            System.out.print("Введите новое название задачи: ");
            String taskName = scannerT.nextLine();
            tasks.get(id).setTitle(taskName);
            System.out.println("*** У задачи с id= " + id + " новый титул: " + tasks.get(id).getTitle());

        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage() + id + " ***");
        }
    }

    public static void getAllByDate(Map<Integer, Task> tasks, LocalDate date) {
//        System.out.println("Задачи на дату " + date);
        int i = 0;
        for (Map.Entry<Integer, Task> task : tasks.entrySet()) {
            LocalDate taskDate = task.getValue().getDateTime().toLocalDate();
            if (taskDate.equals(date) || task.getValue().appearsIn(date, taskDate)) {
                i++;
                System.out.println(task);
            }
        }
        if (i < 1) System.out.println("не обнаружены");
    }

    public static LocalDate inputDate() {
        Scanner scannerD = new Scanner(System.in);
        System.out.println("Какая дата вас интересует?");
        System.out.print("Введите день: ");
        int d = scannerD.nextInt();
        System.out.print("Введите месяц: ");
        int m = scannerD.nextInt();
        System.out.print("Введите год [гггг]: ");
        int y = scannerD.nextInt();
        if (y < 100) y += 2000;
        return LocalDate.of(y, m, d);
    }

    public static void checkId(Map<Integer, Task> tasks, int id) throws TaskNotFoundException {
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException("*** в нашем списке нет задачи с номером ");
        }
    }
}


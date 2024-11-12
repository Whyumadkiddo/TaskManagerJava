import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("1. Задание на сегодня");
            System.out.println("2. Задание на дату");
            System.out.println("3. Посмотреть задачи на сегодня");
            System.out.println("4. Посмотреть задачи на определенную дату");
            System.out.println("5. Посмотреть историю задач");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Название задачи:");
                    String title = scanner.nextLine();
                    System.out.println("Текст задачи:");
                    String text = scanner.nextLine();
                    taskManager.addTask(new Task(title, new Date(), text));
                    break;
                case 2:
                    System.out.println("Название задачи:");
                    title = scanner.nextLine();
                    System.out.println("Дата (dd/MM/yyyy):");
                    Date date = dateFormat.parse(scanner.nextLine());
                    System.out.println("Текст задачи:");
                    text = scanner.nextLine();
                    taskManager.addTask(new Task(title, date, text));
                    break;
                case 3:
                    List<Task> tasks = taskManager.getTasksForDate(new Date());
                    for (Task task : tasks) {
                        System.out.println(task.getTitle() + ": " + task.getText());
                    }
                    break;
                case 4:
                    System.out.println("Напишите дату (dd/MM/yyyy):");
                    Date viewDate = dateFormat.parse(scanner.nextLine());
                    tasks = taskManager.getTasksForDate(viewDate);
                    for (Task task : tasks) {
                        System.out.println(task.getTitle() + ": " + task.getText());
                    }
                    break;
                case 5:
                    List<Task> history = taskManager.getHistory();
                    for (Task task : history) {
                        System.out.println(task.getTitle() + " (" + dateFormat.format(task.getDate()) + "): " + task.getText());
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Неправильный выбор");
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private List<Task> history;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasksForDate(Date date) {
        List<Task> tasksForDate = new ArrayList<>();
        for (Task task : tasks) {
            if (isSameDay(task.getDate(), date)) {
                tasksForDate.add(task);
                if (!history.contains(task)) {
                    history.add(task);
                }
            }
        }
        return tasksForDate;
    }

    private boolean isSameDay(Date date1, Date date2) {
        return date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth() && date1.getDate() == date2.getDate();
    }

    public List<Task> getHistory() {
        return history;
    }
}

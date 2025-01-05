import java.io.*;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;
    private final String FILE_NAME = "tasks.dat";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasksToFile();
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            saveTasksToFile();
        }
    }

    public void checkForOverdueTasks() {
        for (Task task : tasks) {
            if (task.isOverdue()) {
                System.out.println("Overdue Task: " + task.getDescription() + " - Deadline: " + task.getDeadline());
            }
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Task> getPendingTasks() {
        ArrayList<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted() && !task.isOverdue()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }

    public ArrayList<Task> getCompletedTasks() {
        ArrayList<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    private void saveTasksToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasksFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (ArrayList<Task>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudyAssistantGUI extends JFrame {
    private TaskManager taskManager;
    private JTextArea taskListArea;
    private JTextField descriptionField, deadlineField;

    public StudyAssistantGUI() {
        taskManager = new TaskManager();
        setTitle("Virtual Study Assistant");
        setLayout(new BorderLayout());

        // Create UI components
        descriptionField = new JTextField(20);
        deadlineField = new JTextField(20);
        taskListArea = new JTextArea(10, 30);
        taskListArea.setEditable(false);

        JButton addButton = new JButton("Add Task");
        JButton markCompletedButton = new JButton("Mark Completed");
        JButton deleteButton = new JButton("Delete Task");
        JButton viewPendingButton = new JButton("View Pending Tasks");
        JButton viewCompletedButton = new JButton("View Completed Tasks");
        JButton viewOverdueButton = new JButton("View Overdue Tasks");

        // Set up the layout
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Task Description:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Deadline (yyyy-MM-dd HH:mm):"));
        inputPanel.add(deadlineField);
        inputPanel.add(addButton);

        JPanel taskPanel = new JPanel();
        taskPanel.add(new JScrollPane(taskListArea));
        taskPanel.add(markCompletedButton);
        taskPanel.add(deleteButton);
        taskPanel.add(viewPendingButton);
        taskPanel.add(viewCompletedButton);
        taskPanel.add(viewOverdueButton);

        add(inputPanel, BorderLayout.NORTH);
        add(taskPanel, BorderLayout.CENTER);

        // Add action listeners for buttons
        addButton.addActionListener(e -> addTask());
        markCompletedButton.addActionListener(e -> markTaskCompleted());
        deleteButton.addActionListener(e -> deleteTask());
        viewPendingButton.addActionListener(e -> viewPendingTasks());
        viewCompletedButton.addActionListener(e -> viewCompletedTasks());
        viewOverdueButton.addActionListener(e -> viewOverdueTasks());

        // Display the frame
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addTask() {
        String description = descriptionField.getText();
        String dateInput = deadlineField.getText();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            Date deadline = formatter.parse(dateInput);
            Task newTask = new Task(description, deadline);
            taskManager.addTask(newTask);
            updateTaskList();
            descriptionField.setText("");
            deadlineField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format! Please use yyyy-MM-dd HH:mm.");
        }
    }

    private void markTaskCompleted() {
        String selectedTaskText = taskListArea.getSelectedText();
        if (selectedTaskText != null && !selectedTaskText.isEmpty()) {
            ArrayList<Task> tasks = taskManager.getTasks();
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).toString().equals(selectedTaskText)) {
                    taskManager.markTaskAsCompleted(i);
                    updateTaskList();
                    return;
                }
            }
        }
    }

    private void deleteTask() {
        String selectedTaskText = taskListArea.getSelectedText();
        if (selectedTaskText != null && !selectedTaskText.isEmpty()) {
            ArrayList<Task> tasks = taskManager.getTasks();
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).toString().equals(selectedTaskText)) {
                    taskManager.deleteTask(i);
                    updateTaskList();
                    return;
                }
            }
        }
    }

    private void viewPendingTasks() {
        ArrayList<Task> pendingTasks = taskManager.getPendingTasks();
        displayTasks(pendingTasks);
    }

    private void viewCompletedTasks() {
        ArrayList<Task> completedTasks = taskManager.getCompletedTasks();
        displayTasks(completedTasks);
    }

    private void viewOverdueTasks() {
        taskManager.checkForOverdueTasks();
    }

    private void displayTasks(ArrayList<Task> tasks) {
        taskListArea.setText("");
        for (Task task : tasks) {
            taskListArea.append(task.toString() + "\n");
        }
    }

    private void updateTaskList() {
        displayTasks(taskManager.getTasks());
    }

    public static void main(String[] args) {
        new StudyAssistantGUI();
    }
}

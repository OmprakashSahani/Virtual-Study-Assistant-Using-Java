import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private String description;
    private Date deadline;
    private boolean isCompleted;

    public Task(String description, Date deadline) {
        this.description = description;
        this.deadline = deadline;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public boolean isOverdue() {
        return new Date().after(deadline) && !isCompleted;
    }

    @Override
    public String toString() {
        return description + " - Deadline: " + deadline.toString() + 
               (isCompleted ? " [Completed]" : (isOverdue() ? " [Overdue]" : " [Pending]"));
    }
}

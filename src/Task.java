public class Task implements Comparable<Task> {

    private String assignee;
    private String projectName;
    private String description;
    private Enum status = Status.NONE;
    private Enum priority = Priority.MEDIUM;


    public Task(String assignee, String projectName, String description, Enum priority, Enum status) {
        this.assignee = assignee;
        this.projectName = projectName;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "%-12s %-20s %-20s %-20s %-10s".formatted(assignee, projectName, description, status, priority);
    }

    @Override
    public int compareTo(Task o) {
        int result = projectName.compareTo(o.projectName);
        if (result == 0) {
            result = description.compareTo(o.description);
        }
        return result;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Enum getPriority() {
        return priority;
    }

    public void setPriority(Enum priority) {
        this.priority = priority;
    }
}

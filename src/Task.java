public class Task implements Comparable<Task> {

    private String assignee;
    private String projectName;
    private String description;
    private Status status;
    private Priority priority;


    public Task(String projectName, String description, Priority priority) {
        this(projectName, description, priority, null);
    }

    public Task(String projectName, String description, Priority priority, String assignee) {
        this(projectName, description, priority, assignee,
                assignee == null ? Status.IN_QUEUE : Status.ASSIGNED);
    }

    public Task(String projectName, String description, Priority priority, String assignee, Status status) {
        this.assignee = assignee;
        this.projectName = projectName;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-20s %-10s".formatted(projectName, description, priority, assignee, status);
    }

    @Override
    public int compareTo(Task o) {
        int result = projectName.compareTo(o.projectName);
        if (result == 0) {
            result = description.compareTo(o.description);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;
        return getProjectName().equals(task.getProjectName()) && getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProjectName().hashCode();
        result = 31 * result + getDescription().hashCode();
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}

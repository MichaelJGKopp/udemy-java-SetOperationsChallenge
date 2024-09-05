import java.util.Collection;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Task> allTasks = TaskData.getData("all");
        Set<Task> annsTasks = TaskData.getData("Ann");
        Set<Task> bobsTasks = TaskData.getData("Bob");
        Set<Task> carolsTasks = TaskData.getData("Carol");

        printTasks(allTasks);
        printTasks(annsTasks);
        printTasks(bobsTasks);
        printTasks(carolsTasks);

    }

    public static void printTasks(Collection<Task> collection) {
        printList("%-12s %-20s %-20s %-20s %-10s"
                .formatted("Assignee", "ProjectName", "Description", "Status", "Priority"),
                collection);
    }

    public static void printList(String header, Collection<?> collection) {
        System.out.println("-----------------------------------------------".repeat(2));
        System.out.println(header);
        System.out.println("-----------------------------------------------".repeat(2));
        collection.forEach(System.out::println);
        System.out.println();
    }

}

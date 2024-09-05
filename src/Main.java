import java.util.*;

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
        printList("%-20s %-25s %-10s %-20s %-10s"
                .formatted("ProjectName", "Description", "Priority", "Assignee", "Status"),
                collection, Comparator.comparing(Task::getPriority).thenComparing(Task::getStatus));
    }

    public static <T> void printList(String header, Collection<T> collection, Comparator<T> comparator) {
        System.out.println("-".repeat(90));
        System.out.println(header);
        System.out.println("-".repeat(90));
        List<T> list = new ArrayList<>(collection);
        list.sort(comparator);
        list.forEach(System.out::println);
        System.out.println();
    }

}

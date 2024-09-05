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

        System.out.println("All Tasks");
        Set<Task> all = getUnion(List.of(annsTasks, bobsTasks, carolsTasks, allTasks));
        printTasks(all);
        System.out.println();

        System.out.println("Assigned Tasks");
        Set<Task> assigned = getUnion(List.of(annsTasks, bobsTasks, carolsTasks));
        printTasks(assigned);
        System.out.println();

        System.out.println("Unassigned Tasks");
        Set<Task> unassigned = getDifference(all, assigned);
        printTasks(unassigned);
        System.out.println();

        System.out.println("Tasks assigned to multiple");
        Set<Task> intersect1 = getIntersect(bobsTasks, carolsTasks);
        Set<Task> intersect2 = getIntersect(carolsTasks, annsTasks);
        Set<Task> intersect3 = getIntersect(annsTasks, bobsTasks);
        Set<Task> assignedMultiple = getUnion(List.of(intersect1, intersect2, intersect3));
        printTasks(assignedMultiple);

    }



    public static <T> Set<T> getUnion(List<Set<T>> sets) {
        Set<T> resultSet = new HashSet<>();
        for ( var c : sets) {
            resultSet.addAll(c);
        }
        return resultSet;
    }

    public static <T> Set<T> getIntersect(Set<T> setA, Set<T> setB) {
        Set<T> resultSet = new HashSet<>(setA);
        resultSet.retainAll(setB);
        return resultSet;
    }

    public static <T> Set<T> getDifference(Set<T> setA, Set<T> setB) {
        Set<T> resultSet = new HashSet<>(setA);
        resultSet.removeAll(setB);
        return resultSet;
    }

    public static void printTasks(Collection<Task> collection) {
        printTasks(collection, null);
    }

    public static void printTasks(Collection<Task> collection, Comparator<Task> comparator) {
        printList("%-20s %-25s %-10s %-20s %-10s"
                .formatted("ProjectName", "Description", "Priority", "Assignee", "Status"),
                collection, comparator);
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

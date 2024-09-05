import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private static String data = """
            All Tasks
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set Up Users, Low
            Data Access, Set Up Access Policy, Low
            
            Ann's Tasks
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy,Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Design, Project Table, Medium
            Data Access, Write Views,Low, In Progress
            
            Bob's Tasks
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design,Encryption Policy,High
            Data Access,Write Views, Low, In Progress
            
            Carol's Tasks:
            Infrastructure, Logging, High, In Progress
            Infrastructure, DB Access, Medium
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, High
            Data Access, Write Views, Low
              \s
            """;

    public static Set<Task> getData(String nameOrAll) {
        nameOrAll = nameOrAll.trim();
        Set<Task> tasks = new HashSet<>();
        String[] input = data.split("\n");
        int index = -1;
        for (int i = 0; i < input.length; i++) {
            if (input[i].trim().toUpperCase().contains(nameOrAll.toUpperCase())) {
                index = i;
            }
        }
        if (index > -1) {
            for (int i = index + 1; i < input.length; i++) {
                if (input[i].isBlank()) {
                    return tasks;
                }
                String[] fields = input[i].split(",");

                switch(fields.length) {
                    case 4 -> {
                        tasks.add(new Task(
                                fields[0].trim(),
                                fields[1].trim(),
                                Priority.valueOf(fields[2].trim().toUpperCase().replace(' ', '_')),
                                nameOrAll.equalsIgnoreCase("ALL") ? null : nameOrAll,
                                Status.valueOf(fields[3].trim().toUpperCase().replace(' ', '_'))));
                    }
                    case 3 -> {
                        tasks.add(new Task(
                                fields[0].trim(),
                                fields[1].trim(),
                                Priority.valueOf(fields[2].trim().toUpperCase()),
                                nameOrAll.equalsIgnoreCase("ALL") ? null : nameOrAll
                        ));
                    }
                    case 2 -> {
                        tasks.add(new Task(
                                fields[0].trim(),
                                fields[1].trim(),
                                Priority.valueOf(fields[2].trim().toUpperCase())
                        ));
                    }

                    default -> System.out.println("Invalid contact format: " + input[i]);
                }
            }
        } else {
            System.out.println(nameOrAll + " not found.");
            return tasks;
        }
        return tasks;
    }

}

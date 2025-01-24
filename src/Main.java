//  variables
//  primitive data types (numbers, strings, booleans)
//  basic collections (arrays and maps) and their methods
//  branching
//  looping
//  static method basics
//  static field basics

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static ArrayList<HashMap<String, String>> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {

            System.out.println("\nChoose an option: [add] task, [view] tasks, [complete] task, [quit]?");
            System.out.print("> ");
            String action = scanner.nextLine().toLowerCase();

            if (action.equals("add")) {
                HashMap<String, String> task = new HashMap<>();

                System.out.println("\nEnter task description: ");
                String description = scanner.nextLine();
                task.put("description", description);

                task.put("isCompleted", "false");
                tasks.add(task);
                System.out.println("\nTask added successfully!");

                // Viewing all tasks
            } else if (action.equals("view")) {
                if (tasks.isEmpty()) {
                    System.out.println("\nNo tasks available.");
                } else {
                    System.out.println("\nYour tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        int taskId = i + 1;
                        HashMap<String, String> task = tasks.get(i);
                        String status = task.get("isCompleted").equals("false") ? "Incomplete" : "Complete";
                        System.out.println(taskId + ". [" + status + "] " + task.get("description"));
                    }
                }

                // Completing a task
            } else if (action.equals("complete")) {
                if (tasks.isEmpty()) {
                    System.out.println("\nNo tasks available to complete.");
                } else {
                    System.out.println("\nEnter the number of the task to mark complete: ");
                    for (int i = 0; i < tasks.size(); i++) {
                        int taskId = i + 1;
                        HashMap<String, String> task = tasks.get(i);
                        String status = task.get("isCompleted").equals("false") ? "Incomplete" : "Complete";
                        System.out.println(taskId + ". " + task.get("description"));
                    }
                    System.out.print("> ");
                    int taskId = Integer.parseInt(scanner.nextLine()) - 1;

                    if (taskId >= 0 && taskId < tasks.size()) {
                        HashMap<String, String> task = tasks.get(taskId);
                        if (task.get("isCompleted").equals("false")) {
                            task.put("isCompleted", "true");
                            System.out.println("\nTask marked as complete: " + task.get("description"));
                        } else {
                            System.out.println("\nTask is already completed!");
                        }
                    } else {
                        System.out.println("Invalid task number.");
                    }
                }

            } else if (action.equals("quit")) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid action, please try again.");
            }
        }
    }
}
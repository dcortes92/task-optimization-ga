package task_optimization_logic;

import java.util.ArrayList;

public class TaskManager {
	
    private static ArrayList<Task> tasks = new ArrayList<Task>();

    public static void addTask(Task task) {
        tasks.add(task);
    }
    
    public static Task getTask(int index){
        return (Task)tasks.get(index);
    }
    
    public static int numberOfTasks(){
        return tasks.size();
    }
    
    public static ArrayList<Task> getTasks() {
        return tasks;
    }
    
    public static void printTasks () {
        System.out.println("\n*** Tasks *** ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print(tasks.get(i) + " ");
        }
        System.out.println("");
    }
}
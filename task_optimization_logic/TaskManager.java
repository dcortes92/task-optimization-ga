package task_optimization_logic;

import java.util.ArrayList;

public class TaskManager {
	
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static double[][] referenceMatrix;

    public static void addTask(Task task) {
        tasks.add(task);
    }
    
    public static Task getTask(int index){
        return (Task)tasks.get(index);
    }
    
    public static int numberOfTasks(){
        return tasks.size();
    }
    
    public static void printMatrix() {
        System.out.print("    ");
        for (int i = 0; i < numberOfTasks(); i++) {
            System.out.print(tasks.get(i).label + "    ");
        }
         System.out.println("");
        
		for (int i = 0; i < numberOfTasks(); i++) {
            System.out.print(tasks.get(i).label + " ");
			for (int j = 0; j < numberOfTasks(); j++) {
				System.out.print(String.format("%." + 2 + "f", referenceMatrix[i][j]) + " ");
			}
			System.out.println("\n");
		}
	}
	
	public static void setMatrix(double [][] matrix) {
		referenceMatrix = matrix;
	}
    
    public static double [][] getMatrix() {
        return referenceMatrix;
    }
}
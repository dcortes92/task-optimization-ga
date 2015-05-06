package task_optimization_logic;

import java.util.ArrayList;

public class TaskManager {
	
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static int[][] referenceMatrix;

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
		for (int i = 0; i < referenceMatrix.length; i++) {
			for (int j = 0; j < referenceMatrix.length; j++) {
				System.out.print(referenceMatrix[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	public static void setMatrix(int [][] matrix) {
		referenceMatrix = matrix;
	}
    
    public static int [][] getMatrix() {
        return referenceMatrix;
    }
}
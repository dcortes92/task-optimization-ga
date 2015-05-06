
package task_optimization_logic;

public class MainClass {
	public static void main (String args[]) {
		int matrixSize = 3;
		int labelCounter = 65;
		//reference matrix
		int[][] taskMatrix = new int[matrixSize][matrixSize];
		
		for (int x = 0; x < matrixSize; x++) {
			for (int y = 0; y < matrixSize; y++) {
				if (x == y) {
					taskMatrix[x][y] = 0;
				}
				else {
					taskMatrix[x][y] = (int)(Math.random()*10);
				}
			}
		}
		
		//Create the taskManager
		for (int x = 0; x < matrixSize; x++) {
			for (int y = 0; y < matrixSize; y++) {
				String label = new Character((char) labelCounter).toString();
				TaskManager.addTask(new Task(x, y, label));
				labelCounter++;
			}
		}
		
		//Add the reference of the matrix to the task manager.
		TaskManager.setMatrix(taskMatrix);
		
		//Let's see what the reference matrix is
		TaskManager.printMatrix();
		
		System.out.println(TaskManager.getTask(0).toString());
		
	}
}
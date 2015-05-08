
package task_optimization_logic;

import java.util.ArrayList;

public class MainClass {
	public static void main (String args[]) {
		int matrixSize = 0;
		int labelCounter = 65;
		ArrayList<Double> taskDurationArr = new ArrayList<Double>();
		String label = "";
		String intputMatrixSize = "";
		String inputTaskDuration = "";
		
		intputMatrixSize = System.console().readLine("\nEnter matrix size: ");
		try {
			matrixSize = Integer.parseInt(intputMatrixSize);
			//reference matrix
			double[][] taskMatrix = new double[matrixSize][matrixSize];
			
			inputTaskDuration = System.console().readLine("\nEnter duration for the " + matrixSize + " tasks (separated by space): ");
			
			System.out.println("\n**** Task Duration ****\n");
			
			for (String retval: inputTaskDuration.split(" ")) {
				label = new Character((char) labelCounter).toString();
				double temp = Double.parseDouble(retval);
				taskDurationArr.add(temp);
				System.out.print(label + ": " + temp + " ");
				labelCounter++;
		    }
			
			for (int x = 0; x < matrixSize; x++) {
				for (int y = 0; y < matrixSize; y++) {
					if (x == y) {
						taskMatrix[x][y] = 0;
					}
					else {
						taskMatrix[x][y] = RandomDecimal.generate(1, 10);
					}
				}
			}
			
			labelCounter = 65;
			//Create the taskManager
			for (int x = 0; x < matrixSize; x++) {
				label = new Character((char) labelCounter).toString();
				TaskManager.addTask(new Task(x, x, taskDurationArr.get(x), label));
				labelCounter++;
			}
			
			//Add the reference of the matrix to the task manager.
			TaskManager.setMatrix(taskMatrix);
			
			//Let's see what the reference matrix is
			System.out.println("\n**** Generated Matrix ****\n");
			TaskManager.printMatrix();			
			
			Population pop = new Population(50, true);
	        System.out.println("Initial duration: " + pop.getFittest().getDuration());
	        
	        pop = GA.evolvePopulation(pop);
	        for (int i = 0; i < 100; i++) {
	            pop = GA.evolvePopulation(pop);
	        }
	
	        // Print final results
	        System.out.println("Finished");
	        System.out.println("Final duration: " + pop.getFittest().getDuration());
	        System.out.println("Solution:");
	        System.out.println(pop.getFittest());
		}
		catch (Exception ex) {
			System.out.println("\n*** Size of matriz must be int.\nTask duration can be int or decimal (e.g. 1.1 2.3).\nError " + ex.getMessage() + " ***");
		}
	}
}

package task_optimization_logic;

public class MainClass {
	public static void main (String args[]) {
		int matrixSize = 0;
		int labelCounter = 65;		
		String input = System.console().readLine("\nEnter matrix size: ");
		try {
			matrixSize = Integer.parseInt(input);
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
				String label = new Character((char) labelCounter).toString();
				TaskManager.addTask(new Task(x, x, label));
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
			System.out.println("Matrix size must be an integer");
		}
	}
}
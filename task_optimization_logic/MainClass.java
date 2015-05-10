
package task_optimization_logic;

import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MainClass {
	public static void main (String args[]) {
		String inputMachineSize = "";
		String inputNumberOfMachines = "";
		int labelCounterTasks = 65; //asscii code for letter A
		int labelCounterMachines = 0;
		int machineSize, numberOfMachines, numberOfTasks = 0;
		double[][] durationMatrix;
		double[][] machine;
		double[][] solutionMatrix;
		
		try {
			//read input
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			System.out.print("\nMachines? ");
			inputNumberOfMachines = reader.readLine();
			System.out.print("\nTasks? ");
			inputMachineSize = reader.readLine();
			
			//parse read data
			numberOfMachines = Integer.parseInt(inputNumberOfMachines);
			machineSize = Integer.parseInt(inputMachineSize);
			
			//create the taskManager
			for (int x = 0; x < machineSize; x++) {
				String label = new Character((char) labelCounterTasks).toString();
				TaskManager.addTask(new Task(x, x, label));
				labelCounterTasks++;
			}
			
			//create machines
			for(int x = 0; x < numberOfMachines; x++) {
				//create single machine
				Machine machineObj = new Machine("m"+ (labelCounterMachines+1));
				machine = new double[machineSize][machineSize];
				//populate it with random data
				for (int i = 0; i < machineSize; i++) {
					for (int j = 0; j < machineSize; j++) {
						if (i == j) {
							machine[i][j] = 0;
						}
						else {
							machine[i][j] = RandomDecimal.generate(1, 10);
						}
					}
				}
				machineObj.setMachine(machine);
				//add created machine to the machine manager
				MachineManager.addMachine(machineObj);
				labelCounterMachines++;
			}
			
			//create matrix that holds the duration of a task in a specific machine
			durationMatrix = new double[machineSize][numberOfMachines];
			//solution matrix
			solutionMatrix = new double[machineSize][numberOfMachines];
			Solution.solutionMatrix = solutionMatrix;
			Solution.x = machineSize;
			Solution.y = numberOfMachines;
			for(int i = 0; i < machineSize; i++) {
				for(int j = 0; j < numberOfMachines; j++) {
					durationMatrix[i][j] = RandomDecimal.generate(1, 10);
				}
			}
			MachineManager.setDurationMatrix(durationMatrix);
			
			////////////////// Done with the set up /////////////////////
			
			TaskManager.printTasks();
			MachineManager.printMachines();
			MachineManager.printDurationMatrix();
			
			/////////////// Using the Genetic Algorithm ////////////////
			Population pop = new Population(50, true);
	        System.out.println("Initial duration: " + pop.getFittest().getDuration());
			
			System.out.println("Initial solution:" + pop.getFittest());
	        
	        pop = GA.evolvePopulation(pop);
	        for (int i = 0; i < 100; i++) {
	            pop = GA.evolvePopulation(pop);
	        }
	
	        // Print final results
	        System.out.println("Final duration: " + pop.getFittest().getDuration());
			System.out.println("Solution matrix:");
			Solution.printSolutionMatrix();
	        System.out.println("Solution:");
	        System.out.println(pop.getFittest());
		}
		catch (Exception ex) {
			System.out.println("\n*** Wrong input.\nError " + ex.getMessage() + " ***");
		}
	}
}
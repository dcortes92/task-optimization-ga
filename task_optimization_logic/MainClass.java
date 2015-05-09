
package task_optimization_logic;

import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MainClass {
	public static void main (String args[]) {
		String inputMachineSize = "";
		String inputNumberOfMachines = "";
		String inputNumberOfTasks = "";
		int labelCounterTasks = 65; //asscii code for letter A
		int labelCounterMachines = 0;
		int machineSize, numberOfMachines, numberOfTasks = 0;
		
		try {
			//read input
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			System.out.print("\nMachines? ");
			inputNumberOfMachines = reader.readLine();
			System.out.print("\nDimensions? ");
			inputMachineSize = reader.readLine();
			System.out.print("\nTasks? ");
			inputNumberOfTasks = reader.readLine();
			
			//parse read data
			numberOfMachines = Integer.parseInt(inputNumberOfMachines);
			machineSize = Integer.parseInt(inputMachineSize);
			numberOfTasks = Integer.parseInt(inputNumberOfTasks);
		}
		catch (Exception ex) {
			System.out.println("\n*** Wrong input.\nError " + ex.getMessage() + " ***");
		}
	}
}
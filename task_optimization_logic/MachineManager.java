package task_optimization_logic;

import java.util.ArrayList;

public class MachineManager {
	private static ArrayList<Machine> machines = new ArrayList<Machine>();
	private static double[][] durationMatrix; //duration of task for each machine
	
	public static void addMachine(Machine machine) {
		machines.add(machine);
	}
	
	public static Machine getMachine(int index) {
		return (Machine)machines.get(index);
	}
	
	public static int numberOfMachines() {
		return machines.size();
	}
	
	public static ArrayList<Machine> getMachines() {
		return machines;
	}
	
	public static void setDurationMatrix(double [][]matrix) {
		durationMatrix = matrix;
	}
	
	public static double getTaskDuration (int taskIndex, int machineIndex) {
		return durationMatrix[taskIndex][machineIndex];
	}
	
	public static void printMachines() {
		System.out.println("\n*** Machines ***");
		
		for(int x = 0; x < machines.size(); x++) {
			System.out.println(machines.get(x).toString());
			System.out.print("    ");
	        for (int y = 0; y < TaskManager.numberOfTasks(); y++) {
	            System.out.print(TaskManager.getTasks().get(y).label + "    ");
	        }
	        System.out.println("");
			Machine temp = machines.get(x);
			for (int i = 0; i < TaskManager.numberOfTasks(); i++) {
				System.out.print(TaskManager.getTasks().get(i).label + " ");
				for (int j = 0; j < TaskManager.numberOfTasks(); j++) {
					System.out.print(String.format("%." + 2 + "f", temp.getMachine()[i][j]) + " ");
				}
				System.out.println("\n");
			}
		}
	}
	
	public static void printDurationMatrix() {
		System.out.println("\n*** Duration Matrix ***");
		System.out.print("   ");
		for(int x = 0; x < machines.size(); x++) {
			System.out.print(machines.get(x).toString() + "   ");
		}
		
		System.out.println("");
			
		for (int i = 0; i < TaskManager.numberOfTasks(); i++) {
			System.out.print(TaskManager.getTasks().get(i).label + " ");
			for (int j = 0; j < machines.size(); j++) {
				System.out.print(String.format("%." + 2 + "f", durationMatrix[i][j]) + " ");
			}
			System.out.println("\n");
		}
		
	}
}
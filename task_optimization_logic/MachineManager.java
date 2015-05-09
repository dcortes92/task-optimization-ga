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
	
	public double getTaskDuration (int taskIndex, int machineIndex) {
		return durationMatrix[taskIndex][machineIndex];
	}
}
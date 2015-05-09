package task_optimization_logic;

public class Machine {
	private double[][] machine;
	private String label;
	
	public Machine(String label) {
		this.label = label;
	}
	
	public void setMachine(double[][] machine) {
		this.machine = machine;
	}
	
	public double[][] getMachine() {
		return this.machine;
	}
	
	@Override
	public String toString(){
		return this.label;
	}
}
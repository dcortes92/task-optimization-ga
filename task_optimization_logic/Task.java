package task_optimization_logic;

public class Task {
	public int x;
	public int y;
	public String label;
	
	public Task (int x, int y, String label) {
		this.x = x;
		this.y = y;
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
	
	public double timeTo(Task task) {
		return 0;
	}
}
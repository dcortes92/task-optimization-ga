package task_optimization_logic;

public class Task {
	public int x;
	public int y;
	
	public Task (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void test() {
		TaskManager.printMatrix();
	}
	
	@Override
	public String toString() {
		return "x: " + x + " y: " + y;
	}
}
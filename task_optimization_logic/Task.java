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
	
	public void test() {
		TaskManager.printMatrix();
	}
	
	@Override
	public String toString() {
		return this.label;
	}
	
	public int timeTo(Task task) {
		int [][] tempMatrix = TaskManager.getMatrix();
		return tempMatrix[this.x][task.y];
	}
}
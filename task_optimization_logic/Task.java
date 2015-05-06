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
	
	public int timeTo(Task task) {
		int [][] tempMatrix = TaskManager.getMatrix();
		return tempMatrixp[this.x][task.y];
	}
}
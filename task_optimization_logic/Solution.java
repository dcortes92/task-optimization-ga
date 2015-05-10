package task_optimization_logic;

public class Solution {
	public static double[][] solutionMatrix;
	public static int x;
	public static int y;
	
	public static void printSolutionMatrix() {
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++) {
				System.out.print(String.format("%." + 2 + "f", solutionMatrix[i][j]) + " ");
			}
			System.out.println("\n");
		}
	}
}
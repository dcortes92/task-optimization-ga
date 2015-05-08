package task_optimization_logic;

import java.util.Random;

public class RandomDecimal {
	public static double generate(int lower, int upper) {
		final double dbl =
        new Random().nextDouble() * (upper - lower) + lower;
			
		return dbl;
	}
}
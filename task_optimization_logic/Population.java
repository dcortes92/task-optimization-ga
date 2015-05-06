package task_optimization_logic;

public class Population {
	Process[] processes;
	
	public Pupulation(int populationSize, boolean initialise) {
		processes = new Process[populationSize];
		
		if (initialise) {
			for (int i = 0; i < populationSize(); i++) {
                Process process = new Process();
                process.generateIndividual();
                saveProcess(i, process);
            }
		}
	}
	
    public void saveProcess(int index, Process process) {
        processes[index] = process;
    }
    
    public Process getProcess(int index) {
        return processes[index];
    }

    public Process getFittest() {
        Process fittest = processes[0];
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getProcess(i).getFitness()) {
                fittest = getProcess(i);
            }
        }
        return fittest;
    }

    public int populationSize() {
        return processes.length;
    }
}
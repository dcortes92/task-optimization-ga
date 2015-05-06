package task_optimization_logic;

public class GA {
	private static final double mutationRate = 0.015;
    private static final int processnamentSize = 5;
    private static final boolean elitism = true;
	
	public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);
		
        int elitismOffset = 0;
        if (elitism) {
            newPopulation.saveProcess(0, pop.getFittest());
            elitismOffset = 1;
        }

        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            
            Process parent1 = processnamentSelection(pop);
            Process parent2 = processnamentSelection(pop);
            
            Process child = crossover(parent1, parent2);

            newPopulation.saveProcess(i, child);
        }

        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getProcess(i));
        }

        return newPopulation;
    }
    
    public static Process crossover(Process parent1, Process parent2) {
        Process child = new Process();

        int startPos = (int) (Math.random() * parent1.processSize());
        int endPos = (int) (Math.random() * parent1.processSize());

        for (int i = 0; i < child.processSize(); i++) {
            
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setTask(i, parent1.getTask(i));
            } 
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setTask(i, parent1.getTask(i));
                }
            }
        }

        for (int i = 0; i < parent2.processSize(); i++) {
            
            if (!child.containsTask(parent2.getTask(i))) {
                
                for (int ii = 0; ii < child.processSize(); ii++) {
                    
                    if (child.getTask(ii) == null) {
                        child.setTask(ii, parent2.getTask(i));
                        break;
                    }
                }
            }
        }
        return child;
    }
    
    private static void mutate(Process process) {
        
        for(int processPos1=0; processPos1 < process.processSize(); processPos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the process
                int processPos2 = (int) (process.processSize() * Math.random());

                // Get the cities at target position in process
                Task task1 = process.getTask(processPos1);
                Task task2 = process.getTask(processPos2);

                // Swap them around
                process.setTask(processPos2, task1);
                process.setTask(processPos1, task2);
            }
        }
    }
    
    private static Process tournamentSelection(Population pop) {
        
        Population tournament = new Population(tournamentSize, false);
        
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveProcess(i, pop.getProcess(randomId));
        }
        // Get the fittest tour
        Process fittest = tournament.getFittest();
        return fittest;
    }
}
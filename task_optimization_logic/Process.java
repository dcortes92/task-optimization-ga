package task_optimization_logic;

import java.util.ArrayList;
import java.util.Collections;

public class Process {
	private ArrayList<Task> process = new ArrayList<Task>();
	
	private double fitness = 0;
	private double hours = 0;
	
	public Process() {
		for (int i = 0; i < TaskManager.numberOfTasks(); i++) {
			process.add(null);
		}
	}
	
	public Process(ArrayList<Task> process) {
		this.process = process;
	}
	
	public void generateIndividual() {
        for (int taskIndex = 0; taskIndex < TaskManager.numberOfTasks(); taskIndex++) {
          setTask(taskIndex, TaskManager.getTask(taskIndex));
        }
        
        Collections.shuffle(process);
	}
	
    public Task getTask(int taskPosition) {
        return (Task)process.get(taskPosition);
    }

    public void setTask(int taskPosition, Task task) {
        process.set(taskPosition, task);        
        fitness = 0;
        hours = 0;
    }
	
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDuration();
        }
        return fitness;
    }
		
    public double getDuration(){
        if (hours == 0) {
            double processDuration = 0;
            Machine currentMachine;
            /*for (int machineIndex = 0; machineIndex < MachineManager.numberOfMachines(); machineIndex++) {
                for (int taskIndex=0; taskIndex < processSize(); taskIndex++) {
    
                    Task fromTask = getTask(taskIndex);
    
                    Task toTask;
                    
                    processDuration += MachineManager.getTaskDuration(taskIndex, machineIndex);
    
                    if(taskIndex+1 < processSize()){
                        toTask = getTask(taskIndex+1);
                        processDuration += MachineManager.getMachine(machineIndex).getMachine()[fromTask.x][toTask.y];
                    }
                }
            }*/
            
            double initialTime = 0;
            
            for (int i = 0; i < Solution.x ; i++) {
                for (int j = 0; j < Solution.y; j++) {
                    if (i == 0) {
                        Solution.solutionMatrix[i][j] = initialTime + MachineManager.getTaskDuration(getTask(i).x,j);
                        initialTime = Solution.solutionMatrix[i][j];
                    }
                    else {
                        double tempDuration = 0;
                        Task fromTask = getTask(i);
                        Task toTask = null;
                        
                        if (j == 0) {
                            tempDuration = Solution.solutionMatrix[i-1][j] + MachineManager.getTaskDuration(getTask(i).x,j);
                            if (i+1 < processSize()) {
                                toTask = getTask(i+1);
                                //tempDuration += MachineManager.getMachine(i).getMachine()[fromTask.x][toTask.y];
                            }
                        }
                        else {
                            tempDuration = Solution.solutionMatrix[i][j-1] + MachineManager.getTaskDuration(getTask(i).x,j);
                            double tempSubs = 0;
                            double setUp = 0;
                            tempSubs = tempDuration - Solution.solutionMatrix[i][j-1];
                            
                            if(toTask != null){
                                setUp = MachineManager.getMachine(i).getMachine()[fromTask.x][toTask.y];
                            }
                            
                            if (tempSubs < (MachineManager.getTaskDuration(i,j) + setUp)) {
                                tempDuration = Solution.solutionMatrix[i][j-1] + MachineManager.getTaskDuration(getTask(i).x,j);
                            }
                        }
                          
                        Solution.solutionMatrix[i][j] = tempDuration;
                    }
                }
            }
            
            hours = 0;// Solution.solutionMatrix[Solution.x][Solution.y];
        }
        return hours;
    }
        
    public int processSize() {
        return process.size();
    }
    
    public boolean containsTask(Task task){
        return process.contains(task);
    }
    
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < processSize(); i++) {
            geneString += getTask(i)+" | ";
        }
        return geneString;
    }
}
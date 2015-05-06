package task_optimization_logic;

import java.util.ArrayList;
import java.util.Collections;

public class Process {
	private ArrayList<Task> process = new ArrayList<Task>();
	
	private double fitness = 0;
	private int hours = 0;
	
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
		
    public int getDuration(){
        if (hours == 0) {
            int processDuration = 0;
            
            for (int taskIndex=0; taskIndex < processSize(); taskIndex++) {
                
                Task fromTask = getTask(taskIndex);

                Task toTask;

                if(taskIndex+1 < processSize()){
                    toTask = getTask(taskIndex+1);
                }
                else{
                    toTask = getTask(0);
                }
                
                processDuration += fromTask.timeTo(toTask);
            }
            hours = processDuration;
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
        String geneString = "|";
        for (int i = 0; i < processSize(); i++) {
            geneString += getTask(i)+"|";
        }
        return geneString;
    }
}
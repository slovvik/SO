package FCFS.simulationData;

import process.Process;

import java.util.LinkedList;
import java.util.Queue;

public class SimulationData {

    private int numberOfProcesses;
    private Queue<Process> processesFIFOQueue;

    public SimulationData(int numberOfProcesses) {
        this.numberOfProcesses = numberOfProcesses;
        processesFIFOQueue = new LinkedList<>();
    }

    public void addProcess(int from, int to) {
        processesFIFOQueue.add(new Process(from, to));
    }


}

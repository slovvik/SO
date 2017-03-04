package FCFS.simulationData;

import process.Process;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationData {

    private static int FROM = 5;
    private static int TO = 500;

    private Queue<Process> processesFIFOQueue;
    private int workingTime;

    public SimulationData(int numberOfProcesses) {
        processesFIFOQueue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < numberOfProcesses; i++) {
            addProcess();
        }
    }

    public void addProcess() {
        Process process = new Process(getRandomPhaseProcessor(FROM, TO), workingTime);
        processesFIFOQueue.add(process);

        workingTime += process.getPhaseProcessor();
    }

    public String showProcesses() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Process process : processesFIFOQueue) {
            stringBuilder.append(process.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    private static int getRandomPhaseProcessor(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }
}

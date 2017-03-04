package simulationData;

import process.Process;

import java.util.concurrent.ThreadLocalRandom;

public class SimulationData {

    private static int FROM = 5;
    private static int TO = 500;

    private Process[] processes;
    private int workingTime;

    public SimulationData(int numberOfProcesses) {
        processes = new Process[numberOfProcesses];
        for (int i = 0; i < processes.length; i++) {
            Process process = new Process(getRandomPhaseProcessor(FROM, TO), workingTime);
            workingTime += process.getPhaseProcessor();
            processes[i] = process;
        }
    }

    public String showProcesses() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < processes.length; i++) {
            stringBuilder.append(i + 1).append(": ").append(processes[i].toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    private static int getRandomPhaseProcessor(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public Process[] getProcesses() {
        return processes;
    }

    public void setProcesses(Process[] processes) {
        this.processes = processes;
    }
}

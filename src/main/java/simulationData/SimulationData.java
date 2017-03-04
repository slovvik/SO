package simulationData;

import process.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationData {

    private static int FROM = 5;
    private static int TO = 500;

    private List<Process> processes;
    private int workingTime;

    SimulationData(int numberOfProcesses) {
        processes = new ArrayList<>();
        for (int i = 0; i < numberOfProcesses; i++) {
            Process process = new Process(getRandomPhaseProcessor(FROM, TO), workingTime);
            workingTime += process.getPhaseProcessor();
            processes.add(process);
        }
    }

    public String showProcesses() {
        StringBuilder stringBuilder = new StringBuilder();
        processes.forEach(process -> stringBuilder
                .append(process.toString())
                .append("\n"));
        return stringBuilder.toString();
    }

    private static int getRandomPhaseProcessor(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }
}

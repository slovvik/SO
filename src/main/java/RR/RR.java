package RR;

import process.Process;

import java.util.LinkedList;
import java.util.Queue;

import static simulationData.Data.simulationDatas;

public class RR {

    private int timeQuantum;

    public RR(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public int[] simulateRR() {
        int averageAccess[] = new int[simulationDatas.length];
        int nextProcessAccessTime = 0;
        for (int i = 0; i < simulationDatas.length; i++) {
            Queue<Process> processesFIFOQueue = new LinkedList<>((simulationDatas[i].getProcesses()));
            for (int j = 0; j < processesFIFOQueue.size(); j++) {
                Process process = processesFIFOQueue.poll();
                if (process.getPhaseProcessor() < timeQuantum) {
                    nextProcessAccessTime += process.getPhaseProcessor();
                } else {
                    process.setPhaseProcessor(process.getPhaseProcessor() - timeQuantum);
                    nextProcessAccessTime += timeQuantum;
                    processesFIFOQueue.add(process);
                }
            }
            averageAccess[i] = nextProcessAccessTime / simulationDatas[i].getProcesses().size();
            nextProcessAccessTime = 0;
        }
        return averageAccess;
    }
}

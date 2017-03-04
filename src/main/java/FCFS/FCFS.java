package FCFS;

import process.Process;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static simulationData.Data.simulationDatas;

public class FCFS {

    public int[] simulateFCFS() {
        int averageAccess[] = new int[simulationDatas.length];
        int nextProcessAccessTime = 0;
        for (int i = 0; i < simulationDatas.length; i++) {
            Queue<Process> processesFIFOQueue = new LinkedList<>(Arrays.asList(simulationDatas[i].getProcesses()));
            for (int j = 0; j < processesFIFOQueue.size(); j++) {
                Process process = processesFIFOQueue.poll();
                if (j < processesFIFOQueue.size() - 1) {
                    nextProcessAccessTime += process.getPhaseProcessor();
                }
            }
            averageAccess[i] = nextProcessAccessTime / processesFIFOQueue.size();
            nextProcessAccessTime = 0;
        }
        return averageAccess;
    }
}

package SJF;

import process.Process;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static simulationData.Data.simulationDatas;

public class SJF {

    public int[] simulateSJF() {
        int averageAccess[] = new int[simulationDatas.length];
        int nextProcessAccessTime = 0;
        for (int i = 0; i < simulationDatas.length; i++) {
            List<Process> processes = simulationDatas[i].getProcesses();
            processes.sort(Comparator.comparingInt(Process::getPhaseProcessor));
            Queue<Process> processesFIFOQueue = new LinkedList<>(processes);
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

    public static void main(String[] args) {

    }
}

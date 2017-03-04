package FCFS;

import process.Process;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static simulationData.Data.showTestData;
import static simulationData.Data.simulationDatas;

public class FCFS {

    private int[] simulateFCFS() {
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

    private static String showAverageAccessTime(int[] averageAccess) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < averageAccess.length; i++) {
            stringBuilder.append("Average access time for: ").append(i + 1).append(" test data is: ").append(averageAccess[i]).append(" ms\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FCFS fcfs = new FCFS();

        System.out.println(showAverageAccessTime(fcfs.simulateFCFS()));

        System.out.println(showTestData(5));
    }

}

import FCFS.FCFS;
import RR.RR;
import SJF.SJF;

import static simulationData.Data.simulationDatas;

public class Main {

    private static final String MS = " ms";
    private static final String PIPE = " | ";

    private static String showAverageAccessTime(int[] averageAccessFCFS, int[] averageAccessRR, int[] averageAccessSJF) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < averageAccessFCFS.length; i++) {
            stringBuilder
                    .append("Test data: ")
                    .append(i + 1)
                    .append(" Average access time")
                    .append(PIPE)
                    .append("FCFS: ")
                    .append(averageAccessFCFS[i])
                    .append(MS)
                    .append(PIPE)
                    .append("RR: ")
                    .append(averageAccessRR[i])
                    .append(MS)
                    .append(PIPE)
                    .append("SJF: ")
                    .append(averageAccessSJF[i])
                    .append(MS)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FCFS fcfs = new FCFS();
        RR rr = new RR(50);
        SJF sjf = new SJF();

        System.out.println(showAverageAccessTime(
                fcfs.simulateFCFS(),
                rr.simulateRR(),
                sjf.simulateSJF()
        ));

        System.out.println(simulationDatas[5].showProcesses());

    }
}

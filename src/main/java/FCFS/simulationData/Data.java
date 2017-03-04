package FCFS.simulationData;

public class Data {

    private static int NUMBER_OF_PROCESSES = 20;
    private static int NUMBER_OF_TEST_DATA = 50;

    public static SimulationData[] simulationDatas = getSimulationDatas(NUMBER_OF_TEST_DATA);

    private static SimulationData[] getSimulationDatas(int size) {
        SimulationData[] simulationDatas = new SimulationData[size];
        for (int i = 0; i < simulationDatas.length; i++) {
            simulationDatas[i] = new SimulationData(NUMBER_OF_PROCESSES);
        }
        return simulationDatas;
    }

    public static String showTestData(int testDataNumber) {
        return simulationDatas[testDataNumber].showProcesses();
    }
}

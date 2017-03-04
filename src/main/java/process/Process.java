package process;

public class Process {

    private int phaseProcessor;
    private int addedTime;

    public Process(int phaseProcessor, int addedTime) {
        this.phaseProcessor = phaseProcessor;
        this.addedTime = addedTime;
    }

    public int getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(int addedTime) {
        this.addedTime = addedTime;
    }

    public int getPhaseProcessor() {
        return phaseProcessor;
    }

    public void setPhaseProcessor(int phaseProcessor) {
        this.phaseProcessor = phaseProcessor;
    }

    @Override
    public String toString() {
        return "Process{" +
                "phaseProcessor=" + phaseProcessor +
                ", addedTime=" + addedTime +
                '}';
    }
}

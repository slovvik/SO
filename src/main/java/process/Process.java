package process;

import java.util.concurrent.ThreadLocalRandom;

public class Process {

    private int phaseProcessor;

    public Process(int from, int to) {
        phaseProcessor = ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public int getPhaseProcessor() {
        return phaseProcessor;
    }

    public void setPhaseProcessor(int phaseProcessor) {
        this.phaseProcessor = phaseProcessor;
    }
}

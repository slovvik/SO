package process;

import java.util.Queue;

public class AddProcessThread implements Runnable{

    private Queue<Process> processesFIFOQueue;

    public AddProcessThread(Queue<Process> processesFIFOQueue) {
        this.processesFIFOQueue = processesFIFOQueue;
        new Thread(this, getClass().getName()).start();
    }

    public void addProcess(int from, int to) {
        processesFIFOQueue.add(new Process(from, to));
    }

    @Override
    public void run() {

    }
}

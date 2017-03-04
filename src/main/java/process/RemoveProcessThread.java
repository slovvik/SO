package process;

import java.util.Queue;

public class RemoveProcessThread implements Runnable{

    private Queue<Process> processesFIFOQueue;

    public RemoveProcessThread(Queue<Process> processesFIFOQueue) {
        this.processesFIFOQueue = processesFIFOQueue;
        new Thread(this, getClass().getName()).start();
    }

    public void removeProcess() {
        processesFIFOQueue.poll();
    }

    @Override
    public void run() {

    }
}

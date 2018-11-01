package multithread;

public class DeadlockDemo implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Entering into Deadlock via ::"+ Thread.currentThread().getName() +" thread");
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

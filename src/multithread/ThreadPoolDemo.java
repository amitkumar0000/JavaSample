package multithread;

public class ThreadPoolDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadPool Demo thread name:: "+ Thread.currentThread().getName());
    }
}

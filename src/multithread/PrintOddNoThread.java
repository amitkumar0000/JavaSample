package multithread;

public class PrintOddNoThread extends Thread{
    int i = 1;
    Object lock1;

    PrintOddNoThread(Object lock1){
        this.lock1 = lock1;
    }

    @Override
    public void run() {

        while(PrintNumInSequenceUsingThread.count < 20) {

            synchronized (lock1) {
                System.out.println(i+"");
                i = 2 + i;
                PrintNumInSequenceUsingThread.count++;
                lock1.notify();
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock1) {
            lock1.notify();
        }
        System.out.println("PrintOddNo Completed");

    }
}

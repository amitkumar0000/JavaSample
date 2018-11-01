package multithread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    CountDownLatch latch;
    public CountDownLatchDemo(){
        latch = new CountDownLatch(4); //4 is number of thread to wait
    }

    public void start(){
        Worker first = new Worker("Worker-1",latch);
        Worker second = new Worker("Worker-2",latch);
        Worker third = new Worker("Worker-3",latch);
        Worker four = new Worker("Worker-4",latch);

        first.start();
        second.start();
        third.start();
        four.start();

        try {
            latch.await();
            System.out.println("CountDonwLatchDemo exist");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Worker extends Thread{
    CountDownLatch latch;
    public Worker(String name, CountDownLatch latch){
        super(name);
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+ " finished");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo implements Runnable{
    public static CyclicBarrier cylicBarrier;
    public CyclicBarrierDemo(){
        cylicBarrier = new CyclicBarrier(3);
    }

    @Override
    public void run() {
        Computation1 computation1 = new Computation1();
        Computation2 computation2 = new Computation2();

        Thread t1 = new Thread(computation1);
        Thread t2 = new Thread(computation2);

        t1.start();
        t2.start();

        try {
            cylicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(Computation1.sum+ " "+ Computation2.product);
    }
}

class Computation1 implements Runnable{
    public static int sum;
    @Override
    public void run() {
        sum = 10;
        try {
            CyclicBarrierDemo.cylicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Computation2 implements Runnable{
    public static int product;
    @Override
    public void run() {
        product = 20;
        try {
            CyclicBarrierDemo.cylicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

package multithread;

public class MyThreadRunnable implements Runnable {


    @Override
    public void run() {
        for(int i=0; i<2; i++) {
            Thread.yield(); /* Yield is a hint to scheduler that current thread is ready for pause .
                                hint can be ignore by scheduler. */
            System.out.println(MyThread.currentThread().getName()+"  is Running "+ i +" times");
        }

    }
}

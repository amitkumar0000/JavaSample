package multithread;

public class PrintEvenNoThread extends Thread{
    int i =0;

    Object lock1;

    PrintEvenNoThread(Object lock1){
        this.lock1 = lock1;
    }

    @Override
    public void run() {

        while(ProducerConsumer.count < 20) {

            synchronized (lock1){
                i = 2 + i;
                System.out.println(i);
                ProducerConsumer.count++;
                lock1.notify();
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

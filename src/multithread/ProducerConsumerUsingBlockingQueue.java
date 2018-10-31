package multithread;

import java.util.concurrent.PriorityBlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

    PriorityBlockingQueue<Integer> blockingQueue1;
    PriorityBlockingQueue<Integer> blockingQueue2;
    int num = 0;


    public ProducerConsumerUsingBlockingQueue(){
        blockingQueue1 = new PriorityBlockingQueue();
        blockingQueue2 = new PriorityBlockingQueue();
    }

    public void startFactory(){
        blockingQueue1.add(num);

        new Thread(()->{
            while(num<20){
                try {
                    int n1 = blockingQueue1.take();
                    System.out.println(n1);
                    num++;
                    blockingQueue2.add(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(()->{
            while(num<20){
                int n1 = 0;
                try {
                    n1 = blockingQueue2.take();
                    System.out.println(" "+n1);
                    num++;
                    blockingQueue1.add(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}

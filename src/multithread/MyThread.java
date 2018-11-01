package multithread;

public class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread state:: "+ Thread.currentThread().getState());
        for(int i=0; i<10; i++) {
            if(!Thread.currentThread().isInterrupted()) {
                System.out.println(MyThread.currentThread().getName() + "  is Running " + i + " times");
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread state:: " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }

}

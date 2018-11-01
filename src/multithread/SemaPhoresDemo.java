package multithread;

import java.util.concurrent.Semaphore;

public class SemaPhoresDemo {
    public static int sharedCount;
    Semaphore sem;

    public SemaPhoresDemo(){
        /* Check the output. By increasing num of thread option in Semaphore increase the number of thread printing together */
        sem = new Semaphore(4,true);
    }

    public void start(){
        new Thread1(sem).start();
        new Thread2(sem).start();
        new Thread3(sem).start();
        new Thread4(sem).start();
    }


}

class Thread1 extends Thread{
    Semaphore sem;

    public Thread1(Semaphore sem) {
        super("ThD1");
        this.sem = sem;
    }

    @Override
    public void run() {
        while(SemaPhoresDemo.sharedCount < 100){
            try {
//                sem.acquire();
                sem.acquire(2); //take two count
                Thread.sleep(1000);
                SemaPhoresDemo.sharedCount++;
                System.out.println(Thread.currentThread().getName()+"  is running with sharedCount:: "+ SemaPhoresDemo.sharedCount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                sem.release();
            }

        }
    }
}

class Thread2 extends  Thread{
    Semaphore sem;

    public Thread2(Semaphore sem) {
        super("ThD2");
        this.sem = sem;
    }
    public void run() {
        while(SemaPhoresDemo.sharedCount < 100){
            try {
                sem.acquire();
                Thread.sleep(1000);
                SemaPhoresDemo.sharedCount++;
                System.out.println(Thread.currentThread().getName()+"  is running with sharedCount:: "+ SemaPhoresDemo.sharedCount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                sem.release();
            }

        }
    }


}

class Thread3 extends Thread{
    Semaphore sem;

    public Thread3(Semaphore sem) {
        super("THD3");
        this.sem = sem;

    }

    public void run() {
        while(SemaPhoresDemo.sharedCount < 100){
            try {
                sem.acquire();
                Thread.sleep(1000);
                SemaPhoresDemo.sharedCount++;
                System.out.println(Thread.currentThread().getName()+"  is running with sharedCount:: "+ SemaPhoresDemo.sharedCount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                sem.release();
            }

        }
    }

}

class Thread4 extends Thread{
    Semaphore sem;

    public Thread4(Semaphore sem) {
        super("THD4");
        this.sem = sem;
    }
    public void run() {
        while(SemaPhoresDemo.sharedCount < 100){
            try {
                sem.acquire();
                Thread.sleep(1000);
                SemaPhoresDemo.sharedCount++;
                System.out.println(Thread.currentThread().getName()+"  is running with sharedCount:: "+ SemaPhoresDemo.sharedCount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                sem.release();
            }

        }
    }

}

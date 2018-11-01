package multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    ReentrantLock reentrantLock;
    public static int num;

    public ReentrantLockDemo(boolean fairness){
        reentrantLock = new ReentrantLock(fairness);
    }

    public void readNum(){

        boolean ans = false;
        try {
            ans = reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(ans) {
            System.out.println(num);
            reentrantLock.lock();
            for(int i=0;i<10;i++)
                System.out.println(i+" "+num);
            reentrantLock.unlock();
            reentrantLock.unlock();
        }else{
            System.out.println("Lock is not free");
        }
    }

    public void writeNum(){
        reentrantLock.lock();
        reentrantLock.lock(); // lock can be acquire multiple times by thread which acquire the lock.
        reentrantLock.lock();
        num++;
        reentrantLock.unlock();
        reentrantLock.unlock();
//        reentrantLock.unlock();  //commenting it cause lock not to be free.
    }
}

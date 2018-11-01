package multithread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    ReentrantLock reentrantLock;
    public static int num;

    public ReentrantLockDemo(){
        reentrantLock = new ReentrantLock(true);
    }

    public void readNum(){

        reentrantLock.lock();
        System.out.println(num);
        reentrantLock.unlock();
    }

    public void writeNum(){
        reentrantLock.lock();
        num++;
        reentrantLock.unlock();
    }
}

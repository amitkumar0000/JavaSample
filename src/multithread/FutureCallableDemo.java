package multithread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureCallableDemo {
    FutureTask futureTask;
    Thread thread;

    public FutureCallableDemo(){
        CallableDemo callableDemo = new CallableDemo();
        futureTask = new FutureTask(callableDemo);

        thread = new Thread(futureTask);
    }

    public void start(){
        thread.start();

        try {
            System.out.println("Thread return :: "+ futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}


class CallableDemo implements Callable{

    @Override
    public Integer call() {
        Random generator = new Random();

        Integer randomNumber = generator.nextInt(1212122);

        return randomNumber;
    }
}
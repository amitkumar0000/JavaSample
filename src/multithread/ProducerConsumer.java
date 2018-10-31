package multithread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Two Thread running
One Thread produce the number
Second Thread consume the number and print
If producer thread produce more than 5 number it wait consumer thread to consume.
consume thread wait if there is no num.
 */
public class ProducerConsumer {

    ArrayList<Integer> arrayList;
    int MAXSIZE = 10;
    int num =1;
    Object lock;

    public ProducerConsumer(){
        arrayList = new ArrayList<>();
        lock = new Object();
    }

    public void startFactory(){
        new Thread(() -> {
            while(num<=50){
                synchronized (lock) {
                    if (arrayList.size() == MAXSIZE) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    arrayList.add(num);
                    num++;
                    lock.notify();
                }
            }
        }).start();

        new Thread(()->{
            while(num<=50){
                synchronized (lock){
                    if(arrayList.size() == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(arrayList.remove(0));
                    lock.notify();
                }
            }

            for(Integer n: arrayList)
            System.out.println(n);

        }).start();




    }



}

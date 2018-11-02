package collectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSynchronizedDemo {
    List<Integer> synList;
    public CollectionSynchronizedDemo(){

        synList = Collections.synchronizedList(new ArrayList<>());

    }

    public void start(){
        new Thread(()->{
            for(int i=0; i<10; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Adding-");
                synList.add(i);
            }
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i: synList)
                System.out.println("synList:: "+i);
        }).start();
    }
}

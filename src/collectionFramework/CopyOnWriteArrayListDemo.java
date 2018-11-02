package collectionFramework;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    CopyOnWriteArrayList<Integer> list;
    public CopyOnWriteArrayListDemo(){
        list = new CopyOnWriteArrayList();
    }

    public void start(){
        new Thread(()->{
            for(int i=0;i<10;i++) {
                System.out.println("Adding-");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(i);
            }
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i: list)
                System.out.println(i);
        }).start();

    }
}

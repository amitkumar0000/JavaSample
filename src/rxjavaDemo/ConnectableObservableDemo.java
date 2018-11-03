package rxjavaDemo;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableDemo {
    Observable<Integer> cold;
    ConnectableObservable<Integer> connectblePublish;


    public ConnectableObservableDemo(){
        cold = Observable.create(subscriber -> {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(1000);
                System.out.println("Source Emits : " + i);
                subscriber.onNext(i);
            }
        });
    }

    public void createHotObservableUsingPublish(){
        connectblePublish = cold.publish();

        connectblePublish.subscribe((s)->System.out.print(s+" "),(e)->e.printStackTrace());

        connectblePublish.connect();
    }

    public void replayDemo(){
        Observable<Integer> replay = cold.publish().replay();
        replay.subscribe((s)->System.out.println("replay "+s+" "),(e)->e.printStackTrace());
    }

    public void autoconnectDemo(){
        Observable<Integer> observable = cold.publish().autoConnect(2);
        observable.subscribe((s)->System.out.println("Subscriber 1 "+ s+" "),(e)->e.printStackTrace());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        observable.subscribe((s)->System.out.println("Subscriber 2 "+s+" "),(e)->e.printStackTrace());
    }

    public void refCountDemo(){
        Observable<Integer> observable = cold.publish().refCount();

        observable.subscribe((s)->System.out.println("RefCount "+s+" "),(e)->e.printStackTrace());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        observable.subscribe((s)->System.out.println("RefCount1 "+s+" "),(e)->e.printStackTrace());

    }

}

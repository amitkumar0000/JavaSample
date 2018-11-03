package rxjavaDemo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColdHotObservables {
    Observable<String> cold;
    Observable<String> hot;
    ConnectableObservable<String> connectble;


    public void createColdObservable(){
        cold = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                List<String> list = new ArrayList<>(Arrays.asList("hello","rxjava","cold","observable"));
                for(int i=0; i<list.size(); i++){
                    System.out.println("Emit ::" +list.get(i));
                    observableEmitter.onNext(list.get(i));
                }
            }
        });
    }

    public void createHotObservable(){
        connectble = cold.publish();
    }

    public void linkHotObserverable(){
        //if connect is called before subscriber , subscriber will miss data
        connectble.subscribe((s)-> System.out.println("Hot observable "+s));
        connectble.connect();
    }
    public void linkColdObserverable(){
        cold.subscribe((s)->System.out.println("Cold observable "+s),
                (e)->System.out.println(e),
                ()->System.out.println("onComplete"));
    }
}

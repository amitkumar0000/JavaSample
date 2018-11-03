package rxjavaDemo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class RxJavaDemo {

    Observable<String> myObservable;
    Observer<String> myObserver;
    Subscriber<String> mySubscriber;

    Observable<Integer> listObservable;
    Observer<Integer> listObserver;


    public RxJavaDemo(){

    }

    public void create() {
        createObservable();
        createObserver();
        createSubscriber();

        createListObservable();
        createListObserver();
    }

    private void createListObserver() {
        listObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer +" is received");

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    private void createListObservable() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
//        listObservable = Observable.fromArray(1,2,3,4,5);
        listObservable = Observable.fromCallable(()->30);

        listObservable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Consumer1 consume:: "+integer);
            }
        });

        listObservable.subscribe((integer)->System.out.println("Consumer2 consume:: "+integer));

        listObservable.subscribe((integer)->System.out.println("Consumer3 consume:: "+integer),
                (throwable)->System.out.println("Consumer3 on error"),
                ()->System.out.println("Consumer3 On Complete"));
    }

    public void link(){
        myObservable.subscribe(myObserver);

        listObservable.subscribe(listObserver);
    }

    private void createSubscriber() {
        mySubscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

    }

    private void createObservable() {
        myObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                new Thread(()->{
                    int count=0;
                    while(count < 3){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Count "+ ++count +" sent");
                        observableEmitter.onNext(String.valueOf(count));
                    }
                    try {
                        if(count > 3)
                             observableEmitter.onComplete();
                        else
                            throw new IllegalStateException();
                    }catch (IllegalStateException e){
                        observableEmitter.onError(e);
                    }
                }).start();
            }
        });


    }


    private void createObserver(){

        myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s+" is received");

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("Received onComplete");

            }
        };


    }
    public void demo(){

    }

}

class MyException extends Exception{

}

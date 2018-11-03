package rxjavaDemo;

import io.reactivex.*;
import io.reactivex.functions.Action;

public class ObservableDemo {
    Observable<Integer> observable;
    Flowable<Integer> flowable;
    Single<Integer> single;
    Maybe<Integer> maybe;
    Completable completable;

    public void createObservable(){
        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(2323);
//                observableEmitter.onError(new Throwable());
//                observableEmitter.onComplete();
            }
        });

        observable = Observable.create((e)->e.onComplete());
    }

    public void linkObservable(){
        observable.subscribe(s->System.out.println("Observable "+s),e->e.printStackTrace(),()->System.out.println("Observable "+"Complete"));
    }

    public void createFlowable(){
        /*flowable = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
            }
        },BackpressureStrategy.BUFFER);*/

        flowable = Flowable.create((e)->e.onNext(30),BackpressureStrategy.BUFFER);
    }

    public void linkflowable(){
        flowable.subscribe(s->System.out.println("flowable "+s),e->e.printStackTrace());
    }

    public void createSingle(){
        single = Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(SingleEmitter<Integer> singleEmitter) throws Exception {

            }
        });

        single = Single.create(e->{
//            e.onError(new Throwable());
            e.onSuccess(10);
        });
    }

    public void linksingle(){
        single.subscribe(s->System.out.println("single " +s),e->e.printStackTrace());
    }

    public void createMaybe(){
        maybe = Maybe.create(new MaybeOnSubscribe<Integer>() {
            @Override
            public void subscribe(MaybeEmitter<Integer> maybeEmitter) throws Exception {
                maybeEmitter.onSuccess(12);
//                maybeEmitter.onError(new Throwable());
            }
        });

        maybe = Maybe.create(e->{
//            e.onError(new Throwable());
            e.onSuccess(10);
        });
    }

    public void linkMaybe(){
        maybe.subscribe(s->System.out.println("maybe " +s),e->e.printStackTrace());
    }

    public void createCompletable(){
      /*  completable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter completableEmitter) throws Exception {
                completableEmitter.onComplete();
//                completableEmitter.onError(new Throwable());
            }
        });*/

        completable = Completable.create(e->{
            e.onComplete();
//            e.onError(new Throwable());
        });
    }

    public void linkcompletable(){
        /*completable.subscribe(new Action() {
            @Override
            public void run() throws Exception {

            }
        },e->e.printStackTrace());*/
        completable.subscribe(()->System.out.println("complete"),e->e.printStackTrace());
    }
}

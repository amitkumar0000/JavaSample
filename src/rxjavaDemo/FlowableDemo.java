package rxjavaDemo;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Flow;

public class FlowableDemo {

    public Flowable<Integer> just(){
        return Flowable.just(1,2,3,4,5)
                .subscribeOn(Schedulers.computation())
                .onBackpressureLatest();
    }

    public Flowable<Integer> create(){
        Flowable<Integer> flowable = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> flowableEmitter) throws Exception {
                flowableEmitter.onNext(10);
            }
        }, BackpressureStrategy.LATEST);

        flowable.cache();

        return flowable;
    }

}

package rxjavaDemo;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

import java.util.concurrent.TimeUnit;

public class SubjectsDemo {
    Observable<String> cold;
    Observable<Long> cold1;
    AsyncSubject<String> asyncSubject;
    BehaviorSubject<Long> behaviorSubject;
    PublishSubject<Long> publishSubject;
    ReplaySubject<String> replaySubject;

    public SubjectsDemo(){
        cold = Observable.fromArray("hello "," subject"," Hot","observable"," emits "," only ","last ","item");

        cold1 = Observable.interval(1000, TimeUnit.MILLISECONDS);
    }

    public void createAsyncSubject(){
        asyncSubject = AsyncSubject.create();

        cold.subscribe(asyncSubject);

        asyncSubject.subscribe((s)->System.out.println("asyncSubject "+ s),
                (e)->e.printStackTrace());

        cold1.subscribe((s)->System.out.print("cold "+s+" "),(e)->e.printStackTrace()); //cold observable
        System.out.print("\n");
    }

    public void createBehaviouralSubject(){
        behaviorSubject = BehaviorSubject.create();

        cold1.subscribe(behaviorSubject);

        behaviorSubject.onNext(12L);

        behaviorSubject.subscribe((s)->System.out.println("behaviorSubject  "+s),
                (e)->e.printStackTrace());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createPublishSubject(){
        publishSubject = PublishSubject.create();
        cold1.subscribe(publishSubject);
        publishSubject.onNext(12L);

        publishSubject.subscribe((s)->System.out.println("publishSubject  "+s),
                (e)->e.printStackTrace());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createReplaySubject() {
        replaySubject = ReplaySubject.create();
        cold.subscribe(replaySubject);

        replaySubject.onNext("I can also emit");

        replaySubject.subscribe((s) -> System.out.print("replaySubject " + s), (e) -> e.printStackTrace());

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
    PublishSubject p;
    public PublishSubject<Integer> getPublishSubjectObservable(){
        p = PublishSubject.create();
        p.onNext(10);
        EmitDataAfterEvery5Sec();
        return p;
    }

    private void EmitDataAfterEvery5Sec() {
        new Thread(() -> {
            int i =0;
            while(i<5){
                p.onNext(i);
                ++i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            p.onComplete();
        }).start();
    }

}

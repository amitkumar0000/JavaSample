package rxjavaDemo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class OperatorDemo {
    /*
    1. Just()  operator take list of argument and convert the item into observable items.
     */
    public Observable<Integer> justFromSingle() {
        return Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.single())
                .map(x -> 2 * x);


//                .subscribe((item)->System.out.println("Item emitted:: "+ item));
                /*.subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });*/
    }

    /*
    1.1 Just
     */

    public Observable<Integer[]> justFromArray(){
        Integer[] numbers = {1, 2, 3, 4, 5};

        return Observable.just(numbers);

    }


    /*
    2  From()
    Unlike just, From() creates an Observable from set of items using an Iterable,
    which means each item is emitted one at a time.
     */

    public Observable<Integer> fromArray(){
        Integer[] numbers = {1, 2, 3, 4, 5};

        return Observable.fromArray(numbers)
                        .subscribeOn(Schedulers.single())
                        .map(x -> 3*x);
    }

    public Observable<Integer>  fromCallable(){
        return Observable.fromCallable(new Callable<Integer>() {

            @Override
            public Integer call()  {
                return 10;
            }
        }).subscribeOn(Schedulers.io());
    }

    public Observable<Integer> fromFuture(){
        return Observable.fromFuture(new Future<Integer>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Integer get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        });
    }

    public Observable<Integer> fromIterable(){
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        return Observable.fromIterable(list);
    }

    public Observable<Integer> fromPublisher(){
        return Observable.fromPublisher(new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> subscriber) {

            }
        });
    }


    /*
      3. Range()
      Range() creates an Observable from a sequence of generated integers.
       The function generates sequence of integers by taking starting number and length
     */
    public Observable<Integer> range(){
        return Observable.range(0,10);
    }

    /*
    4. Repeat()
     */

    public Observable<Integer> repeat(){
        return Observable.range(0,4).repeat(3);
    }

    /*
    5. Buffer()
    Buffer gathers items emitted by an Observable into batches
    and emit the batch instead of emitting one item at a time.
     */
    public Observable<List<Integer>> buffer(){
        Integer[] numbers = {1, 2, 3, 4, 5};

        return Observable.fromArray(numbers).buffer(3);
    }

    /*
    6. Debounce()
    Debounce operators emits items only when a specified timespan is passed
     */
    public Observable<Integer> debounce(){

        return Observable.just(1,2,3,4,5)
                .debounce(1,TimeUnit.MILLISECONDS);
    }

    /*
    7. filter() allows the Observable to emit the only values those passes a test.
     */
    /*
    8. Skip(n) operator skips the emission of first N items emitted by an Observable.
     */
    /*
    9. skipLast(n) skips the last N emissions from an Observable.
     In the same example, skipLast(4) skips the emission of 7-10 and emits only 1, 2, 3, 4, 5, 6
     */
    /*
    10. take(n) acts exactly opposite to skip. It takes first N emissions of an Observable.
     */
    /*
    11. takeLast(n) emits last N items from an Observable.
     */
    /*
    12. Distinct() operator filters out items emitted by an Observable by avoiding duplicate items in the list
     */
    /*
    13. Max() operator finds the maximum valued item in the Observable sequence and emits that value
     */
    /*
    14. Min() operator emits the minimum valued item in the Observable data set.
     */
    /*
    15. Calculates the sum of all the items emitted by an Observable and emits only the Sum value
     */
    /*
    16. Calculates the average of all the items emitted by an Observable and emits only the Average value.
     */
    /*
    17. Counts number of items emitted by an Observable and emits only the count value.
     */
    /*
    18. Reduce applies a function on each item and emits the final result.
    First, it applies a function to first item, takes the result and feeds back to same function on second item.
    This process continuous until the last emission. Once all the items are over, it emits the final result.
     */
    /*
    19. Concat operator combines output of two or more Observables into a single Observable.
     Concat operator always maintains the sequential execution without interleaving the emissions.
     So the first Observables completes its emission before the second starts and so forth if there are more observables.
     */
    /*
    20. Merge also merges multiple Observables into a single Observable but it won’t maintain the sequential execution
     */
    /*
    21. Map() modifies each item emitted by a source Observable and emits the modified item.
     */
    public Observable<Integer> map(){
        return Observable.just(1,2,3,4)
                    .map(x->x*10);
    }

    /*
    22. flapMap() modified each item emitted by a source observable and instead emitting modified item,
        it returns observable itself which emit data again
     */

    public Observable<Integer> flatMap(){
        return Observable.just(1,2,3,4)
                .flatMap(x->Observable.just(x));
    }

    /*
     23. ConcatMap() maintains the order of items and waits for the
     current Observable to complete its job before emitting the next one.
     */

    /*
    24. SwitchMap() on the other hand is completely a different operator from FlatMap and ConcatMap.
    SwitchMap always return the latest Observable and emits the items from it.
     */
    public Observable<Integer> SwitchMap(){
        return Observable.just(1,2,3,4)
                .switchMap(x->Observable.just(x));
    }

    /*
    24. Create
     */

    public Observable<Integer> create(){
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                observableEmitter.onNext(10);
            }
        });
    }





}

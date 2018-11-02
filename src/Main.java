import InterfaceAbstract.markerInterface.ClonnableInterfaceDemo;
import InterfaceAbstract.ComparatorDemo;
import InterfaceAbstract.InterfaceAbstrace;
import InterfaceAbstract.markerInterface.SerializableDemo;
import InterfaceAbstract.markerInterface.customMarkerInterface.FunctionalityMarkerInterface;
import InterfaceAbstract.markerInterface.customMarkerInterface.ImplMarkerInterface;
import annotation.AnnotationDemo;
import classloader.CustomClassloader;
import collectionFramework.CollectionSynchronizedDemo;
import collectionFramework.CopyOnWriteArrayListDemo;
import collectionFramework.IteratorsDemo;
import exceptionhandler.*;
import multithread.*;
import nestedClass.AnonymousInnerClass;
import nestedClass.LocalInnerClass;
import nestedClass.StaticInnerClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    static String name = "amit";
    String age;
    public static void main(String[] args) {
        System.out.println("Hello World Enter");


//        customClassloaderDemo();

//        baseDerivedException();

//        exceptionHandlerDemo();

//        checkedUncheckedException();

//          interfaceAbstractDemo();

//          nestedClassDemo();

//        cutomImmutableClass();

//        annotationDemo();

        multithreadDemo();

        System.out.println("Hello World Exit");

    }

    private static void multithreadDemo() {

//        threadDemo();

//        deadlockUsingMain();

//        printNumInSequence();

//        producerConsumer();

//        producerConsumerQueue();

//        threadPoolDemo();

//          semaphoresDemo();

//         countDownLatchDemo();

//        reentrantLockDemo();

//        cyclicBarrierDemo();

//        callableFutureDemo();

        collectionDemo();

    }

    private static void collectionDemo() {
//        IteratorsDemo();
        synchronizedDemo();
    }

    private static void synchronizedDemo() {
        CopyOnWriteArrayListDemo demo = new CopyOnWriteArrayListDemo();
//        demo.start();

        CollectionSynchronizedDemo demo1 = new CollectionSynchronizedDemo();
        demo1.start();
    }

    private static void IteratorsDemo() {
        IteratorsDemo iteratorsDemo = new IteratorsDemo();
        iteratorsDemo.enumerationIterator();

        iteratorsDemo.iterator();

        iteratorsDemo.listIterator();
    }

    private static void callableFutureDemo() {
        FutureCallableDemo demo = new FutureCallableDemo();
        demo.start();
    }

    private static void cyclicBarrierDemo() {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        Thread thread = new Thread(cyclicBarrierDemo);
        thread.start();
    }

    private static void reentrantLockDemo() {
        ReentrantLockDemo demo = new ReentrantLockDemo(true);

        new Thread(()->demo.writeNum()).start();
        new Thread(()->demo.readNum()).start();
    }

    private static void countDownLatchDemo() {
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        countDownLatchDemo.start();
    }

    private static void semaphoresDemo() {
        SemaPhoresDemo semaPhoresDemo = new SemaPhoresDemo();
        semaPhoresDemo.start();
    }

    private static void threadPoolDemo() {
//        ExecutorService executor =  Executors.newCachedThreadPool();
        ExecutorService executor =  Executors.newFixedThreadPool(2);
//        ExecutorService executor=  Executors.newSingleThreadExecutor();

        ThreadPoolDemo poolDemo1 = new ThreadPoolDemo();
        ThreadPoolDemo poolDemo3 = new ThreadPoolDemo();
        ThreadPoolDemo poolDemo4 = new ThreadPoolDemo();
        ThreadPoolDemo poolDemo2 = new ThreadPoolDemo();

        executor.execute(poolDemo1);
        executor.execute(poolDemo2);
        executor.execute(poolDemo3);
        executor.execute(poolDemo4);

        executor.shutdown();
    }

    private static void deadlockUsingMain() {
        DeadlockDemo deadlockDemo = new DeadlockDemo();
        deadlockDemo.run();
    }

    private static void threadDemo() {
        MyThread myThread = new MyThread("myThread");
        myThread.setPriority(1);
        System.out.println("Thread state:: "+ myThread.getState());
        myThread.start();


        for(int i1=0; i1<5;i1++) {
            Thread myThread1 = new Thread(new MyThreadRunnable());
//            myThread1.setName("myThread1");
            myThread1.setPriority(10);
            myThread1.start();
        }



        System.out.println("Thread state:: "+ myThread.getState());
        try {
            Thread.sleep(1000);
            myThread.interrupt();
            myThread.join(10); // join with timeout.
//            myThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void producerConsumerQueue() {
        ProducerConsumerUsingBlockingQueue producerConsumerUsingBlockingQueue = new ProducerConsumerUsingBlockingQueue();
        producerConsumerUsingBlockingQueue.startFactory();
    }

    private static void producerConsumer() {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.startFactory();
    }

    private static void printNumInSequence() {
        PrintNumInSequenceUsingThread printNumInSequenceUsingThread = new PrintNumInSequenceUsingThread();
        printNumInSequenceUsingThread.printInSequence();
    }

    @SuppressWarnings({"checked", "deprecation"})
    private static void annotationDemo() {
        AnnotationDemo annotationDemo = new AnnotationDemo();
    }

    private static void cutomImmutableClass() {
        Address address = new Address("Ramgarh","Ramgarh");
        MyImmutable myImmutable = null;
        try {
            myImmutable = new MyImmutable("Kuju","Ramgarh","Ramgarh",address);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        myImmutable.getAddress().setCity("Ranchi"); //This will create new Object with city Ranchi without any alter in myImmutable object

        myImmutable.getAddresG().setCity("Ranchi");

        System.out.println(myImmutable.getName() +" "+ myImmutable.getAddress().getCity() +
                " "+myImmutable.getAddress().getDistrict() +" "+ myImmutable.getAddresG().getCity()) ;
    }

    private static void nestedClassDemo() {
        staticClassDemo();
        LocalInnerClassDemo();
        AnonymousInnerClassDemo();
    }

    private static void AnonymousInnerClassDemo() {
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();

    }

    private static void LocalInnerClassDemo() {
        LocalInnerClass innerClass  = new LocalInnerClass();

    }

    private static void staticClassDemo() {
        StaticInnerClass.StaticNestedClass staticNestedClass = new StaticInnerClass.StaticNestedClass();
        staticNestedClass.display();
    }

    private static void interfaceAbstractDemo() {
//        interfaceAbstraceD();
//        comparatorDemo();
        clonnableInterfaceDemo();
        serializableDemo();

        customMarkerInterfaceDemo();
    }

    private static void customMarkerInterfaceDemo() {
        ImplMarkerInterface implMarkerInterface = new ImplMarkerInterface();
        FunctionalityMarkerInterface.isMarker(implMarkerInterface);
    }

    private static void serializableDemo() {
        SerializableDemo serializableDemo = new SerializableDemo();
        serializableDemo.serialDemo();
    }

    private static void clonnableInterfaceDemo() {
        try {
            ClonnableInterfaceDemo clonnableInterfaceDemo = new ClonnableInterfaceDemo();
        }catch (CloneNotSupportedException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    private static void comparatorDemo() {
        ArrayList<ComparatorDemo.Student> list = new ArrayList<>();
        list.add(new ComparatorDemo.Student(2,"name9"));
        list.add(new ComparatorDemo.Student(13,"name2"));
        list.add(new ComparatorDemo.Student(1,"name8"));
        list.add(new ComparatorDemo.Student(10,"name1"));
        list.add(new ComparatorDemo.Student(5,"name3"));

        Collections.sort(list,new ComparatorDemo.SortByName());

//        Collections.sort(list); //Using Comparable Interface

        System.out.println(" == Sort by Name=== ");

        for(ComparatorDemo.Student student : list){
            System.out.println(student.toString());
        }

//        Collections.sort(list,new ComparatorDemo.SortByRoll());

        /*Collections.sort(list, new Comparator<ComparatorDemo.Student>() {

            @Override
            public int compare(ComparatorDemo.Student o1, ComparatorDemo.Student o2) {
                return o1.rollno - o2.rollno;
            }
        });*/


        Collections.sort(list , (o1,o2)-> o1.rollno-o2.rollno);

        System.out.println(" == Sort by Roll No=== ");
        for(ComparatorDemo.Student student : list){
            System.out.println(student.toString());
        }



    }

    private static void interfaceAbstraceD() {
        InterfaceAbstrace interfaceAbstrace = new InterfaceAbstrace();
        interfaceAbstrace.disp();
    }

    private static void checkedUncheckedException() {
        CheckedUnCheckedException exception = new CheckedUnCheckedException();
        try {
            exception.throwsRuntimeException();
        }catch (Exception e){
            System.out.println("Caught inside checkedUncheckedException");
        }

        try {
            exception.throwsCheckException();
        } catch (Base base) {
            base.printStackTrace();
        }

        System.out.println("Checked Unchecked Exception");
    }

    private static void baseDerivedException() {
        String name = "BaseDerivedDemo";
        //Derived Class catch block will always come before Base Class

        try{
            if(!name.equals("Demo"))
                throw new Base("Hi I am Base exception");

        } catch (Derived d){
            System.out.println("D:: "+ d.getMessage());
        }catch (Base e){
            System.out.println("B:: "+e.getMessage());
        }
    }

    private static void customClassloaderDemo() {
        try {
            printClassLoaders();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        customClassLoader();
    }

    private static void exceptionHandlerDemo() {
//        exceptionSampleDemo();
        userDefinedException();

        thowsDemo();
    }

    private static void thowsDemo()  {
        ExceptionSample sample = new ExceptionSample();

        sample.func4();
    }

    private static void userDefinedException() {
        UserDefinedException myException = new UserDefinedException("This is User Defined Exception");

        try{
            String name = "Hello";
            if(!name.equals("User"))
                throw myException;

        }catch (UserDefinedException exception){
            System.out.println("User Defined Exception is thrown:: "+ exception.getMessage());
            exception.printStackTrace();
        }
        finally {
            System.out.println("Hi I am finally block");
        }

    }

    private static void exceptionSampleDemo() {
        ExceptionSample exceptionSample = new ExceptionSample();
        exceptionSample.func1();
    }

    private static void customClassLoader() {

        CustomClassloader customClassloader = new CustomClassloader();
        try {
            Class c = customClassloader.findClass("/Users/amitkumar5/Desktop/IdeaProjects/JavaSample/out/production/JavaSample/Main.class");

            for(Method method: c.getDeclaredMethods()) {
                System.out.println(method);
            }

            for(Field field: c.getDeclaredFields()){
                System.out.println(field);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + Main.class.getClassLoader());

        System.out.println("Classloader of CustomClassloader:"
                +  CustomClassloader.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}

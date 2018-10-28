package InterfaceAbstract;

public class FunctionInterfaceDemo {

    public FunctionInterfaceDemo(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi I am thread");
            }
        }).start();

        //lambda expression
        new Thread(()->System.out.println("Hi I am thread")).start();
    }
}

@FunctionalInterface
interface functionInterface{
    void display();

    /* can have many default or static or private Method*/
    default void display1(){

    }
    default void display2(){

    }
    default void display3(){

    }

    static void display4(){

    }

    private void display5(){

    }

}


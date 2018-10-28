package InterfaceAbstract;

public class InterfaceAbstrace extends AbstractDemo implements  in1 {
    public static final String TAG = InterfaceAbstrace.class.getName()+" ";

    public void disp(){
        System.out.println(TAG+this.aIn);
        this.display();
        in1.displayA();

        display();
    }
}

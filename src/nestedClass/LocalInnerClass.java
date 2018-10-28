package nestedClass;

public class LocalInnerClass {


    int outerX;
    final int outerF;
    static int outerY = 10;
    private static int outerZ = 20;
    LocalInnerClass1 localInnerClass;

    public LocalInnerClass(){
        outerF = 10;
        localInnerClass = new LocalInnerClass1();
        localInnerClass.display();

        int x = 20;

        /*
        Here class scope is method
         */
        class LocalInnerClass1 implements InterfaceAbstract.in1{
            public void display() {
                System.out.println("Local inner class:: "+outerX+ " "+outerZ  + " x::"+x);
            }

            @Override
            public void displayIn() {
                System.out.println("Local inner class:: "+outerX+ " "+outerZ );

            }
        }

        LocalInnerClass1 innerClass;
        innerClass = new LocalInnerClass1();
        innerClass.display();
    }

    class LocalInnerClass1{
        public void display(){
            System.out.println("Local inner class:: "+outerX+ " "+outerF );

        }

    }
}

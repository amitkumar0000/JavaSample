package nestedClass;

import InterfaceAbstract.InterfaceAbstrace;

public class AnonymousInnerClass {
    // As subclass of specified type
    Demo d = new Demo(){
        @Override
        public void show() {
            System.out.println("Hi i am Anonymous inner class as subclass");
        }
    };

    public AnonymousInnerClass(){
        d.show();

        // As Implementer of specific interface
        InterfaceAbstract.in1 obj = new InterfaceAbstract.in1(){

            @Override
            public void displayIn() {
                System.out.println("Anonymous Inner class via interface");
            }
        };

        obj.displayIn();
    }

}

class Demo{
    public void show(){
        System.out.println("Hi I am Demo class show method");
    }
}

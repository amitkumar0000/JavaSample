package nestedClass;


public class StaticInnerClass {

    int outerX;
    final int outerF;
    static int outerY = 10;
    private static int outerZ = 20;

    public StaticInnerClass(){
        outerF = 10;
    }

    public static void display1(){
        System.out.println("Outer class");
    }

    /*
    Static Inner class has access to static variable only
     */
    public static class StaticNestedClass{
        public void display(){
            System.out.println("static inner class:: "+outerY+ " "+outerZ );
            display1();
        }
    }


}

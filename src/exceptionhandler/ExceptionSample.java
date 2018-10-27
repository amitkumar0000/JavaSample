package exceptionhandler;

public class ExceptionSample {

    public void func1() {
        func2();

    }

    public void func2() {
        try {
            func3();
            return; // Return statement in try and catch block is executed after finally block.
        } catch (NullPointerException e) {
            System.out.println(e.getCause());
            e.printStackTrace();
            //Below any of two statement will let finally block not to execute.
//            System.exit(1);
//            Runtime.getRuntime().halt(1);
        }
        finally {
            System.out.println("I am Finally block");
            return;
        }
    }

    /*
       An exception occur
           1. Method create Exception object.
           2. Handover it to Java run time system(JVM)
           3. Trace the Call stack(ordered list of method call)
           4. Find the method which handle the exception raised.
           5. Catch block is executed if found
           6. else Java Default exception handler gets exception object
           7. Default exception handler print the exception and call trace.
           8. Finally block is executed if present.
        */
    public void func3() {

        String name = null;
        if (name.equals("Exception")) {
            System.out.println(name);
        }
    }

    public void func4()  {

        throwdemo();
    }

    public void throwdemo()  {
        try {
            throw new Base("Hello I am Base throw ");
        }catch (Base e) {
             System.out.println("Hello ");
        }
        finally {
            System.out.println("Hello finally");
        }
    }
}

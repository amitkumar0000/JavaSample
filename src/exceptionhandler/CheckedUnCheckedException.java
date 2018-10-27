package exceptionhandler;

public class CheckedUnCheckedException {

    /*
    Runtime Exception are unchecked Exception.

     */
    public void throwsRuntimeException() {
        try {
            int y = 1 / 0;
        }catch (NullPointerException e){
            System.out.println("Caught inside throwsRuntimeException");

        }
    }

    public void throwsCheckException() throws Base {
        throw new Base("Cheked Exception ");
    }


}

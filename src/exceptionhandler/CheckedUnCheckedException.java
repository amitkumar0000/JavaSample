package exceptionhandler;

public class CheckedUnCheckedException {

    /*
    Runtime Exception are unchecked Exception.

     */
    public void throwsRuntimeException() {
        int y = 1/0;
    }

    public void throwsCheckException() throws Base {
        throw new Base("Cheked Exception ");
    }


}

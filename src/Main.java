import classloader.CustomClassloader;
import exceptionhandler.Base;
import exceptionhandler.Derived;
import exceptionhandler.ExceptionSample;
import exceptionhandler.UserDefinedException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    static String name = "amit";
    String age;
    public static void main(String[] args)  {
        System.out.println("Hello World Enter");


//        customClassloaderDemo();

        baseDerivedException();

        exceptionHandlerDemo();


        System.out.println("Hello World Exit");

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

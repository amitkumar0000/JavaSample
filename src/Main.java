import classloader.CustomClassloader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    static String name = "amit";
    String age;
    public static void main(String[] args)  {
        System.out.println("Hello World!");


        try {
            printClassLoaders();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        customClassLoader();
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

        System.out.println("Classloader of Logging:"
                + System.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}

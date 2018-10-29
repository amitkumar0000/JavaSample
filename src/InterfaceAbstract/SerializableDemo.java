package InterfaceAbstract;

import java.io.*;

public class SerializableDemo {

    public void serialDemo() {
        SerialTest a = new SerialTest(20, "GeeksForGeeks");
        a.roll = 30;

        // Serializing 'a'
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("xyz.txt");

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);

            // De-serializing 'a'
            FileInputStream fis = new FileInputStream("xyz.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            SerialTest b = (SerialTest) ois.readObject();//down-casting object

            System.out.println("Serializable Demo "+b.age + " " + b.name+ " "+ b.roll);

            // closing streams
            oos.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class SerialTest implements Serializable {
    transient int age;  /* Transient will make variable state not to saved via serializable*/
    public  static int roll = 10;
    String name;
    private static final long serialVersionUID=42L;

    public SerialTest(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

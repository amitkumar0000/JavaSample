package classloader;

import java.io.*;

public class CustomClassloader extends ClassLoader {

    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassfromfile(name);
        name = "Main";
        return defineClass(name,b,0,b.length);
    }

    private byte[] loadClassfromfile(String fileName) {

        InputStream inputStream1 = null;
        try {
            inputStream1 = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream1.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}

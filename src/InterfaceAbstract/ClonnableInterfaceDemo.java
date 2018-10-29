package InterfaceAbstract;

public class ClonnableInterfaceDemo implements Cloneable {

    public ClonnableInterfaceDemo() throws CloneNotSupportedException{
        Test obj1 = new Test();
        obj1.test1.x = 100;
        Test obj2 = (Test) obj1.clone();
        obj2.x = 30;
        obj2.y = 30;
        obj2.test1.x = 200;

        System.out.println("Clone ex   x:: "+ obj1.x + " y: "+ obj1.y +" obj x " + obj1.test1.x);
        System.out.println("Clone ex   x:: "+ obj2.x + " y: "+ obj2.y+" obj x " + obj1.test1.x) ;
    }

}

class Test implements Cloneable {
    int x, y;
    Test1 test1;
    Test() {
        x = 10;
        y = 20;
        test1 = new Test1();

    }

    class Test1{
        int x,y;
        Test1(){

        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Test t = (Test) super.clone();

        t.test1 = new Test1();

        return t;
    }
}

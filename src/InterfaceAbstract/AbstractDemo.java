package InterfaceAbstract;

public  abstract class AbstractDemo{
    int a = 10;

    AbstractDemo(){
        System.out.println("Abstract Demo Constructor");
    }

    public void display(){
        a=12;
        System.out.println("Display from abstract :: "+a);
    }
}

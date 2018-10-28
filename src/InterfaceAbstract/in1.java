package InterfaceAbstract;


public  interface in1 {
    int aIn = 10;

   default  void display(){
        System.out.println("From Java 8 Printing from  Default Interface method :: "+aIn);
       displayA1();
   }

    static  void displayA(){
        System.out.println("From Java 8 Printing from  Static method can be defined :: "+aIn);
    }

    private void displayA1(){
        System.out.println("From Java 8 Printing from  Private method can be defined :: "+aIn);

    }

}

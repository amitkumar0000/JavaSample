package multithread;

/*
Two thread :
    thread one printing even number
    thread two printing odd number
Print in sequence

 */
public class PrintNumInSequenceUsingThread {

    PrintEvenNoThread printEvenNoThread;
    PrintOddNoThread printOddNoThread;
    Object lock1;
    public static int count=0;

    public PrintNumInSequenceUsingThread(){
        lock1 = new Object();
        printEvenNoThread = new PrintEvenNoThread(lock1);
        printOddNoThread = new PrintOddNoThread(lock1);
    }

    public void printInSequence(){
        printOddNoThread.start();
        printEvenNoThread.start();
    }

}


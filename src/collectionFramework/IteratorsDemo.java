package collectionFramework;

import java.util.*;

public class IteratorsDemo {

    public void enumerationIterator(){
        Vector<Integer> v = new Vector<>();

        for(int i=0;i<5;i++)
            v.add(i);

        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            int num = (int)e.nextElement();
            System.out.println("vector ele:: " + num);
        }
    }

    public void iterator(){
        Vector<Integer> v = new Vector<>();
        for(int i=0;i<10;i++)
            v.add(i);
        Iterator iterator = v.iterator();
        while(iterator.hasNext()){
           int num = (int) iterator.next();
           if(num%2==0)
               iterator.remove();
        }
        iterator = v.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void listIterator(){
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<10; i++)
            l.add(i);

        System.out.println("List Iterator Demo");
        ListIterator listIterator = l.listIterator();

        while(listIterator.hasNext()){
            int num=(int)listIterator.next();
            if(num%2==0)
                listIterator.remove();
            System.out.println(num);
        }

        System.out.println("List Iterator after removal");
        while(listIterator.hasPrevious()){
            listIterator.add(listIterator.previous());
            System.out.println(listIterator.previous());
        }
        System.out.println("List Iterator after add");

        while(listIterator.hasNext()){
            int num = (int)listIterator.next();
            if(num%2!=0)
                listIterator.set(num*2);
            System.out.println(listIterator.next());

        }
        System.out.println("List Iterator after set");
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }


    }


}

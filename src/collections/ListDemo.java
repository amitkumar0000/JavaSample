package collections;

import collectionFramework.CopyOnWriteArrayListDemo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {

    List<Integer> arrayList;
    CopyOnWriteArrayList<Integer> synArrayList;
    List<Student> studentArrayList;
    List<Integer> linkedList;
    List<Integer> vector;
    Stack<Integer> stack;

    public void addInArrayList(int ele){
        if(arrayList==null){
            arrayList = new ArrayList<>();
        }

        arrayList.add(ele);
    }
    public void removeInArrayList(int index){
        arrayList.remove(index);
    }
    public void printArrayList(){
        Iterator<Integer> itr = arrayList.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.print("\nPrinting using For Each\n");

        for(int e: arrayList){
            System.out.print(e+" ");
        }
        System.out.print("\n");
    }
    public void synchronizedArrayList(){
        List<Integer> synArrayList = Collections.synchronizedList(arrayList);

    }
    public void replcementInArrayList(int index,int newEle){
        arrayList.set(index,newEle);
    }
    public void sortArrayListInAsc(){
        Collections.sort(arrayList);
        System.out.println("Print ArrayList in ascending order");
        printArrayList();
    }
    public void sortArrayListInDescending(){
        Collections.sort(arrayList,Collections.reverseOrder());
        System.out.println("Print ArrayList in Descending order");
        printArrayList();
    }

    public void addInSynArrayList(int ele){
        if(synArrayList == null)
            synArrayList = new CopyOnWriteArrayList<>();
        synArrayList.add(ele);
    }

    public void addStudentInList(Student student){
        if(studentArrayList == null){
            studentArrayList = new ArrayList<>();
        }
        studentArrayList.add(student);
    }
    public void printStudentFromArrayList(){
        for(Student s: studentArrayList){
            System.out.println("Name:: "+s.name+ " roll no: "+s.rollno);
        }
    }
    public void sortUserDefinedObjectInArrayList(){
        System.out.println("In Descending Order");
        Collections.sort(studentArrayList,(o1,o2)-> o2.rollno-o1.rollno );
        printStudentFromArrayList();

        System.out.println("In Ascending Order");
        Collections.sort(studentArrayList,(o1,o2)-> o1.rollno-o2.rollno );
        printStudentFromArrayList();
    }

    public void addInLinkedList(int ele){
        if(linkedList==null){
            linkedList = new LinkedList<>();
        }

        linkedList.add(ele);
    }
    public void removeInLinkedList(int index){
        linkedList.remove(index);
    }
    public void printLinkedList(){
        Iterator<Integer> itr =linkedList.iterator();

        while(itr.hasNext()){
            System.out.print(itr.next()+"   ");
        }
        System.out.print("\nPrinting using For Each\n");

        for(int e: linkedList){
            System.out.print(e+" ");
        }
        System.out.print("\n");
    }
    public void replacementInLinkedList(int index,int newele){
        linkedList.set(index,newele);
    }
    public void sortlinkedListInAsc(){
        Collections.sort(linkedList);
        System.out.println("Print linkedList in ascending order");
        printLinkedList();
    }
    public void sortlinkedListInDescending(){
        Collections.sort(linkedList,Collections.reverseOrder());
        System.out.println("Print LinkedList in Descending order");
        printLinkedList();
    }

    public void addInVector(int ele){
        if(vector == null){
            vector = new Vector<>();
        }
        vector.add(ele);
    }

    public void addInStack(int ele){
        if(stack == null){
            stack = new Stack<>();
        }
        stack.push(ele);
    }
    public void printStack(){
        for(int e: stack){
            System.out.println("Stack ::" + e);
        }
    }
}


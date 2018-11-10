package collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    Queue<Student> queue;
    PriorityQueue<Student> priorityQueue;

    public void addToQueue(Student student){
        if(queue == null)
            queue = new PriorityQueue<>();
        queue.add(student);
    }

    public void printQueue(){
        for(Student student: queue){
            System.out.println("Queue  name:: "+ student.name+ " rollno:: "+ student.rollno);
        }
    }

    public void sortQueue(){
        //Queue can'b be sorted using Comparator interface.
    }
}

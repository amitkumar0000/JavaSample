package collections;

import java.util.*;

//HashSet, LinkedHashSet, TreeSet
public class SetDemo {
    Set<Student> studentHashSet;
    Set<Student> studentLinkedHashSet;
    Set<Student> studentTreeSet;

    public void addToHashSet(Student student){
        if(studentHashSet == null) {
//            studentHashSet = new HashSet<>();
            studentHashSet = new LinkedHashSet<>();
        }
        studentHashSet.add(student);
    }

    public void printHashSet(){
        Iterator<Student> itr = studentHashSet.iterator();
        while(itr.hasNext()){
            Student student = itr.next();
            System.out.println("Student in Set name:: "+student.name + " roll: "+student.rollno);
        }
    }

    public void sortHashSet(){
        //Collection.sort can't applied to Set interface implementing class as it unordered set.
        //If you want to sort, first convert into list then sort the list.
        List<Student> list = new ArrayList<>(studentHashSet);
        Collections.sort(list, (o1,o2)->o2.rollno-o1.rollno);
//        printHashSet();


        // TreeSet arrange the order in asc/des order.
        TreeSet<Student> studentTreeSet = new TreeSet(studentHashSet);
        for(Student student:studentTreeSet){
            System.out.println("Student in Set name:: "+student.name + " roll: "+student.rollno);

        }

    }


}

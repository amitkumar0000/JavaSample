package collections;

public class Student implements  Comparable{
    int rollno;
    String name;
    public Student(int rollno, String name){
        this.name = name;
        this.rollno = rollno;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        return s.rollno-rollno;
    }
}

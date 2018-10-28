package InterfaceAbstract;

import java.util.Comparator;

public class ComparatorDemo {
    public static class Student implements Comparable<Student>{
        public int rollno;
        public String name;
        public Student(int rollno, String name){
            this.rollno = rollno;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student name::" +name + " roll: "+rollno;
        }

        @Override
        public int compareTo(Student o) {
            return name.compareTo(o.name);
        }
    }

    public static class SortByRoll implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.rollno - o2.rollno;
        }
    }

    public static class SortByName implements Comparator<Student>{


        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}

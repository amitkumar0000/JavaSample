package stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    ArrayList<Integer> arrayList;

    public StreamDemo(){
        arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(10);
        arrayList.add(14);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(20);
    }

    public void sum(){
        int sum=0;
        for(int i: arrayList){
            if(i>10){
                sum+=i;
            }
        }
        System.out.println("Sum of number greater than 10 :: "+sum);
    }

    public void sumUsingStream(){
        System.out.println("sum using stream:: "+arrayList.stream().filter(i->i>10).mapToInt(i->i).sum());
    }

    public void filterDemo(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filter = strings.stream().filter(s->!s.isEmpty()).limit(2).collect(Collectors.toList());
        for(String s: filter){
            System.out.println("String after filter:: "+s);
        }
    }

    public void mapDemo(){
        List<Integer> list = Arrays.asList(30,20,31,13,5,6,7);
        List<Integer> squarelist = list.parallelStream().map(i->i*i).distinct().limit(10).sorted().collect(Collectors.toList());
        for (int i: squarelist)
            System.out.println("sq::"+ i);
    }
}

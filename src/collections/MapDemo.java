package collections;

import java.util.*;

public class MapDemo {
    Map<String,Student> hashMap;
    Map<String,Student> linkedHashMap;
    Map<String,Student> treeMap;
    Map<String,Student> hashtable;

    public void addTOHashMap(String name,Student student){
        if(hashMap == null)
            hashMap = new HashMap<>();
        hashMap.put(name,student);
    }


    public void printHashMap(){
        Set<Map.Entry<String,Student>> mapEntry = hashMap.entrySet();
        for(Map.Entry<String,Student> entry: mapEntry){
            System.out.println("Name in map:: key: "+ entry.getKey() + " value::" + entry.getValue().rollno);
        }
    }

    public void sortHashMap(){
        TreeMap<String,Student> treeMap = new TreeMap<>(hashMap);
        Set<Map.Entry<String,Student>> mapEntry = treeMap.entrySet();
        for(Map.Entry<String,Student> entry: mapEntry){
            System.out.println("Name in map:: key: "+ entry.getKey() + " value::" + entry.getValue().rollno);
        }

        List<String> list = new ArrayList<>(hashMap.keySet());
        Collections.sort(list);
        for(String key: list){
            System.out.println("Key:: "+ key+ " value "+hashMap.get(key).rollno);
        }

    }
}

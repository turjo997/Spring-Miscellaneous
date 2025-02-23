package problems;

import java.util.*;

public class MapOperations {
    public static void main(String[] args) {
        Map<String , Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 28);

        System.out.println("Map: " + map);
        if(map.containsKey("Bob")){
            System.out.println("present");
        }
        if(map.containsValue(30)){
            System.out.println("present");
        }
        int age = map.get("Charlie");
        System.out.println("Age is : " +age);

        int found = map.getOrDefault("Charlie3" , 0);
        System.out.println(found);

        map.remove("Charlie");
        System.out.println("After removal: " + map);

        for(Map.Entry<String , Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        for(String key : map.keySet()){
            System.out.println("Key: " +key + ", Value: " +map.get(key));
        }
        Set<String> keys = map.keySet();
        System.out.println("Keys: " + keys);

        Collection<Integer> values = map.values();
        System.out.println("Values: "+ values);

        int size = map.size();
        System.out.println("Size of map: " + size);

       // Map<Integer, String> treeMap = new TreeMap<>(map);
       // System.out.println("Sorted by key: " + treeMap);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        System.out.println("Sorted by value:");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }



    }
}

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class BasicMap {

    public static void main(String[] args) {
//        Unordered
//        Not synchronized (not thread-safe)
//        Allows one null key and multiple null values

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Shariful Hasan");
        map.put(2, "Jehadul Hoque");
        map.put(3, "Anamul Haque");
        map.put(4, "Jahangir Alam");
        map.put(5, "Sajjad Hossain");
        map.put(6, "Partha Debnath");
        map.put(7, "Aslam Bagh");
        map.put(null, "Unknown");
        map.put(8, null);

        System.out.println("HashMap: " + map);

        System.out.println("Value for key 2: " + map.get(2));

        map.remove(3);
        System.out.println("After removing key 3: " + map);

        // Iterating
        System.out.println("\nIterating key-value pairs:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }



//        Everything behaves like HashMap but keeps insertion order
//        Useful for caches or recently used lists

        Map<Integer, String> map2 = new LinkedHashMap<>();

        map2.put(1, "Shariful Hasan");
        map2.put(2, "Jehadul Hoque");
        map2.put(3, "Aslam Bagh");
        map2.put(4, "Jahangir Alam");
        map2.put(5, "Partha Debnath");
        map2.put(6, "Sajjad Hossain");
        map2.put(7, "Anamul Haque");
        map2.put(null, "Unknown");
        map2.put(8, null);

        System.out.println("HashMap: " + map);

        System.out.println("Value for key 2: " + map.get(2));

        map.remove(3);
        System.out.println("After removing key 3: " + map);

        // Iterating
        System.out.println("\nIterating key-value pairs:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

//        Keys are sorted naturally or via Comparator
//        Null keys are not allowed, but null values are fine

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Anamul Haque");
        treeMap.put(1, "Sajjad Hossain");
        treeMap.put(2, "Aslam Bagh");

        System.out.println("TreeMap: " + treeMap);

//        Thread-Safe Maps
//        Hashtable → Legacy, synchronized, slower
//        ConcurrentHashMap → Modern thread-safe map, better performance than Hashtable

        Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(1, "Shariful Hasan");
        concurrentMap.put(2, "Jehadul Hoque");
        concurrentMap.forEach((k, v) -> System.out.println(k + " -> " + v));



//  Implementation      | Key Order       | Null Allowed                        | Notes
//    HashMap           | No              | key: 1 null, value: multiple null   | Most used, fast O(1) average
//    LinkedHashMap     | Insertion order | key: 1 null, value: multiple null   | Preserves insertion order
//    TreeMap           | Sorted by key   | null key: , value: multiple null  | Keys sorted naturally or via comparator
//    Hashtable         | No              | no                                  | Legacy, synchronized (thread-safe)
//    ConcurrentHashMap | No              | no                                  | Thread-safe, high-performance

    }
}

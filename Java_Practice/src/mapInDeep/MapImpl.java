package mapInDeep;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapImpl {
    public static void main(String[] args) {
//        HashMap uses a hash table + linked list
//        Insertion: O(1) average
//        Deletion: O(1) average
//        Search: O(1) average
//        Order: Unordered

        Map<Department, List<Employee>> deptEmployees = new HashMap<>();

        deptEmployees.put(new Department("HR"), Arrays.asList(
                new Employee(1, "Sabuj", 50000),
                new Employee(2, "Anik", 52000)
        ));

        deptEmployees.put(new Department("IT"), Arrays.asList(
                new Employee(3, "Charlie", 70000),
                new Employee(4, "Diana", 75000)
        ));

        deptEmployees.put(new Department("IT"), Arrays.asList(
                new Employee(3, "Charlie", 70000)
        ));

        for (Map.Entry<Department, List<Employee>> entry : deptEmployees.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


//        LinkedHashMap = Hash table + Doubly Linked List
//        Insertion: O(1)
//        Deletion: O(1)
//        Search: O(1)
//        Order: Maintains insertion order

        Map<Department, List<Employee>> linkedDeptEmployees = new LinkedHashMap<>();
        linkedDeptEmployees.put(new Department("Finance"), Arrays.asList(
                new Employee(5, "Eve", 60000),
                new Employee(6, "Frank", 61000)
        ));
        linkedDeptEmployees.put(new Department("Operations"), Arrays.asList(
                new Employee(7, "Grace", 55000),
                new Employee(8, "Henry", 56000)
        ));


        System.out.println("\n=== LinkedHashMap (insertion order) ===");
        linkedDeptEmployees.forEach((dept, empList) ->
                System.out.println(dept + " -> " + empList));


        //        TreeMap = Red-Black Tree (self-balancing BST)
//        Insertion: O(log n)
//        Deletion: O(log n)
//        Search: O(log n)
//        Order: Sorted by key (natural or comparator)


        Map<Department, List<Employee>> treeDeptEmployees = new TreeMap<>();
        treeDeptEmployees.put(new Department("Admin"), Arrays.asList(
                new Employee(9, "Ivy", 48000),
                new Employee(10, "Jack", 49000)
        ));
        treeDeptEmployees.put(new Department("Sales"), Arrays.asList(
                new Employee(11, "Kim", 65000),
                new Employee(12, "Leo", 64000)
        ));

        treeDeptEmployees.put(new Department("Finance"), Arrays.asList(
                new Employee(5, "Eve", 60000),
                new Employee(6, "Frank", 61000)
        ));
        treeDeptEmployees.put(new Department("Operations"), Arrays.asList(
                new Employee(7, "Grace", 55000),
                new Employee(8, "Henry", 56000)
        ));

        System.out.println("\n=== TreeMap (sorted by key) ===");
        treeDeptEmployees.forEach((dept, empList) ->
                System.out.println(dept + " -> " + empList));


        Map<Department, List<Employee>> reverseTree = new TreeMap<>(Comparator.reverseOrder());

        reverseTree.putAll(treeDeptEmployees);

        System.out.println("\nDescending Department Order:");
        for (Map.Entry<Department, List<Employee>> entry : reverseTree.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        Map<Department, List<Employee>> lengthComparatorMap =
                new TreeMap<>((d1, d2) -> {
                    int result = Integer.compare(d1.getName().length(), d2.getName().length());
                    return (result != 0) ? result : d1.getName().compareTo(d2.getName());
                });
        lengthComparatorMap.putAll(treeDeptEmployees);


        System.out.println("\nDepartments Sorted by Name Length:");
        for (Map.Entry<Department, List<Employee>> entry : lengthComparatorMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        Map<Department, List<Employee>> caseInsensitiveMap =
                new TreeMap<>((d1, d2) -> d1.getName().compareToIgnoreCase(d2.getName()));

        caseInsensitiveMap.putAll(treeDeptEmployees);

        System.out.println("\nCase-Insensitive Department Order:");
        for (Map.Entry<Department, List<Employee>> entry : caseInsensitiveMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }



        //  Hashtable = legacy synchronized hash table
//        Insertion: O(1)
//        Deletion: O(1)
//        Search: O(1)
//        Thread-safe: Yes (synchronized on each method)
//        Null keys/values: Not allowed

        Map<String, List<Employee>> hashtableDept = new Hashtable<>();
        hashtableDept.put("Logistics", Arrays.asList(
                new Employee(13, "Mona", 52000)
        ));
        hashtableDept.put("Support", Arrays.asList(
                new Employee(14, "Nina", 50000)
        ));

        System.out.println("\n=== Hashtable (synchronized) ===");
        hashtableDept.forEach((dept, empList) ->
                System.out.println(dept + " -> " + empList));


//        ConcurrentHashMap = segmented hash table
//        Insertion: O(1)
//        Deletion: O(1)
//        Search: O(1)
//        Thread-safe: Yes (no locking entire map)
//        Null keys/values: Not allowed

        Map<String, List<Employee>> concurrentDept = new ConcurrentHashMap<>();
        concurrentDept.put("Research", Arrays.asList(
                new Employee(15, "Olive", 88000),
                new Employee(16, "Paul", 86000)
        ));

        System.out.println("\n=== ConcurrentHashMap (thread-safe, high performance) ===");
        concurrentDept.forEach((dept, empList) ->
                System.out.println(dept + " -> " + empList));


//        HashMap → default choice for most lookups
//        LinkedHashMap → when order of insertion matters (e.g., caching)
//        TreeMap → when sorted keys are required (e.g., storing departments alphabetically)
//        Hashtable → legacy code; prefer not to use
//        ConcurrentHashMap → when multiple threads modify data safely

    }
}

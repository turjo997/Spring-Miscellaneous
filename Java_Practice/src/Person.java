import java.util.*;

public class Person implements Comparable<Person>{

    private int id;
    private String name;

    Person(String name ,int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof  Person)){
            return false;
        }
        Person p = (Person) o;
        return this.id == p.id && Objects.equals(this.name , p.name);
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.id, o.id);
    }

    public static void main(String[] args) {

//  Set Type        | Order           | Allows Null | Duplicates | Internal Structure
//  HashSet         | No              | Yes         | No         | Hash table
//  LinkedHashSet   | Insertion order | Yes         | No         | Hash table + Linked list
//  TreeSet**       | Sorted          | No          | No         | TreeMap (Red-Black tree)




//        HashSet is built on top of HashMap
//        It stores elements in hash buckets using the element’s
//        hashCode() and equals() methods
//        That’s how it ensures uniqueness
//        if two objects have the same hash and are equal, one of them won’t be added


        Set<Person> people = new HashSet<>();

        people.add(new Person("Jack" ,1));
        people.add(new Person("Jack",1));

        System.out.println(people);

        for(Person p : people){
            System.out.println(p.id + " " + p.name);
        }




//        LinkedHashSet is almost identical to HashSet except for one
//        major feature — it remembers insertion order
//        So while a HashSet just cares about uniqueness and hashing,
//        a LinkedHashSet keeps an internal linked list that preserves
//        the order you added elements in

//        Set<Person> linkedSet = new LinkedHashSet<>();
//
//        linkedSet.add(new Person("Riaz", 1));
//        linkedSet.add(new Person("Anik", 2));
//        linkedSet.add(new Person("Karim", 3));
//        linkedSet.add(new Person("Anik", 2));  // duplicate ignored
//        linkedSet.add(new Person("Bappa", 4));
//
//        System.out.println("LinkedHashSet content (in insertion order):");
//        linkedSet.forEach(System.out::println);
//        System.out.println("\nIterating using Iterator:");
//
//        Iterator<Person> iterator = linkedSet.iterator();
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("\nAfter adding one more element:");
//        linkedSet.add(new Person("Joy", 5));
//        linkedSet.forEach(System.out::println);

        Set<Person> treeSet = new TreeSet<>();

        treeSet.add(new Person("Charlie", 3));
        treeSet.add(new Person("Anik", 1));
        treeSet.add(new Person("Adam", 2));
        treeSet.add(new Person("Joy", 4));

        System.out.println("TreeSet (sorted by ID):");
        treeSet.forEach(System.out::println);


        Comparator<Person> byName = (p1, p2) -> p1.name.compareTo(p2.name);

        Set<Person> treeSet2 = new TreeSet<>(byName);

        treeSet2.add(new Person("Ullash", 3));
        treeSet2.add(new Person("Anik", 1));
        treeSet2.add(new Person("Priya", 2));
        treeSet2.add(new Person("Joy", 4));

        System.out.println("TreeSet (sorted by name):");
        treeSet2.forEach(System.out::println);
    }
}

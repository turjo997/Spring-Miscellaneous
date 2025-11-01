import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class ThreadSafeTreeSetExample {
    public static void main(String[] args) {
        SortedSet<Integer>  sortedSet = new TreeSet<>();
        sortedSet.add(10);
        sortedSet.add(5);
        sortedSet.add(20);

        System.out.println("Regular TreeSet: " + sortedSet);

        SortedSet<Integer> synchronizedSet = Collections.synchronizedSortedSet(sortedSet);

        Runnable addTask = () ->{
            for(int i = 0; i < 5; i++){
                synchronizedSet.add(i*10);
                System.out.println(Thread.currentThread().getName() + " added " + i*10);
            }
        };

        Thread thread1 = new Thread(addTask);
        Thread thread2 = new Thread(addTask);

        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Thread-safe TreeSet: " + synchronizedSet);

        synchronized(synchronizedSet) {
            for (Integer i : synchronizedSet) {
                System.out.println(i);
            }
        }

    }
}

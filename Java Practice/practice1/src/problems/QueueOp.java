package problems;

import java.util.*;

public class QueueOp {
    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedList<>();
//
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        queue.offer(40);
//
//        System.out.println(queue);
//
//        while (!queue.isEmpty()){
//            int x = queue.poll();
//            System.out.println("Poll item is : "+x);
//            //queue.poll();
//        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.offer(300);
        pq.offer(60);

        System.out.println("Priority Queue: " + pq); // Order not guaranteed

        while (!pq.isEmpty()) {
            System.out.println("Polled Element: " + pq.poll()); // Sorted order: 10, 20, 30
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq2.offer(10);
        pq2.offer(300);
        pq2.offer(60);

        System.out.println("Priority Queue: " + pq2); // Order not guaranteed

        while (!pq2.isEmpty()) {
            System.out.println("Polled Element: " + pq2.poll()); // Sorted order: 10, 20, 30
        }


        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerFirst(10);
        dq.offerFirst(40);
        dq.offerFirst(70);
        dq.offerLast(100);
        dq.offerLast(200);
        dq.offerLast(300);
        System.out.println("Deque : " +dq);
        System.out.println("Remove from front : "+dq.pollFirst());
        System.out.println("Remove from Rear : "+dq.pollLast());
    }
}

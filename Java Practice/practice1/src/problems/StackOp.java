package problems;

import java.util.Stack;

public class StackOp {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Size : " + stack.size());
        int position = stack.search(30);
        if (position != -1) {
            System.out.println("Element 30 found at position: " + position);
        } else {
            System.out.println("Element not found.");
        }
//        while (!stack.empty()) {
//            int item = stack.peek();
//            System.out.println("Item is: " + item);
//            stack.pop();
//        }


        for(int num : stack){
            System.out.println(num);
        }
    }
}

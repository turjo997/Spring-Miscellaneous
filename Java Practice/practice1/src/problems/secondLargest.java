package problems;

import java.util.Scanner;

public class secondLargest {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; ++i) {
//            arr[i] = sc.nextInt();
//        }
//
//        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
//
//        for (int i = 0; i < n; ++i) {
//            if (arr[i] < largest) {
//                secondLargest = arr[i];
//                largest = arr[i];
//            } else {
//                if (arr[i] > secondLargest && arr[i] != largest) {
//                    secondLargest = arr[i];
//                }
//            }
//        }
//
//        if (secondLargest == Integer.MIN_VALUE) {
//            System.out.println("No second largest element found.");
//        } else {
//            System.out.println("Second Largest Element: " + secondLargest);
//        }


        int[] arr = {12, 35, 1, 10, 34, 1};

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first; // Update second largest
                first = num;    // Update largest
            } else if (num > second && num != first) {
                second = num;
            }
        }
        if (second == Integer.MIN_VALUE) {
            System.out.println("No second largest element found.");
        } else {
            System.out.println("Second Largest Element: " + second);
        }
    }
}

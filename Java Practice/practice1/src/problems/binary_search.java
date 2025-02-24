package problems;

import java.util.Arrays;
import java.util.Scanner;

public class binary_search {

    public static int iterative(int[] ar, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == ar[mid]) {
                return mid;
            } else if (key < ar[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int recursive(int[] ar, int low, int high, int key) {
        if (low == high) {
            if (ar[low] == key) {
                return low;
            }
            return -1;
        }
        int mid = (low + high) / 2;
        if (key == ar[mid]) {
            return mid;
        } else if (key < ar[mid]) {
            return recursive(ar, low, mid - 1, key);
        } else {
            return recursive(ar, mid + 1, high, key);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; ++i) {
            ar[i] = sc.nextInt();
        }

        Arrays.sort(ar);
        int res = iterative(ar, 0, n - 1, 400);

        if (res == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found ar index : " + res);
        }


        int res2 = recursive(ar, 0, n - 1, 400);

        if (res2 == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index : " + res2);
        }

    }
}

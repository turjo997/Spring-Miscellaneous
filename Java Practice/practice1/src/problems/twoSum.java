package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tar = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);
        int i = 0, j = arr.size() - 1;

        while (i < n && j >=0) {
            if (arr.get(i) + arr.get(j) == tar) {
                System.out.println(i + " " + j);
                break;
            } else if (arr.get(i) + arr.get(j) < tar) {
                   ++i;
            } else {
                  --j;
            }
        }


    }
}

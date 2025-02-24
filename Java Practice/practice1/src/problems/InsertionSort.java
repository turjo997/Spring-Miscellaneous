package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int [] arr = new int[n];
//
//        for(int i = 0; i < n ; ++i){
//            arr[i]  = sc.nextInt();
//        }
//        for(int i = 1 ; i < n ; ++i){
//            int item = arr[i];
//            int j = i-1;
//            while(j >= 0 && arr[j] > item){
//                arr[j+1] = arr[j];
//                --j;
//            }
//            arr[j+1] = item;
//        }
//        for(int num : arr){
//            System.out.println(num);
//        }

        List<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            arrList.add(sc.nextInt());
        }

        for (int i = 1; i < n; ++i) {
            int item = arrList.get(i);
            int j = i - 1;
            while (j >= 0 && arrList.get(j) > item) {
                arrList.set(j + 1, arrList.get(j));
                --j;
            }
            arrList.set(j + 1, item);
        }
        for (int num : arrList) {
            System.out.println(num);
        }


    }
}

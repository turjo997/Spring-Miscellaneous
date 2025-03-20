package problems;

import java.util.Arrays;
import java.util.Scanner;

public class removeDuplicates {

    public static int remove(int [] ar){
        Arrays.sort(ar);
        int ind = 1;
        for(int i = 1 ; i < ar.length ; ++i){
            if(ar[i] != ar[i-1]){
                ar[ind++] = ar[i];
            }
        }
        return ind;
    }

    public static int tortoiseApproach(int [] ar){
        int slow = 0 , fast = 0;
        do {
            slow = ar[slow];
            fast = ar[ar[fast]];
        }while (slow != fast);

        slow = 0;

        while(slow != fast){
            slow = ar[slow];
            fast = ar[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] ar = new int[n];
        for(int i = 0 ; i < n ; ++i){
            ar[i] = sc.nextInt();
        }
        //int index = remove(ar);

//        for(int i = 0 ; i < index ; ++i){
//            System.out.println(ar[i]);
//        }

        System.out.println("Duplicate element is : " +tortoiseApproach(ar));
    }
}

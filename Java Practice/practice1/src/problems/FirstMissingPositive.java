package problems;

import java.util.Scanner;

public class FirstMissingPositive {

    public static int missingPositive(int [] ar){
        int n = ar.length;
        for(int i = 0 ; i < n ; ++i){
            int element = ar[i];
            if(element > 0  && element <=n){
                int chair = element - 1;
                if(ar[chair] != element){
                    swap(ar , chair, i);
                    --i;
                }
            }
        }
        for(int i = 0 ; i < n ; ++i){
            if(i + 1 != ar[i]){
                return i + 1;
            }
        }
        return n + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] ar = new int[n];
        for(int i = 0 ; i < n ; ++i){
            ar[i] = sc.nextInt();
        }

        System.out.println(FirstMissingPositive.missingPositive(ar));
    }

    private static void swap(int [] ar , int a ,  int b) {
          int tmp = ar[a];
          ar[a] = ar[b];
          ar[b]  = tmp;
    }
}
